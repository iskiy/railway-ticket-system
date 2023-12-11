-- name: CreateCar :one
INSERT INTO cars (car_type, train_id)
VALUES ($1, $2)
RETURNING car_id;

-- name: GetCar :one
SELECT *
FROM cars
WHERE car_id = $1
LIMIT 1;

-- name: GetTrainCars :many
SELECT *
FROM cars
WHERE train_id = $1
ORDER BY car_id;

-- name: DeleteCar :exec
DELETE FROM cars
WHERE car_id = $1;