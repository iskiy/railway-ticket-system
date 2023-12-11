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

INSERT INTO stations (station_name) VALUES ('Central Station');
INSERT INTO stations (station_name) VALUES ('North Station');
INSERT INTO stations (station_name) VALUES ('South Station');

INSERT INTO trains (train_name, start_station_id, departure_time, finish_station_id, arrival_time)
VALUES ('Train A', 1, '2023-12-12 09:00:00+00', 2, '2023-12-12 12:00:00+00');

INSERT INTO trains (train_name, start_station_id, departure_time, finish_station_id, arrival_time)
VALUES ('Train B', 2, '2023-12-13 15:00:00+00', 3, '2023-12-13 18:00:00+00');

INSERT INTO cars (car_type, train_id) VALUES ('First Class', 1);
INSERT INTO cars (car_type, train_id) VALUES ('Economy', 1);

INSERT INTO cars (car_type, train_id) VALUES ('First Class', 2);
INSERT INTO cars (car_type, train_id) VALUES ('Economy', 2);

-- For Car 1
INSERT INTO seats (seat_number, car_id, is_available, price) VALUES ('1A', 1, TRUE, 100);
INSERT INTO seats (seat_number, car_id, is_available, price) VALUES ('1B', 1, TRUE, 100);

-- For Car 2
INSERT INTO seats (seat_number, car_id, is_available, price) VALUES ('2A', 2, TRUE, 80);
INSERT INTO seats (seat_number, car_id, is_available, price) VALUES ('2B', 2, TRUE, 80);

-- For Car 3
INSERT INTO seats (seat_number, car_id, is_available, price) VALUES ('3A', 3, TRUE, 100);
INSERT INTO seats (seat_number, car_id, is_available, price) VALUES ('3B', 3, TRUE, 100);

-- For Car 4
INSERT INTO seats (seat_number, car_id, is_available, price) VALUES ('4A', 4, TRUE, 80);
INSERT INTO seats (seat_number, car_id, is_available, price) VALUES ('4B', 4, TRUE, 80);