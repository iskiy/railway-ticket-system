package rest

import (
	"strconv"
	"time"

	"github.com/gofiber/fiber/v2"
	"github.com/iskiy/railway-ticket-system/train-service/internal/psql/sqlc"
)

type TrainManagerHandler struct {
	Repo *sqlc.Queries
}

func New(repo *sqlc.Queries) *TrainManagerHandler {
	return &TrainManagerHandler{Repo: repo}
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

	stationID, err := t.Repo.CreateStation(c.Context(), req.StationName)
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
	err = t.Repo.DeleteStation(c.Context(), int32(id))
	if err != nil {
		return fiber.NewError(fiber.StatusInternalServerError, "delete station error")
	}

	return c.SendStatus(fiber.StatusOK)
}

func (t *TrainManagerHandler) GetStation(c *fiber.Ctx) error {
	idParam := c.Params("id")
	id, err := strconv.Atoi(idParam)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad station id")
	}

	station, err := t.Repo.GetStation(c.Context(), int32(id))
	if err != nil {
		return fiber.NewError(fiber.StatusInternalServerError, "get station error")
	}

	return c.Status(fiber.StatusOK).JSON(station)
}

func (t *TrainManagerHandler) GetStations(c *fiber.Ctx) error {
	limitParam := c.Query("limit")
	limit, err := strconv.Atoi(limitParam)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad limit param")
	}

	offsetParam := c.Query("offset")
	offset, err := strconv.Atoi(offsetParam)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad offset param")
	}

	stations, err := t.Repo.GetStations(c.Context(), sqlc.GetStationsParams{
		Limit:  int32(limit),
		Offset: int32(offset),
	})

	if err != nil {
		return fiber.NewError(fiber.StatusInternalServerError, "get station error")
	}

	return c.Status(fiber.StatusOK).JSON(stations)
}

type CreateTrainResponse struct {
	TrainID int64 `json:"train_id"`
}

func (t *TrainManagerHandler) CreateTrain(c *fiber.Ctx) error {
	isFullInfoParam := c.Query("is_full")

	isFullInfo, err := strconv.ParseBool(isFullInfoParam)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad full info query param")
	}
	if isFullInfo {
		return t.CreateTrainWithFullInfo(c)
	}

	req := sqlc.CreateTrainParams{}
	err = c.BodyParser(&req)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "parse body error")
	}

	trainID, err := t.Repo.CreateTrain(c.Context(), req)
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
	err = t.Repo.DeleteTrain(c.Context(), int64(id))
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

	trainID, err := t.Repo.CreateCar(c.Context(), req)
	if err != nil {
		return err
	}

	return c.Status(fiber.StatusOK).JSON(CreateCarResponse{
		CarID: trainID,
	})
}

func (t *TrainManagerHandler) GetTrainCars(c *fiber.Ctx) error {
	idParam := c.Params("id")
	id, err := strconv.Atoi(idParam)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad train id")
	}

	cars, err := t.Repo.GetTrainCars(c.Context(), int64(id))
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad cars id")
	}
	return c.Status(fiber.StatusOK).JSON(cars)
}

func (t *TrainManagerHandler) GetCar(c *fiber.Ctx) error {
	idParam := c.Params("id")
	id, err := strconv.Atoi(idParam)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad car id")
	}

	car, err := t.Repo.GetCar(c.Context(), int64(id))
	if err != nil {
		return fiber.NewError(fiber.StatusInternalServerError, "get car error")
	}

	return c.Status(fiber.StatusOK).JSON(car)
}

func (t *TrainManagerHandler) DeleteCar(c *fiber.Ctx) error {
	idParam := c.Params("id")
	id, err := strconv.Atoi(idParam)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad car id")
	}
	err = t.Repo.DeleteCar(c.Context(), int64(id))
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

	trainID, err := t.Repo.CreateSeat(c.Context(), req)
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
	err = t.Repo.DeleteSeat(c.Context(), int64(id))
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

	trainIDs, err := t.Repo.GetTrainIDsWithAvailableSeats(c.Context(), req)
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
	TrainID       int64        `json:"train_id,omitempty"`
	TrainName     string       `json:"train_name"`
	StartStation  sqlc.Station `json:"start_station"`
	DepartureTime time.Time    `json:"departure_time"`
	FinishStation sqlc.Station `json:"finish_station"`
	ArrivalTime   time.Time    `json:"arrival_time"`
	Cars          []Car        `json:"cars"`
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

func (t *TrainManagerHandler) GetTrains(c *fiber.Ctx) error {
	limitParam := c.Query("limit")
	limit, err := strconv.Atoi(limitParam)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad limit param")
	}

	offsetParam := c.Query("offset")
	offset, err := strconv.Atoi(offsetParam)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad offset param")
	}

	isFullInfoParam := c.Query("is_full")
	isFullInfo, err := strconv.ParseBool(isFullInfoParam)
	if err != nil {
		return fiber.NewError(fiber.StatusBadRequest, "bad full info query param")
	}

	trains, err := t.Repo.GetTrainsWithStations(c.Context(), sqlc.GetTrainsWithStationsParams{
		Limit:  int32(limit),
		Offset: int32(offset),
	})
	if err != nil {
		return fiber.NewError(fiber.StatusInternalServerError, "get trains error")
	}

	if isFullInfo {
		return t.getTrainsFullInfo(c, trains)
	}

	return c.Status(fiber.StatusOK).JSON(trains)
}

func (t *TrainManagerHandler) getTrainsFullInfo(c *fiber.Ctx, trains []sqlc.GetTrainsWithStationsRow) error {
	trainFullInfos := make([]TrainFullInfo, len(trains))
	for k, train := range trains {
		trainFullInfo := TrainFullInfo{
			TrainID:   train.TrainID,
			TrainName: train.TrainName,
			StartStation: sqlc.Station{
				StationID:   train.StartStationID,
				StationName: train.FinishStationName,
			},
			FinishStation: sqlc.Station{
				StationID:   train.FinishStationID,
				StationName: train.FinishStationName,
			},
			DepartureTime: train.DepartureTime,
			ArrivalTime:   train.ArrivalTime,
		}

		cars, err := t.Repo.GetTrainCars(c.Context(), train.TrainID)
		if err != nil {
			return fiber.NewError(fiber.StatusInternalServerError, "get cars from db error")
		}

		trainFullInfo.Cars = make([]Car, len(cars))

		for i, car := range cars {
			trainFullInfo.Cars[i].CarID = car.CarID
			trainFullInfo.Cars[i].CarType = car.CarType

			seats, err := t.Repo.GetSeatsByCar(c.Context(), car.CarID)
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

	return c.Status(fiber.StatusOK).JSON(trainFullInfos)
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

	trains, err := t.Repo.GetTrainsWithAvailableSeats(c.Context(), req)
	if err != nil {
		return fiber.NewError(fiber.StatusInternalServerError, "get train from db error")
	}

	return t.getTrainsFullInfo(c, convertToTrainsWithStation(trains))
}

func convertToTrainsWithStation(row []sqlc.GetTrainsWithAvailableSeatsRow) []sqlc.GetTrainsWithStationsRow {
	trainsWithStation := make([]sqlc.GetTrainsWithStationsRow, len(row))
	for i, r := range row {
		trainsWithStation[i] = sqlc.GetTrainsWithStationsRow(r)
	}
	return trainsWithStation
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

	trainID, err := t.Repo.CreateTrain(c.Context(), sqlc.CreateTrainParams{
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
		carID, err := t.Repo.CreateCar(c.Context(), sqlc.CreateCarParams{
			CarType: car.CarType,
			TrainID: trainID,
		})
		if err != nil {
			return fiber.NewError(fiber.StatusInternalServerError, "create car error")
		}
		req.Cars[i].CarID = carID
		for j, seat := range req.Cars[i].Seats {
			seatID, err := t.Repo.CreateSeat(c.Context(), sqlc.CreateSeatParams{
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
