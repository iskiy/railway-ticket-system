// Code generated by sqlc. DO NOT EDIT.
// versions:
//   sqlc v1.24.0

package sqlc

import (
	"time"
)

type Car struct {
	CarID   int64  `json:"car_id"`
	CarType string `json:"car_type"`
	TrainID int64  `json:"train_id"`
}

type Seat struct {
	SeatID      int64  `json:"seat_id"`
	SeatNumber  string `json:"seat_number"`
	CarID       int64  `json:"car_id"`
	IsAvailable bool   `json:"is_available"`
	Price       int32  `json:"price"`
}

type Station struct {
	StationID   int32  `json:"station_id"`
	StationName string `json:"station_name"`
}

type Train struct {
	TrainID         int64     `json:"train_id"`
	TrainName       string    `json:"train_name"`
	StartStationID  int32     `json:"start_station_id"`
	DepartureTime   time.Time `json:"departure_time"`
	FinishStationID int32     `json:"finish_station_id"`
	ArrivalTime     time.Time `json:"arrival_time"`
}