-- name: CreateStation :one
INSERT INTO stations (station_name)
VALUES ($1)
RETURNING station_id;

-- name: GetStation :one
SELECT * FROM stations
WHERE station_id = $1
LIMIT 1;

-- name: GetStationByName :one
SELECT * FROM stations
WHERE station_name = $1
LIMIT 1;

-- name: GetStations :many
SELECT * FROM stations
ORDER BY station_id
LIMIT $1
OFFSET $2;

-- name: DeleteStation :exec
DELETE FROM stations
WHERE station_id = $1;
