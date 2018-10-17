package com.mcia.inventory.backend.service.request;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class ComputerRequest {

    private String brand;

    private String model;

    private String label;

    private Long locationId;

    private Date removalDate;

    private String cpu;

    private String ram;

    private String gpu;

    private String hdd;

    private BigDecimal price;

    private Date purchaseDate;

    private String networkSocket;

    private String specificHardware;

    private Boolean enabled;

    private List<Long> monitorId;

    private List<Long> userId;  //it can be @ManyToMany?

    private List<Long> licenseId;
}
