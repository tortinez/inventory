package com.mcia.inventory.backend.service.request;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class PrinterRequest {

    private String brand;

    private String model;

    private String label;

    private Long locationId;

    private Date removalDate;

    private String cartridgeK;

    private String cartridgeCMY;

    private List<Long> networkSocketId;

    private Long responsibleId;
}
