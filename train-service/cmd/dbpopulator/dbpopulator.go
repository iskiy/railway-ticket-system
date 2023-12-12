package dbpopulator

import (
	"fmt"

	"github.com/gofiber/fiber/v2"
	"github.com/iskiy/railway-ticket-system/train-service/internal/delivery/rest"
	"github.com/iskiy/railway-ticket-system/train-service/internal/psql/sqlc"
)

type DBPopulator struct {
	Repo *sqlc.Queries
}


//func CreateTrains() {
//	req := rest.CreateTrainWithFullInfoRequest{}
//	err := c.BodyParser(&req)
//	if err != nil {
//		return fiber.NewError(fiber.StatusBadRequest, "parse body error")
//	}
//
//	trainID, err := t.Repo.CreateTrain(c.Context(), sqlc.CreateTrainParams{
//		TrainName:       req.TrainName,
//		StartStationID:  req.StartStation,
//		DepartureTime:   req.DepartureTime,
//		FinishStationID: req.FinishStation,
//		ArrivalTime:     req.ArrivalTime,
//	})
//	if err != nil {
//		return fiber.NewError(fiber.StatusInternalServerError, fmt.Sprintf("create train error: %v", err))
//	}
//	req.TrainID = trainID
//	for i, car := range req.Cars {
//		carID, err := t.Repo.CreateCar(c.Context(), sqlc.CreateCarParams{
//			CarType: car.CarType,
//			TrainID: trainID,
//		})
//		if err != nil {
//			return fiber.NewError(fiber.StatusInternalServerError, "create car error")
//		}
//		req.Cars[i].CarID = carID
//		for j, seat := range req.Cars[i].Seats {
//			seatID, err := t.Repo.CreateSeat(c.Context(), sqlc.CreateSeatParams{
//				CarID:       carID,
//				SeatNumber:  seat.SeatNumber,
//				IsAvailable: false,
//				Price:       int32(seat.Price),
//			})
//			if err != nil {
//				return fiber.NewError(fiber.StatusInternalServerError, "create seat error")
//			}
//			req.Cars[i].Seats[j].SeatID = seatID
//		}
//	}
//
//	return c.Status(fiber.StatusOK).JSON(req)
//}

func PopulateDB(){
	train := rest.CreateTrainWithFullInfoRequest{}

	stationsNames :=

}

func CreateStation(n int)[]sqlc.Station{
	stations := make([]sqlc.Station, n)
	for i := 0; i <= n; i++{
		stations[i] =
	}
}