package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.CarValuation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarValuationRepository extends CrudRepository<CarValuation, Long> {
    CarValuation findByCarId(long CarId);
}
