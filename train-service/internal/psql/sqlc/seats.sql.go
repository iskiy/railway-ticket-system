// Code generated by sqlc. DO NOT EDIT.
// versions:
//   sqlc v1.24.0
// source: seats.sql

package sqlc

import (
	"context"
)

const createSeat = `-- name: CreateSeat :one
INSERT INTO seats (seat_number, car_id, is_available, price)
VALUES ($1, $2, $3, $4)
RETURNING seat_id
`

type CreateSeatParams struct {
	SeatNumber  string `json:"seat_number"`
	CarID       int64  `json:"car_id"`
	IsAvailable bool   `json:"is_available"`
	Price       int32  `json:"price"`
}

func (q *Queries) CreateSeat(ctx context.Context, arg CreateSeatParams) (int64, error) {
	row := q.db.QueryRowContext(ctx, createSeat,
		arg.SeatNumber,
		arg.CarID,
		arg.IsAvailable,
		arg.Price,
	)
	var seat_id int64
	err := row.Scan(&seat_id)
	return seat_id, err
}

const deleteSeat = `-- name: DeleteSeat :exec
DELETE FROM seats
WHERE seat_id = $1
`

func (q *Queries) DeleteSeat(ctx context.Context, seatID int64) error {
	_, err := q.db.ExecContext(ctx, deleteSeat, seatID)
	return err
}

const getSeat = `-- name: GetSeat :one
SELECT seat_id, seat_number, car_id, is_available, price FROM seats
WHERE seat_id = $1
LIMIT 1
`

func (q *Queries) GetSeat(ctx context.Context, seatID int64) (Seat, error) {
	row := q.db.QueryRowContext(ctx, getSeat, seatID)
	var i Seat
	err := row.Scan(
		&i.SeatID,
		&i.SeatNumber,
		&i.CarID,
		&i.IsAvailable,
		&i.Price,
	)
	return i, err
}

const getSeatsByCar = `-- name: GetSeatsByCar :many
SELECT seat_id, seat_number, car_id, is_available, price FROM seats
WHERE car_id = $1
`

func (q *Queries) GetSeatsByCar(ctx context.Context, carID int64) ([]Seat, error) {
	rows, err := q.db.QueryContext(ctx, getSeatsByCar, carID)
	if err != nil {
		return nil, err
	}
	defer rows.Close()
	items := []Seat{}
	for rows.Next() {
		var i Seat
		if err := rows.Scan(
			&i.SeatID,
			&i.SeatNumber,
			&i.CarID,
			&i.IsAvailable,
			&i.Price,
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

const updateSeat = `-- name: UpdateSeat :exec
UPDATE seats
SET seat_number = $2, car_id = $3, is_available = $4, price = $5
WHERE seat_id = $1
`

type UpdateSeatParams struct {
	SeatID      int64  `json:"seat_id"`
	SeatNumber  string `json:"seat_number"`
	CarID       int64  `json:"car_id"`
	IsAvailable bool   `json:"is_available"`
	Price       int32  `json:"price"`
}

func (q *Queries) UpdateSeat(ctx context.Context, arg UpdateSeatParams) error {
	_, err := q.db.ExecContext(ctx, updateSeat,
		arg.SeatID,
		arg.SeatNumber,
		arg.CarID,
		arg.IsAvailable,
		arg.Price,
	)
	return err
}

const updateSeatAvailability = `-- name: UpdateSeatAvailability :exec
UPDATE seats
SET is_available = $2
WHERE seat_id = $1
`

type UpdateSeatAvailabilityParams struct {
	SeatID      int64 `json:"seat_id"`
	IsAvailable bool  `json:"is_available"`
}

func (q *Queries) UpdateSeatAvailability(ctx context.Context, arg UpdateSeatAvailabilityParams) error {
	_, err := q.db.ExecContext(ctx, updateSeatAvailability, arg.SeatID, arg.IsAvailable)
	return err
}
