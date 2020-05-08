package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("airplaneValuation")
public class AirplaneValuationDto implements Collateral {
    private Long id;
    private int airplaneId;
    private BigDecimal value;
    private Date date;
}
