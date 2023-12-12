package populator

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

func (p *DBPopulator) PopulateDB() {
	stations := CreateStation(100)
	for i, s := range stations {
		id, err := p.Repo.CreateStation(context.Background(), s.StationName)
		if err != nil {
			log.Fatalln(err)
		}
		stations[i].StationID = id
	}

	trainsAmount := 100
	seatNums := 10
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
		for j, _ := range cars {
			cars[j].CarType = "comfort"
			carID, err := p.Repo.CreateCar(context.Background(), sqlc.CreateCarParams{CarType: cars[j].CarType, TrainID: train.TrainID})
			if err != nil {
				log.Fatalln(err)
			}
			cars[j].CarID = carID
			seats := make([]sqlc.Seat, seatNums)
			for k, _ := range seats {
				seats[k].Price = 100
				seats[k].CarID = carID
				seats[k].SeatNumber = strconv.Itoa(k)
				seats[k].IsAvailable = true
				_, err = p.Repo.CreateSeat(context.Background(), sqlc.CreateSeatParams{
					SeatNumber: seats[k].SeatNumber,
				})
				if err != nil {
					log.Fatalln(err)
				}
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
