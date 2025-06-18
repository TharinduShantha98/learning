package com.learning.tutorials.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EngineRepairDto {

    String vehicleType;
    String engineType;
    String cylinderVolume;
    String RPM;


}
