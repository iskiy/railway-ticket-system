CREATE TABLE IF NOT EXISTS tickets (
                                      ticket_id BIGSERIAL PRIMARY KEY,
                                      train_id BIGINT NOT NULL,
                                      journey_date TIMESTAMP NOT NULL,
                                      arrival_station VARCHAR(60) NOT NULL,
                                      departure_station VARCHAR(60) NOT NULL,
                                      carriage_id BIGINT NOT NULL,
                                      price DECIMAL NOT NULL,
                                      seat_id BIGINT NOT NULL,
                                      payment_id BIGINT NOT NULL
    );