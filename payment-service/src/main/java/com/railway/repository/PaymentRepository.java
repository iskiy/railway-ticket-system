package com.railway.repository;

import com.railway.model.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    List<PaymentEntity> findAllByStatus(String status);

    List<PaymentEntity> findAllByMethod(String method);

    List<PaymentEntity> findAllByAmount(Long amount);

    List<PaymentEntity> findAllByAmountIsBetween(Long startAmount, Long endAmount);

    List<PaymentEntity> findAllByPaymentTimestamp(Timestamp timestamp);

    List<PaymentEntity> findAllByPaymentTimestamp_Date(int paymentTimestamp_date);

    List<PaymentEntity> findAllByPaymentTimestamp_Year(int paymentTimestamp_year);

    List<PaymentEntity> findAllByPaymentTimestamp_Month(int paymentTimestamp_month);
}
