package com.mcia.inventory.backend.service.request;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class LicenseRequest {

    private String name;

    private String softwareType;

    private String type;

    private boolean dongle;

    private Date activationDate;

    private Date renewalDate;

    private String renewalType;

    private Long supplierId;

    private List<Long> computerId;

    private List<Long> userId;

    private Long projectId;

}
