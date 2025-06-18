package com.learning.tutorials.controller;


import com.learning.tutorials.dto.EngineRepairDto;
import com.learning.tutorials.service.EngineService;
import com.learning.tutorials.service.impl.AudiEngineServiceImpl;
import com.learning.tutorials.service.impl.BMWEngineServiceImpl;
import com.learning.tutorials.service.impl.BenzEngineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("api/engine/v1")
public class EngineControllerV1 {

    private static final String BMW= "bmw";
    private static final String AUDI= "audi";
    private static final String BENZ= "benz";

    

    private final AudiEngineServiceImpl audiService;
    private final BMWEngineServiceImpl bmwEngineService;
    private final BenzEngineServiceImpl benzEngineService;
    private final EngineService engineService;

    @Autowired
    public EngineControllerV1(AudiEngineServiceImpl audiService,
                              BMWEngineServiceImpl bmwEngineService,
                              BenzEngineServiceImpl benzEngineService,
                              @Qualifier("bmw") EngineService engineService) {
        this.audiService = audiService;
        this.bmwEngineService = bmwEngineService;
        this.benzEngineService = benzEngineService;
        this.engineService = engineService;
    }

    @PostMapping("/engineRepair")
    public String repairEngine(@RequestBody EngineRepairDto engineRepairDto) {

        return switch (engineRepairDto.getVehicleType().toLowerCase()){
            case BMW -> bmwEngineService.repairEngine(engineRepairDto);
            case AUDI -> audiService.repairEngine(engineRepairDto);
            case BENZ -> benzEngineService.repairEngine(engineRepairDto);
            default -> throw new IllegalArgumentException("Invalid vehicle type");

        };


    }

    @PostMapping("/engineRepair2")
    public String repairEngine2(@RequestBody EngineRepairDto engineRepairDto) {

        return switch (engineRepairDto.getVehicleType().toLowerCase()){
            case BMW -> bmwEngineService.repairEngine(engineRepairDto);
            case AUDI -> audiService.repairEngine(engineRepairDto);
            case BENZ -> benzEngineService.repairEngine(engineRepairDto);
            default -> throw new IllegalArgumentException("Invalid vehicle type");

        };


    }
    
    
    





}
