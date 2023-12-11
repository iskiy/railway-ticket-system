package com.railway.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;

@Entity
@Table(name = "booking")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", unique = true)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long bookingId;

    @Column(name = "user_email", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String userEmail;

    @Column(name = "seat_id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long seatId;

    @Column(name = "carriage_id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long carriageId;

    @Column(name = "train_id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long trainId;

    @Column(name = "booking_date", nullable = false)
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    private Timestamp bookingDate;

    @Column(name = "status")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private BookingStatus status;
}
