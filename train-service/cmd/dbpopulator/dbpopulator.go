package dbpopulator

import (
	"context"
	"log"
	"math/rand"
	"strconv"

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

func (p *DBPopulator) PopulateDB() {
	train := rest.CreateTrainWithFullInfoRequest{}

	stations := CreateStation(100)
	for i, s := range stations {
		id, err := p.Repo.CreateStation(context.Background(), s.StationName)
		if err != nil {
			log.Fatalln(err)
		}
		stations[i].StationID = id
	}

}

func pickTwoRandomElements(slice []int) (int, int, error) {
	i := rand.Intn(len(slice))
	j := rand.Intn(len(slice) - 1)
	if j >= i {
		j++
	}
	return slice[i], slice[j], nil
}

func CreateStation(n int) []sqlc.Station {
	stations := make([]sqlc.Station, n)
	for i := 0; i <= n; i++ {
		stations[i].StationName = "Station " + strconv.Itoa(i)
	}
}
