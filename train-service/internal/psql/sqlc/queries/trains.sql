-- name: CreateTrain :one
INSERT INTO trains (train_name, start_station_id, departure_time, finish_station_id, arrival_time)
VALUES ($1, $2, $3, $4, $5)
RETURNING train_id;

-- name: GetTrain :one
SELECT * FROM trains
WHERE train_id = $1
LIMIT 1;

-- name: GetTrains :many
SELECT * FROM trains
LIMIT $1
OFFSET $2;

-- name: UpdateTrain :exec
UPDATE trains
SET train_name = $2, start_station_id = $3, departure_time = $4, finish_station_id = $5, arrival_time = $6
WHERE train_id = $1;

-- name: DeleteTrain :exec
DELETE FROM trains
WHERE train_id = $1;

-- name: GetTrainIDsWithAvailableSeats :many
SELECT DISTINCT t.train_id
FROM trains t
         JOIN stations ss ON t.start_station_id = ss.station_id
         JOIN stations fs ON t.finish_station_id = fs.station_id
         JOIN cars c ON t.train_id = c.train_id
         JOIN seats s ON c.car_id = s.car_id
WHERE ss.station_name = $1
  AND fs.station_name = $2
  AND s.is_available = true
  AND DATE(t.departure_time) = $3;


-- name: GetTrainsWithAvailableSeats :many
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
  AND DATE(t.departure_time) = $3;