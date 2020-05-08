package com.mcb.creditfactory.controller;

import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.service.CollateralService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollateralObjectController {
    @Autowired
    private CollateralService service;

    @PostMapping("/collateral/save")

    public HttpEntity<Long> save(@RequestBody Collateral object) {

        Long id = service.saveCollateral(object);
        return id != null ? ResponseEntity.ok(id) : ResponseEntity.badRequest().build();
    }

    @PostMapping("/collateral/info")
    public HttpEntity<Collateral> getInfo(@RequestBody Collateral object) {
        Collateral info = service.getInfo(object);
        return info != null ? ResponseEntity.ok(info) : ResponseEntity.notFound().build();
    }

    @PostMapping("/collateral/saveairplane")

    public HttpEntity<Long> saveAirplane(@RequestBody Collateral object) {

        Long id = service.saveCollateralplane(object);
        return id != null ? ResponseEntity.ok(id) : ResponseEntity.badRequest().build();
    }

    @PostMapping("/collateral/infoairplane")
    public HttpEntity<Collateral> getInfoAirplane(@RequestBody Collateral object) {
        Collateral info = service.getInfoplane(object);
        return info != null ? ResponseEntity.ok(info) : ResponseEntity.notFound().build();
    }
    @PostMapping("/collateral/savecarvaluation")
    public HttpEntity<Long> saveCarValuation(@RequestBody Collateral object) {

        Long id = service.saveCarValuation(object);
        return id != null ? ResponseEntity.ok(id) : ResponseEntity.badRequest().build();
    }
}