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
@JsonTypeName("carValuation")
public class CarValuationDto implements Collateral{
    private long id;
    private int carId;
    private BigDecimal value;
    private Date date;

}
