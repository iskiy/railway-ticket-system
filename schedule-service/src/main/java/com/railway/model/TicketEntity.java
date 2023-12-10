package com.railway.model;

import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id", unique = true)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long ticketId;

    @Column(name = "train_id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long trainId;

    @Column(name = "journey_date", nullable = false)
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    private Timestamp journeyDate;

    @Column(name = "arrival_station", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String arrivalStation;

    @Column(name = "departure_station", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String departureStation;

    @Column(name = "carriage_id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long carriageId;

    @Column(name = "price", nullable = false)
    @JdbcTypeCode(SqlTypes.DECIMAL)
    private Long price;

    @Column(name = "seat_id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Long seatId;

    @Column(name = "payment_id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Long paymentId;
}
