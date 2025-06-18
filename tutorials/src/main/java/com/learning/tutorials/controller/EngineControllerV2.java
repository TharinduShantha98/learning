package com.learning.tutorials.controller;


import com.learning.tutorials.dto.EngineRepairDto;
import com.learning.tutorials.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/engine/v2")
public class EngineControllerV2 {


    private final Map<String, EngineService> engines;

    @Autowired
    public EngineControllerV2(Map<String, EngineService> engines) {
        this.engines = engines;
    }


    @PostMapping("/engineRepair")
    public String repairEngine(@RequestBody EngineRepairDto engineRepairDto) {

        String vehicleTpe = engineRepairDto.getVehicleType().toLowerCase();
        EngineService engineService = engines.get(vehicleTpe);
        if (engineService == null) {
            throw new IllegalArgumentException("Invalid vehicle type: " + vehicleTpe);
        }
        return engineService.repairEngine(engineRepairDto);


    }
}
