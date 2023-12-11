package com.railway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private Long paymentId;

    private Long amount;

    private Timestamp paymentTimestamp;

    @NotNull(message = "Payment's method can't be empty")
    private String method;

    private String status;
}
