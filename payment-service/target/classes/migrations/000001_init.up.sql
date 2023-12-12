CREATE TABLE IF NOT EXISTS payment (
                                      payment_id BIGSERIAL PRIMARY KEY,
                                      amount DECIMAL NOT NULL,
                                      payment_timestamp TIMESTAMP NOT NULL,
                                      method VARCHAR(60) NOT NULL,
                                      status VARCHAR(60) NOT NULL
    );