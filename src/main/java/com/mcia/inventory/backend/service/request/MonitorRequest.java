package com.mcia.inventory.backend.service.request;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class MonitorRequest {

    private String brand;

    private String model;

    private String label;

    private Long locationId;

    private Date removalDate;

    private String resolution;

    private String input;

    private BigDecimal price;

    private Date purchaseDate;

    private Boolean enabled;

    private List<Long> userId;
}
