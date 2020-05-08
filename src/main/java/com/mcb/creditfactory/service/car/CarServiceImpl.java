package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.model.CarValuation;
import com.mcb.creditfactory.repository.CarRepository;
import com.mcb.creditfactory.repository.CarValuationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private ExternalApproveService approveService;
    @Autowired
    CarValuationRepository carValuationRepository;
    @Autowired
    private CarRepository carRepository;

    @Override
    public boolean approve(CarDto dto) {
        return approveService.approve(new CarAdapter(dto)) == 0;
    }
    public BigDecimal getValuation(CarDto dto){

    return carValuationRepository.findByCarId(dto.getId()).getValue();
}

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> load(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car fromDto(CarDto dto) {
        return new Car(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getPower(),
                dto.getYear(),
                dto.getValue(),
                dto.getValues()
        );
    }

    @Override
    public CarDto toDTO(Car car) {
        return new CarDto(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getPower(),
                car.getYear(),
                car.getValue(),
                car.getValues()
        );
    }

    @Override
    public Long getId(Car car) {
        return car.getId();
    }
}
