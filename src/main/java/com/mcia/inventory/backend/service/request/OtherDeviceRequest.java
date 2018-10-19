package com.mcia.inventory.backend.service.request;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class OtherDeviceRequest {

    private String brand;

    private String model;

    private String label;

    private Long locationId;

    private Date removalDate;

    private Long typeId;

    private List<Long> networkSocketId;

    private Long responsibleId;
}
