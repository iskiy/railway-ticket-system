package seat

import (
	"context"
	"database/sql"
	"fmt"
	"log"
	"net"

	"github.com/iskiy/railway-ticket-system/train-service/internal/psql/sqlc"
	"github.com/iskiy/railway-ticket-system/train-service/protogen"
	"google.golang.org/grpc"
	"google.golang.org/grpc/codes"
	"google.golang.org/grpc/reflection"
	"google.golang.org/grpc/status"
)

type SeatReservationServer struct {
	protogen.UnimplementedSeatReservationServer
	Repo *sqlc.Queries
	Conn *sql.DB
}

func StartServer(seatService *SeatReservationServer, port string) error {
	lis, err := net.Listen("tcp", ":9090")
	if err != nil {
		return err
	}
	s := grpc.NewServer()
	protogen.RegisterSeatReservationServer(s, seatService)
	reflection.Register(s)

	if err := s.Serve(lis); err != nil {
		return err
	}

	return nil
}

func (s *SeatReservationServer) CheckSeatAvailabilityAndReserve(ctx context.Context,
	req *protogen.CheckSeatAvailabilityAndReserveRequest) (*protogen.CheckSeatAvailabilityAndReserveResponse, error) {
	seatID := req.SeatId
	isAvailable, err := s.checkSeatAndSetUnv(ctx, int64(seatID))
	if err != nil {
		return nil, status.Errorf(
			codes.Internal,
			fmt.Sprintf("error: %d"),
		)
	}
	return &protogen.CheckSeatAvailabilityAndReserveResponse{
		IsAvailable: isAvailable,
	}, nil

}

func (s *SeatReservationServer) checkSeatAndSetUnv(ctx context.Context, seatID int64) (bool, error) {
	isAvailable := false

	tx, err := s.Conn.BeginTx(context.Background(), nil)
	if err != nil {
		return false, err
	}
	q := s.Repo.WithTx(tx)

	seat, err := q.GetSeat(ctx, seatID)
	if err != nil {
		if rbErr := tx.Rollback(); rbErr != nil {
			log.Fatalf("get seat error: %v, unable to rollback: %v", err, rbErr)
		}
		return false, err
	}
	if seat.IsAvailable == true {
		param := sqlc.UpdateSeatAvailabilityParams{
			SeatID:      seatID,
			IsAvailable: false}

		err := q.UpdateSeatAvailability(ctx, param)
		if err != nil {
			if rbErr := tx.Rollback(); rbErr != nil {
				log.Fatalf("update seat error: %v, unable to rollback: %v", err, rbErr)
			}
			return false, err
		}
		isAvailable = true
	}

	if err := tx.Commit(); err != nil {
		return false, err
	}

	return isAvailable, nil
}
