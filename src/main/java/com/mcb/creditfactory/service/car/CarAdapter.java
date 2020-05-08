package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.repository.CarValuationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
public class CarAdapter implements CollateralObject {
@Autowired

    private CarDto car;

    @Override
    public BigDecimal getValue() {
        return car.getValue();
    }

    @Override
    public Short getYear() {
        return car.getYear();
    }

    @Override
    public LocalDate getDate() {
        // Для автомобилей дата оценки не используется, поэтому всегда берем текущую
        return LocalDate.now();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.CAR;
    }
}
