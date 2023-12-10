package rest

import (
	"strconv"
	"time"

	"github.com/gofiber/fiber/v2"
	"github.com/iskiy/railway-ticket-system/train-service/internal/psql/sqlc"
)

type TrainManagerHandler struct {
	repo *sqlc.Queries
}

type CreateStationRequest struct {
	StationName string `json:"station_name"`
}

type CreateStationResponse struct {
	StationID int32 `json:"station_id"`
}

func (t *TrainManagerHandler) CreateStation(c *fiber.Ctx) error {
	req := CreateStationRequest{}
	err := c.BodyParser(&req)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "parse body error")
	}

	stationID, err := t.repo.CreateStation(c.Context(), req.StationName)
	if err != nil {
		return err
	}

	return c.Status(fiber.StatusOK).JSON(CreateStationResponse{
		StationID: stationID,
	})
}

func (t *TrainManagerHandler) DeleteStation(c *fiber.Ctx) error {
	idParam := c.Params("id")
	id, err := strconv.Atoi(idParam)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad station id")
	}
	err = t.repo.DeleteStation(c.Context(), int32(id))
	if err != nil {
		return fiber.NewError(fiber.StatusInternalServerError, "delete station error")
	}

	return c.SendStatus(fiber.StatusOK)
}

type CreateTrainResponse struct {
	TrainID int64 `json:"train_id"`
}

func (t *TrainManagerHandler) CreateTrain(c *fiber.Ctx) error {
	req := sqlc.CreateTrainParams{}
	err := c.BodyParser(&req)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "parse body error")
	}

	trainID, err := t.repo.CreateTrain(c.Context(), req)
	if err != nil {
		return err
	}

	return c.Status(fiber.StatusOK).JSON(CreateTrainResponse{
		TrainID: trainID,
	})
}

func (t *TrainManagerHandler) DeleteTrain(c *fiber.Ctx) error {
	idParam := c.Params("id")
	id, err := strconv.Atoi(idParam)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad train id")
	}
	err = t.repo.DeleteTrain(c.Context(), int64(id))
	if err != nil {
		return fiber.NewError(fiber.StatusInternalServerError, "delete train error")
	}

	return c.SendStatus(fiber.StatusOK)
}

type CreateCarResponse struct {
	CarID int64 `json:"car_id"`
}

func (t *TrainManagerHandler) CreateCar(c *fiber.Ctx) error {
	req := sqlc.CreateCarParams{}
	err := c.BodyParser(&req)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "parse body error")
	}

	trainID, err := t.repo.CreateCar(c.Context(), req)
	if err != nil {
		return err
	}

	return c.Status(fiber.StatusOK).JSON(CreateCarResponse{
		CarID: trainID,
	})
}

func (t *TrainManagerHandler) DeleteCar(c *fiber.Ctx) error {
	idParam := c.Params("id")
	id, err := strconv.Atoi(idParam)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad car id")
	}
	err = t.repo.DeleteCar(c.Context(), int64(id))
	if err != nil {
		return fiber.NewError(fiber.StatusInternalServerError, "delete car error")
	}

	return c.SendStatus(fiber.StatusOK)
}

type CreateSeatResponse struct {
	SeatID int64 `json:"seat_id"`
}

func (t *TrainManagerHandler) CreateSeat(c *fiber.Ctx) error {
	req := sqlc.CreateSeatParams{}
	err := c.BodyParser(&req)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "parse body error")
	}

	trainID, err := t.repo.CreateSeat(c.Context(), req)
	if err != nil {
		return err
	}

	return c.Status(fiber.StatusOK).JSON(CreateSeatResponse{
		SeatID: trainID,
	})
}

func (t *TrainManagerHandler) DeleteSeat(c *fiber.Ctx) error {
	idParam := c.Params("id")
	id, err := strconv.Atoi(idParam)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad seat id")
	}
	err = t.repo.DeleteSeat(c.Context(), int64(id))
	if err != nil {
		return fiber.NewError(fiber.StatusInternalServerError, "delete seat error")
	}

	return c.SendStatus(fiber.StatusOK)
}

type GetTrainIDsWithAvailableSeatsResponse struct {
	TrainIDs []int64 `json:"train_ids"`
}

func (t *TrainManagerHandler) GetTrainIDsWithAvailableSeats(c *fiber.Ctx) error {
	c.Query("start")
	req := sqlc.GetTrainIDsWithAvailableSeatsParams{}
	err := c.BodyParser(&req)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "parse body error")
	}

	trainIDs, err := t.repo.GetTrainIDsWithAvailableSeats(c.Context(), req)
	if err != nil {
		return err
	}

	return c.Status(fiber.StatusOK).JSON(GetTrainIDsWithAvailableSeatsResponse{
		TrainIDs: trainIDs,
	})
}

type GetTrainsWithAvailableSeatsResponse struct {
	TrainFullInfo []TrainFullInfo `json:"trains"`
}

type TrainFullInfo struct {
	TrainID       int64     `json:"train_id,omitempty"`
	TrainName     string    `json:"train_name"`
	StartStation  string    `json:"start_station"`
	DepartureTime time.Time `json:"departure_time"`
	FinishStation string    `json:"finish_station"`
	ArrivalTime   time.Time `json:"arrival_time"`
	Cars          []Car     `json:"cars"`
}

type Car struct {
	CarID   int64  `json:"car_id,omitempty"`
	CarType string `json:"car_type"`
	Seats   []Seat `json:"seats"`
}

type Seat struct {
	SeatID      int64  `json:"seat_id,omitempty"`
	SeatNumber  string `json:"seat_number"`
	IsAvailable bool   `json:"is_available"`
	Price       int    `json:"price"`
}

func (t *TrainManagerHandler) GetTrainsWithAvailableSeats(c *fiber.Ctx) error {
	startStationIDParam := c.Query("from_id")
	finishStationIDParam := c.Query("from_id")
	date := c.Query("departure_date")

	dateTime, err := ParseDate(date)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad departure_date")
	}
	if IsDateNotInPast(dateTime) {
		return fiber.NewError(fiber.StatusBadRequest, "bad departure_date")
	}

	startStationID, err := strconv.Atoi(startStationIDParam)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad from_id")
	}

	finishStationID, err := strconv.Atoi(finishStationIDParam)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad to_id")
	}

	req := sqlc.GetTrainsWithAvailableSeatsParams{
		StationID:     int32(startStationID),
		StationID_2:   int32(finishStationID),
		DepartureTime: dateTime,
	}
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "parse body error")
	}

	trains, err := t.repo.GetTrainsWithAvailableSeats(c.Context(), req)
	if err != nil {
		return fiber.NewError(fiber.StatusInternalServerError, "get train from db error")
	}
	trainFullInfos := make([]TrainFullInfo, len(trains))

	for k, train := range trains {
		trainFullInfo := TrainFullInfo{
			TrainID:       train.TrainID,
			TrainName:     train.TrainName,
			StartStation:  train.StationName,
			FinishStation: train.StationName_2,
			DepartureTime: train.DepartureTime,
			ArrivalTime:   train.ArrivalTime,
		}

		cars, err := t.repo.GetTrainCars(c.Context(), train.TrainID)
		if err != nil {
			return fiber.NewError(fiber.StatusInternalServerError, "get cars from db error")
		}

		trainFullInfo.Cars = make([]Car, len(cars))

		for i, car := range cars {
			trainFullInfo.Cars[i].CarID = car.CarID
			trainFullInfo.Cars[i].CarType = car.CarType

			seats, err := t.repo.GetSeatsByCar(c.Context(), car.CarID)
			if err != nil {
				return fiber.NewError(fiber.StatusInternalServerError, "get cars from db error")
			}
			trainFullInfo.Cars[i].Seats = make([]Seat, len(seats))
			for j, seat := range seats {
				trainFullInfo.Cars[i].Seats[j].SeatID = seat.SeatID
				trainFullInfo.Cars[i].Seats[j].IsAvailable = seat.IsAvailable
				trainFullInfo.Cars[i].Seats[j].SeatNumber = seat.SeatNumber
				trainFullInfo.Cars[i].Seats[j].Price = int(seat.Price)
			}
		}

		trainFullInfos[k] = trainFullInfo
	}

	return c.Status(fiber.StatusOK).JSON(GetTrainsWithAvailableSeatsResponse{
		TrainFullInfo: trainFullInfos,
	})
}

type CreateTrainWithFullInfoRequest struct {
	TrainID       int64     `json:"train_id,omitempty"`
	TrainName     string    `json:"train_name"`
	StartStation  int32     `json:"start_station_id"`
	DepartureTime time.Time `json:"departure_time"`
	FinishStation int32     `json:"finish_station_id"`
	ArrivalTime   time.Time `json:"arrival_time"`
	Cars          []Car     `json:"cars"`
}

func (t *TrainManagerHandler) CreateTrainWithFullInfo(c *fiber.Ctx) error {
	req := CreateTrainWithFullInfoRequest{}
	err := c.BodyParser(&req)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "parse body error")
	}

	trainID, err := t.repo.CreateTrain(c.Context(), sqlc.CreateTrainParams{
		TrainName:       req.TrainName,
		StartStationID:  req.StartStation,
		DepartureTime:   req.DepartureTime,
		FinishStationID: req.FinishStation,
		ArrivalTime:     req.ArrivalTime,
	})
	if err != nil {
		return fiber.NewError(fiber.StatusInternalServerError, "create train error")
	}
	req.TrainID = trainID
	for i, car := range req.Cars {
		carID, err := t.repo.CreateCar(c.Context(), sqlc.CreateCarParams{
			CarType: car.CarType,
			TrainID: trainID,
		})
		if err != nil {
			return fiber.NewError(fiber.StatusInternalServerError, "create car error")
		}
		req.Cars[i].CarID = carID
		for j, seat := range req.Cars[i].Seats {
			seatID, err := t.repo.CreateSeat(c.Context(), sqlc.CreateSeatParams{
				CarID:       carID,
				SeatNumber:  seat.SeatNumber,
				IsAvailable: false,
				Price:       int32(seat.Price),
			})
			if err != nil {
				return fiber.NewError(fiber.StatusInternalServerError, "create seat error")
			}
			req.Cars[i].Seats[j].SeatID = seatID
		}
	}

	return c.Status(fiber.StatusOK).JSON(req)
}

func IsDateNotInPast(date time.Time) bool {
	return time.Now().Sub(date) < time.Hour*24
}

func ParseDate(date string) (time.Time, error) {
	parsedTime, err := time.Parse("2006-01-02", date)
	if err != nil {
		return time.Time{}, err
	}
	return parsedTime, nil
}
