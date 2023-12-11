CREATE TABLE IF NOT EXISTS booking (
                                      booking_id BIGSERIAL PRIMARY KEY,
                                      user_email VARCHAR(60) NOT NULL,
                                      seat_id BIGINT NOT NULL,
--                                       carriage_id BIGINT NOT NULL,
--                                       train_id BIGINT NOT NULL,
                                      booking_date TIMESTAMP NOT NULL,
                                      price BIGINT NOT NULL,
                                      status VARCHAR(60) NOT NULL
    );