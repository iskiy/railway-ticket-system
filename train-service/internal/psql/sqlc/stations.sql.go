// Code generated by sqlc. DO NOT EDIT.
// versions:
//   sqlc v1.24.0
// source: stations.sql

package sqlc

import (
	"context"
)

const createStation = `-- name: CreateStation :one
INSERT INTO stations (station_name)
VALUES ($1)
RETURNING station_id
`

func (q *Queries) CreateStation(ctx context.Context, stationName string) (int32, error) {
	row := q.db.QueryRowContext(ctx, createStation, stationName)
	var station_id int32
	err := row.Scan(&station_id)
	return station_id, err
}

const deleteStation = `-- name: DeleteStation :exec
DELETE FROM stations
WHERE station_id = $1
`

func (q *Queries) DeleteStation(ctx context.Context, stationID int32) error {
	_, err := q.db.ExecContext(ctx, deleteStation, stationID)
	return err
}

const getStation = `-- name: GetStation :one
SELECT station_id, station_name FROM stations
WHERE station_id = $1
LIMIT 1
`

func (q *Queries) GetStation(ctx context.Context, stationID int32) (Station, error) {
	row := q.db.QueryRowContext(ctx, getStation, stationID)
	var i Station
	err := row.Scan(&i.StationID, &i.StationName)
	return i, err
}

const getStationByName = `-- name: GetStationByName :one
SELECT station_id, station_name FROM stations
WHERE station_name = $1
LIMIT 1
`

func (q *Queries) GetStationByName(ctx context.Context, stationName string) (Station, error) {
	row := q.db.QueryRowContext(ctx, getStationByName, stationName)
	var i Station
	err := row.Scan(&i.StationID, &i.StationName)
	return i, err
}

const getStations = `-- name: GetStations :many
SELECT station_id, station_name FROM stations
LIMIT $1
OFFSET $2
`

type GetStationsParams struct {
	Limit  int32 `json:"limit"`
	Offset int32 `json:"offset"`
}

func (q *Queries) GetStations(ctx context.Context, arg GetStationsParams) ([]Station, error) {
	rows, err := q.db.QueryContext(ctx, getStations, arg.Limit, arg.Offset)
	if err != nil {
		return nil, err
	}
	defer rows.Close()
	items := []Station{}
	for rows.Next() {
		var i Station
		if err := rows.Scan(&i.StationID, &i.StationName); err != nil {
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
