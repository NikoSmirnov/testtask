package com.mcb.creditfactory.service.valuation;


import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.CarValuationDto;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.model.CarValuation;

import com.mcb.creditfactory.repository.CarValuationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarValuationService {
    @Autowired
    CarValuationRepository carValuationRepository;
    public CarValuation save(CarValuation car) {
        return carValuationRepository.save(car);
    }


    public Optional<CarValuation> load(Long id) {
        return carValuationRepository.findById(id);
    }

    public CarValuation fromDto(CarValuationDto dto) {
        return new CarValuation(
                dto.getId(),
                dto.getCarId(),
                dto.getValue(),
                dto.getDate()
        );
    }
    public Long getId(CarValuation carValuation) {
        return carValuation.getId();
    }
}
