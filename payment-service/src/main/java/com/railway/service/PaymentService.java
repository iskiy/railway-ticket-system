package com.railway.service;

import com.railway.model.PaymentDTO;
import com.railway.model.PaymentEntity;
import com.railway.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Transactional
    public PaymentEntity createPayment(PaymentDTO ticket) {
        PaymentEntity newPayment = PaymentEntity.builder()
                .paymentId(ticket.getPaymentId())
                .amount(ticket.getAmount())
                .paymentTimestamp(ticket.getPaymentTimestamp())
                .method(ticket.getMethod())
                .status(ticket.getStatus())
                .build();

        return paymentRepository.saveAndFlush(newPayment);
    }

    @Transactional
    public List<PaymentEntity> findAllPayments() {
        return paymentRepository.findAll();
    }

    @Transactional
    public List<PaymentEntity> findAllByStatus(String status) {
        return paymentRepository.findAllByStatus(status);
    }

    @Transactional
    public PaymentEntity getPaymentById(Long id) {
        Optional<PaymentEntity> optionalTicket = paymentRepository.findById(id);

        return optionalTicket
                .orElse(null);
    }

    @Transactional
    public List<PaymentEntity> findAllByMethod(String method) {
        return paymentRepository.findAllByMethod(method);
    }

    @Transactional
    public List<PaymentEntity> findAllByAmount(Long amount) {
        return paymentRepository.findAllByAmount(amount);
    }

    @Transactional
    public List<PaymentEntity> findAllByAmountIsBetween(Long startAmount, Long endAmount) {
        return paymentRepository.findAllByAmountIsBetween(startAmount, endAmount);
    }

    @Transactional
    public List<PaymentEntity> findAllByPaymentTimestamp(Timestamp timestamp) {
        return paymentRepository.findAllByPaymentTimestamp(timestamp);
    }

    @Transactional
    public List<PaymentEntity> findAllByPaymentTimestamp_Date(int paymentTimestamp_date) {
        return paymentRepository.findAllByPaymentTimestamp_Date(paymentTimestamp_date);
    }

    @Transactional
    public List<PaymentEntity> findAllByPaymentTimestamp_Year(int paymentTimestamp_year) {
        return paymentRepository.findAllByPaymentTimestamp_Year(paymentTimestamp_year);
    }

    @Transactional
    public List<PaymentEntity> findAllByPaymentTimestamp_Month(int paymentTimestamp_month) {
        return paymentRepository.findAllByPaymentTimestamp_Month(paymentTimestamp_month);
    }

}
