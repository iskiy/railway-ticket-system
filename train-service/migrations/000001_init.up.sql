CREATE TABLE IF NOT EXISTS trains (
                                      train_id BIGSERIAL PRIMARY KEY,
                                      train_name VARCHAR(60) NOT NULL
    );

CREATE TABLE IF NOT EXISTS carriages (
                                         carriage_id BIGSERIAL PRIMARY KEY,
                                         carriage_type VARCHAR(20) NOT NULL,
    train_id BIGINT NOT NULL REFERENCES trains(train_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );

CREATE TABLE IF NOT EXISTS seats (
                                     seat_id BIGSERIAL PRIMARY KEY,
                                     seat_number VARCHAR(3) NOT NULL,
    carriage_id BIGINT NOT NULL REFERENCES carriages(carriage_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );