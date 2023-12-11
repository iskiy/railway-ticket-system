// Code generated by sqlc. DO NOT EDIT.
// versions:
//   sqlc v1.24.0
// source: trains.sql

package sqlc

import (
	"context"
	"time"
)

const createTrain = `-- name: CreateTrain :one
INSERT INTO trains (train_name, start_station_id, departure_time, finish_station_id, arrival_time)
VALUES ($1, $2, $3, $4, $5)
RETURNING train_id
`

type CreateTrainParams struct {
	TrainName       string    `json:"train_name"`
	StartStationID  int32     `json:"start_station_id"`
	DepartureTime   time.Time `json:"departure_time"`
	FinishStationID int32     `json:"finish_station_id"`
	ArrivalTime     time.Time `json:"arrival_time"`
}

func (q *Queries) CreateTrain(ctx context.Context, arg CreateTrainParams) (int64, error) {
	row := q.db.QueryRowContext(ctx, createTrain,
		arg.TrainName,
		arg.StartStationID,
		arg.DepartureTime,
		arg.FinishStationID,
		arg.ArrivalTime,
	)
	var train_id int64
	err := row.Scan(&train_id)
	return train_id, err
}

const deleteTrain = `-- name: DeleteTrain :exec
DELETE FROM trains
WHERE train_id = $1
`

func (q *Queries) DeleteTrain(ctx context.Context, trainID int64) error {
	_, err := q.db.ExecContext(ctx, deleteTrain, trainID)
	return err
}

const getTrain = `-- name: GetTrain :one
SELECT train_id, train_name, start_station_id, departure_time, finish_station_id, arrival_time FROM trains
WHERE train_id = $1
LIMIT 1
`

func (q *Queries) GetTrain(ctx context.Context, trainID int64) (Train, error) {
	row := q.db.QueryRowContext(ctx, getTrain, trainID)
	var i Train
	err := row.Scan(
		&i.TrainID,
		&i.TrainName,
		&i.StartStationID,
		&i.DepartureTime,
		&i.FinishStationID,
		&i.ArrivalTime,
	)
	return i, err
}

const getTrainIDsWithAvailableSeats = `-- name: GetTrainIDsWithAvailableSeats :many
SELECT DISTINCT t.train_id
FROM trains t
         JOIN stations ss ON t.start_station_id = ss.station_id
         JOIN stations fs ON t.finish_station_id = fs.station_id
         JOIN cars c ON t.train_id = c.train_id
         JOIN seats s ON c.car_id = s.car_id
WHERE ss.station_name = $1
  AND fs.station_name = $2
  AND s.is_available = true
  AND DATE(t.departure_time) = $3
`

type GetTrainIDsWithAvailableSeatsParams struct {
	StationName   string    `json:"station_name"`
	StationName_2 string    `json:"station_name_2"`
	DepartureTime time.Time `json:"departure_time"`
}

func (q *Queries) GetTrainIDsWithAvailableSeats(ctx context.Context, arg GetTrainIDsWithAvailableSeatsParams) ([]int64, error) {
	rows, err := q.db.QueryContext(ctx, getTrainIDsWithAvailableSeats, arg.StationName, arg.StationName_2, arg.DepartureTime)
	if err != nil {
		return nil, err
	}
	defer rows.Close()
	items := []int64{}
	for rows.Next() {
		var train_id int64
		if err := rows.Scan(&train_id); err != nil {
			return nil, err
		}
		items = append(items, train_id)
	}
	if err := rows.Close(); err != nil {
		return nil, err
	}
	if err := rows.Err(); err != nil {
		return nil, err
	}
	return items, nil
}

const getTrains = `-- name: GetTrains :many
SELECT train_id, train_name, start_station_id, departure_time, finish_station_id, arrival_time FROM trains
LIMIT $1
OFFSET $2
`

type GetTrainsParams struct {
	Limit  int32 `json:"limit"`
	Offset int32 `json:"offset"`
}

func (q *Queries) GetTrains(ctx context.Context, arg GetTrainsParams) ([]Train, error) {
	rows, err := q.db.QueryContext(ctx, getTrains, arg.Limit, arg.Offset)
	if err != nil {
		return nil, err
	}
	defer rows.Close()
	items := []Train{}
	for rows.Next() {
		var i Train
		if err := rows.Scan(
			&i.TrainID,
			&i.TrainName,
			&i.StartStationID,
			&i.DepartureTime,
			&i.FinishStationID,
			&i.ArrivalTime,
		); err != nil {
			return nil, err
		}
		items = append(items, i)
	}
	if err := rows.Close(); err != nil {
		return nil, err
	}
	if err := rows.Err(); err != nil {
		return nil, err
	}
	return items, nil
}

const getTrainsWithAvailableSeats = `-- name: GetTrainsWithAvailableSeats :many
SELECT DISTINCT t.train_id,
                t.train_name,
                ss.station_name,
                fs.station_name,
                t.arrival_time,
                t.departure_time
FROM trains t
         JOIN stations ss ON t.start_station_id = ss.station_id
         JOIN stations fs ON t.finish_station_id = fs.station_id
         JOIN cars c ON t.train_id = c.train_id
         JOIN seats s ON c.car_id = s.car_id
WHERE ss.station_id = $1
  AND fs.station_id = $2
  AND s.is_available = true
  AND DATE(t.departure_time) = $3
`

type GetTrainsWithAvailableSeatsParams struct {
	StationID     int32     `json:"station_id"`
	StationID_2   int32     `json:"station_id_2"`
	DepartureTime time.Time `json:"departure_time"`
}

type GetTrainsWithAvailableSeatsRow struct {
	TrainID       int64     `json:"train_id"`
	TrainName     string    `json:"train_name"`
	StationName   string    `json:"station_name"`
	StationName_2 string    `json:"station_name_2"`
	ArrivalTime   time.Time `json:"arrival_time"`
	DepartureTime time.Time `json:"departure_time"`
}

func (q *Queries) GetTrainsWithAvailableSeats(ctx context.Context, arg GetTrainsWithAvailableSeatsParams) ([]GetTrainsWithAvailableSeatsRow, error) {
	rows, err := q.db.QueryContext(ctx, getTrainsWithAvailableSeats, arg.StationID, arg.StationID_2, arg.DepartureTime)
	if err != nil {
		return nil, err
	}
	defer rows.Close()
	items := []GetTrainsWithAvailableSeatsRow{}
	for rows.Next() {
		var i GetTrainsWithAvailableSeatsRow
		if err := rows.Scan(
			&i.TrainID,
			&i.TrainName,
			&i.StationName,
			&i.StationName_2,
			&i.ArrivalTime,
			&i.DepartureTime,
		); err != nil {
			return nil, err
		}
		items = append(items, i)
	}
	if err := rows.Close(); err != nil {
		return nil, err
	}
	if err := rows.Err(); err != nil {
		return nil, err
	}
	return items, nil
}

const updateTrain = `-- name: UpdateTrain :exec
UPDATE trains
SET train_name = $2, start_station_id = $3, departure_time = $4, finish_station_id = $5, arrival_time = $6
WHERE train_id = $1
`

type UpdateTrainParams struct {
	TrainID         int64     `json:"train_id"`
	TrainName       string    `json:"train_name"`
	StartStationID  int32     `json:"start_station_id"`
	DepartureTime   time.Time `json:"departure_time"`
	FinishStationID int32     `json:"finish_station_id"`
	ArrivalTime     time.Time `json:"arrival_time"`
}

func (q *Queries) UpdateTrain(ctx context.Context, arg UpdateTrainParams) error {
	_, err := q.db.ExecContext(ctx, updateTrain,
		arg.TrainID,
		arg.TrainName,
		arg.StartStationID,
		arg.DepartureTime,
		arg.FinishStationID,
		arg.ArrivalTime,
	)
	return err
}