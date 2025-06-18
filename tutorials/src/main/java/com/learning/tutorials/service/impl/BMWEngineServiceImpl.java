package com.learning.tutorials.service.impl;

import com.learning.tutorials.dto.EngineRepairDto;
import com.learning.tutorials.service.EngineService;
import org.springframework.stereotype.Service;

@Service("bmw")
public class BMWEngineServiceImpl implements EngineService {

    @Override
    public String repairEngine(EngineRepairDto engineRepairDto) {
        return "Repair Vehicle Detail Vehicle "+ engineRepairDto.getVehicleType() ;
    }


}
