package com.railway.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;

@Entity
@Table(name = "payment")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", unique = true)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long paymentId;

    @Column(name = "train_id", nullable = false)
    @JdbcTypeCode(SqlTypes.DECIMAL)
    private Long amount;

    @Column(name = "payment_timestamp", nullable = false)
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    private Timestamp paymentTimestamp;

    @Column(name = "method", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String method;

    @Column(name = "status")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String status;
}
