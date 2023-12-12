package dbpopulator

import (
	"context"
	"log"
	"math/rand"
	"strconv"
	"time"

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
	trainNum := 100
	seatNums := 10
	stations := CreateStation(100)
	for i, s := range stations {
		id, err := p.Repo.CreateStation(context.Background(), s.StationName)
		if err != nil {
			log.Fatalln(err)
		}
		stations[i].StationID = id
	}

	trainsAmount := 100
	carsAmount := 10
	for i := 0; i < trainsAmount; i++ {
		train := rest.CreateTrainWithFullInfoRequest{}
		train.TrainName = "Train " + strconv.Itoa(i)
		startStation, finishStation := pickStations(stations)
		train.StartStation = startStation.StationID
		train.FinishStation = finishStation.StationID
		train.ArrivalTime = time.Now().AddDate(0, 0, 1).Add(6 * time.Hour)
		train.DepartureTime = time.Now().AddDate(0, 0, 1)
		id, err := p.Repo.CreateTrain(context.Background(), sqlc.CreateTrainParams{
			TrainName:       train.TrainName,
			StartStationID:  train.StartStation,
			DepartureTime:   train.DepartureTime,
			FinishStationID: train.FinishStation,
			ArrivalTime:     train.ArrivalTime,
		})
		if err != nil {
			log.Fatalln(err)
		}
		train.TrainID = id
		cars := make([]rest.Car, carsAmount)
		for j, c := range cars {
			cars[j].CarType = "comfort"
			carID, err := p.Repo.CreateCar(context.Background(), sqlc.CreateCarParams{CarType: c.CarType, TrainID: train.TrainID})
			if err != nil {
				log.Fatalln(err)
			}
			cars[].CarID = carID
			seats := make([]sqlc.Seat, seatNums)
			for k, s := range seats {

			}
		}
	}

}

func pickStations(stations []sqlc.Station) (sqlc.Station, sqlc.Station) {
	rand.Seed(time.Now().UnixNano())
	start := rand.Intn(len(stations))
	finish := rand.Intn(len(stations) - 1)
	if start >= finish {
		finish++
	}
	return stations[start], stations[finish]
}

func CreateStation(n int) []sqlc.Station {
	stations := make([]sqlc.Station, n)
	for i := 0; i <= n; i++ {
		stations[i].StationName = "Station " + strconv.Itoa(i)
	}
}
