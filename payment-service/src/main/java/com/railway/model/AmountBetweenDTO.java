package com.railway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmountBetweenDTO {
    Long startAmount;
    Long endAmount;
}
