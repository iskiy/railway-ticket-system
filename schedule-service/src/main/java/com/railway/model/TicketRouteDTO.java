package com.railway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketRouteDTO {
    @NotNull(message = "Ticket's arrival station can't be empty")
    private String arrivalStation;

    @NotNull(message = "Ticket's departure station can't be empty")
    private String departureStation;
}
