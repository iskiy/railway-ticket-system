package com.railway.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.railway.model.AmountBetweenDTO;
import com.railway.service.PaymentService;
import lombok.RequiredArgsConstructor;
import com.railway.model.PaymentDTO;
import com.railway.model.PaymentEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final ObjectMapper objectMapper;
    private final PaymentService paymentService;

    private final Random random = new Random();

    @RequestMapping(value = "/payment/status", method = RequestMethod.GET)
    public ResponseEntity<String> getPaymentByStatus(@RequestBody final String status) throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        paymentService.findAllByStatus(status).stream().map(
                                paymentEntity -> new PaymentDTO(
                                        paymentEntity.getPaymentId(),
                                        paymentEntity.getAmount(),
                                        paymentEntity.getPaymentTimestamp(),
                                        paymentEntity.getMethod(),
                                        paymentEntity.getStatus()
                                )
                        ).toList()
                )
        );
    }

    @RequestMapping(value = "/payment/method", method = RequestMethod.GET)
    public ResponseEntity<String> getPaymentByMethod(@RequestBody final String method) throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        paymentService.findAllByMethod(method).stream().map(
                                paymentEntity -> new PaymentDTO(
                                        paymentEntity.getPaymentId(),
                                        paymentEntity.getAmount(),
                                        paymentEntity.getPaymentTimestamp(),
                                        paymentEntity.getMethod(),
                                        paymentEntity.getStatus()
                                        )
                        ).toList()
                )
        );
    }

    @RequestMapping(value = "/payment/amount", method = RequestMethod.GET)
    public ResponseEntity<String> getPaymentByAmountIsBetween(@RequestBody final AmountBetweenDTO amount) throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        paymentService.findAllByAmountIsBetween(amount.getStartAmount(), amount.getEndAmount())
                                .stream().map(
                                paymentEntity -> new PaymentDTO(
                                        paymentEntity.getPaymentId(),
                                        paymentEntity.getAmount(),
                                        paymentEntity.getPaymentTimestamp(),
                                        paymentEntity.getMethod(),
                                        paymentEntity.getStatus()
                                        )
                        ).toList()
                )
        );
    }

    @RequestMapping(value = "/payment/timestamp", method = RequestMethod.GET)
    public ResponseEntity<String> getPaymentByTimestamp(@RequestBody final Timestamp timestamp) throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        paymentService.findAllByPaymentTimestamp(timestamp)
                                .stream().map(
                                        paymentEntity -> new PaymentDTO(
                                                paymentEntity.getPaymentId(),
                                                paymentEntity.getAmount(),
                                                paymentEntity.getPaymentTimestamp(),
                                                paymentEntity.getMethod(),
                                                paymentEntity.getStatus()
                                                )
                                ).toList()
                )
        );
    }

    @RequestMapping(value = "/payment/timestamp_date", method = RequestMethod.GET)
    public ResponseEntity<String> getPaymentByTimestamp_Date(@RequestBody final int timestamp_date) throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        paymentService.findAllByPaymentTimestamp_Date(timestamp_date)
                                .stream().map(
                                        paymentEntity -> new PaymentDTO(
                                                paymentEntity.getPaymentId(),
                                                paymentEntity.getAmount(),
                                                paymentEntity.getPaymentTimestamp(),
                                                paymentEntity.getMethod(),
                                                paymentEntity.getStatus()
                                                )
                                ).toList()
                )
        );
    }

    @RequestMapping(value = "/payment/timestamp_year", method = RequestMethod.GET)
    public ResponseEntity<String> getPaymentByTimestamp_Year(@RequestBody final int timestamp_year) throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        paymentService.findAllByPaymentTimestamp_Date(timestamp_year)
                                .stream().map(
                                        paymentEntity -> new PaymentDTO(
                                                paymentEntity.getPaymentId(),
                                                paymentEntity.getAmount(),
                                                paymentEntity.getPaymentTimestamp(),
                                                paymentEntity.getMethod(),
                                                paymentEntity.getStatus()
                                                )
                                ).toList()
                )
        );
    }

    @RequestMapping(value = "/payment/timestamp_month", method = RequestMethod.GET)
    public ResponseEntity<String> getPaymentByTimestamp_Month(@RequestBody final int timestamp_month) throws JsonProcessingException {
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        paymentService.findAllByPaymentTimestamp_Date(timestamp_month)
                                .stream().map(
                                        paymentEntity -> new PaymentDTO(
                                                paymentEntity.getPaymentId(),
                                                paymentEntity.getAmount(),
                                                paymentEntity.getPaymentTimestamp(),
                                                paymentEntity.getMethod(),
                                                paymentEntity.getStatus()
                                                )
                                ).toList()
                )
        );
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public ResponseEntity<String> addPayment(@RequestBody final PaymentDTO paymentDTO) throws JsonProcessingException {
        PaymentEntity paymentEntity = paymentService.createPayment(paymentDTO);
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        new PaymentDTO(
                                paymentEntity.getPaymentId(),
                                paymentEntity.getAmount(),
                                paymentEntity.getPaymentTimestamp(),
                                paymentEntity.getMethod(),
                                paymentEntity.getStatus()
                        )
                )
        );
    }

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getPaymentById(@PathVariable("id") Long id) throws JsonProcessingException {
        PaymentEntity paymentEntity = paymentService.getPaymentById(id);
        return ResponseEntity.ok(
                objectMapper.writeValueAsString(
                        new PaymentDTO(
                                paymentEntity.getPaymentId(),
                                paymentEntity.getAmount(),
                                paymentEntity.getPaymentTimestamp(),
                                paymentEntity.getMethod(),
                                paymentEntity.getStatus()
                        )
                )
        );
    }

    @RequestMapping(value = "/payment/simulate", method = RequestMethod.POST)
    public ResponseEntity<String> simulatePayment(@RequestBody final PaymentDTO paymentDTO)
            throws JsonProcessingException, InterruptedException {
        int pause = random.nextInt(30);
        TimeUnit.SECONDS.sleep(pause);
        boolean isSuccess = random.nextBoolean();
        if (isSuccess) {
            return addPayment(paymentDTO);
        }
        else {
            if (random.nextBoolean()) {
                pause = random.nextInt(60);
                TimeUnit.SECONDS.sleep(pause);
                if (random.nextBoolean()) {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(HttpStatus.BAD_GATEWAY.getReasonPhrase());
                }
                return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT)
                        .body(HttpStatus.REQUEST_TIMEOUT.getReasonPhrase());
            }
            if (random.nextBoolean()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(HttpStatus.BAD_REQUEST.getReasonPhrase());
            }
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(HttpStatus.EXPECTATION_FAILED.getReasonPhrase());
        }
    }
}
