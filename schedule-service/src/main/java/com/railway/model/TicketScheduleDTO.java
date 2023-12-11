package com.railway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketScheduleDTO {
    @NotNull(message = "Ticket's arrival station can't be empty")
    private String arrivalStation;

    @NotNull(message = "Ticket's departure station can't be empty")
    private String departureStation;

    private Timestamp journeyDate;
}
