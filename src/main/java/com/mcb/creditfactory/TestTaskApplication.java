package com.mcb.creditfactory;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.AirplaneValuationDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.CarValuationDto;
import com.mcb.creditfactory.model.AirplaneValuation;
import com.mcb.creditfactory.model.CarValuation;
import com.mcb.creditfactory.service.CollateralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class TestTaskApplication {

    @Autowired
    private CollateralService collateralService;
    public static void main(String[] args) {
        SpringApplication.run(TestTaskApplication.class, args);

    }



}
