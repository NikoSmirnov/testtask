package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.*;
import com.mcb.creditfactory.service.airplane.AirplaneService;
import com.mcb.creditfactory.service.car.CarService;
import com.mcb.creditfactory.service.valuation.AirplaneValuationService;
import com.mcb.creditfactory.service.valuation.CarValuationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// TODO: reimplement this
@Service
public class CollateralService {
    @Autowired
    private CarService carService;
    @Autowired
    private AirplaneService airplaneService;
    @Autowired
    private CarValuationService carValuationService;
    @Autowired
    private AirplaneValuationService airplaneValuationService;



    @SuppressWarnings("ConstantConditions")
    public Long saveCollateral(Collateral object) {
        if (!(object instanceof CarDto)) {

            throw new IllegalArgumentException();
        }
        CarDto car = (CarDto)object;

        boolean approved = carService.approve(car);
        if (!approved) {
            return null;
        }

        return Optional.of(car)
                .map(carService::fromDto)
                .map(carService::save)
                .map(carService::getId)
                .orElse(null);
    }

    public Collateral getInfo(Collateral object) {
        if (!(object instanceof CarDto)) {
            throw new IllegalArgumentException();
        }

        return Optional.of((CarDto) object)
                .map(carService::fromDto)
                .map(carService::getId)
                .flatMap(carService::load)
                .map(carService::toDTO)
                .orElse(null);
    }

    @SuppressWarnings("ConstantConditions")
    public Long saveCollateralplane(Collateral object) {
        if (!(object instanceof AirplaneDto)) {
            throw new IllegalArgumentException();
        }
        AirplaneDto airplane = (AirplaneDto)object;

        boolean approved = airplaneService.approve(airplane);
        if (!approved) {
            return null;
        }

        return Optional.of(airplane)
                .map(airplaneService::fromDto)
                .map(airplaneService::save)
                .map(airplaneService::getId)
                .orElse(null);
    }

    public Collateral getInfoplane(Collateral object) {
        if (!(object instanceof AirplaneDto)) {
            throw new IllegalArgumentException();
        }

        return Optional.of((AirplaneDto) object)
                .map(airplaneService::fromDto)
                .map(airplaneService::getId)
                .flatMap(airplaneService::load)
                .map(airplaneService::toDTO)
                .orElse(null);
    }

    public Long saveCarValuation(Collateral object) {
        if (!(object instanceof CarValuationDto)) {
            throw new IllegalArgumentException();
        }
        CarValuationDto cv = (CarValuationDto)object;



        return Optional.of(cv)
                .map(carValuationService::fromDto)
                .map(carValuationService::save)
                .map(carValuationService::getId)
                .orElse(null);
    }
    public Long saveAirplaneValuation(Collateral object) {
        if (!(object instanceof AirplaneValuationDto)) {
            throw new IllegalArgumentException();
        }
        AirplaneValuationDto av = (AirplaneValuationDto)object;



        return Optional.of(av)
                .map(airplaneValuationService::fromDto)
                .map(airplaneValuationService::save)
                .map(airplaneValuationService::getId)
                .orElse(null);
    }
}
