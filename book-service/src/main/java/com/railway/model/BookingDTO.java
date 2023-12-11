package com.railway.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {

    private Long bookingId;

    @NotNull(message = "Booking's user email can't be empty")
    private String userEmail;

    private Long seatId;

    private Long carriageId;

    private Long trainId;

    private Timestamp bookingDate;

    private BookingStatus status;
}
