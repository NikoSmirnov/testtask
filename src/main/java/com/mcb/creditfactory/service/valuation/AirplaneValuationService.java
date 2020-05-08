package com.mcb.creditfactory.service.valuation;

import com.mcb.creditfactory.dto.AirplaneValuationDto;
import com.mcb.creditfactory.dto.CarValuationDto;
import com.mcb.creditfactory.model.AirplaneValuation;
import com.mcb.creditfactory.model.CarValuation;
import com.mcb.creditfactory.repository.AirplaneValuationRepository;
import com.mcb.creditfactory.repository.CarValuationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirplaneValuationService {
    @Autowired
   private AirplaneValuationRepository airplaneValuationRepository;

    public AirplaneValuation save(AirplaneValuation airplane) {
        return airplaneValuationRepository.save(airplane);
    }


    public Optional<AirplaneValuation> load(Long id) {
        return airplaneValuationRepository.findById(id);
    }

    public AirplaneValuation fromDto(AirplaneValuationDto dto) {
        return new AirplaneValuation(
                dto.getId(),
                dto.getAirplaneId(),
                dto.getValue(),
                dto.getDate()
        );
    }
    public Long getId(AirplaneValuation airplaneValuation) {
        return airplaneValuation.getId();
    }
}
