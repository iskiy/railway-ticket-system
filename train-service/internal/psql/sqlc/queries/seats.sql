-- name: CreateSeat :one
INSERT INTO seats (seat_number, car_id, is_available, price)
VALUES ($1, $2, $3, $4)
RETURNING seat_id;

-- name: GetSeat :one
SELECT * FROM seats
WHERE seat_id = $1
LIMIT 1;

-- name: GetSeatsByCar :many
SELECT * FROM seats
WHERE car_id = $1;

-- name: UpdateSeatAvailability :exec
UPDATE seats
SET is_available = $2
WHERE seat_id = $1;

-- name: DeleteSeat :exec
DELETE FROM seats
WHERE seat_id = $1;

-- name: UpdateSeat :exec
UPDATE seats
SET seat_number = $2, car_id = $3, is_available = $4, price = $5
WHERE seat_id = $1;

