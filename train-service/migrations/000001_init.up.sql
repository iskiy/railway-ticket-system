CREATE TABLE IF NOT EXISTS stations (
                                    station_id SERIAL PRIMARY KEY,
                                    station_name VARCHAR(60) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS trains (
                                    train_id BIGSERIAL PRIMARY KEY,
                                    train_name VARCHAR(60) NOT NULL,
                                    start_station_id INT NOT NULL REFERENCES stations(station_id),
                                    departure_time TIMESTAMPTZ NOT NULL,
                                    finish_station_id INT NOT NULL REFERENCES stations(station_id),
                                    arrival_time TIMESTAMPTZ NOT NULL
);

CREATE TABLE IF NOT EXISTS cars (
                                    car_id BIGSERIAL PRIMARY KEY,
                                    car_type VARCHAR(20) NOT NULL,
                                    train_id BIGINT NOT NULL REFERENCES trains(train_id)
);

CREATE TABLE IF NOT EXISTS seats (
                                    seat_id BIGSERIAL PRIMARY KEY,
                                    seat_number VARCHAR(3) NOT NULL,
                                    car_id BIGINT NOT NULL REFERENCES cars(car_id),
                                    is_available BOOLEAN NOT NULL,
                                    price INT NOT NULL,
                                    UNIQUE (car_id, seat_number)
);