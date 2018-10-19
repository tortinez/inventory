package com.mcia.inventory.backend.service.request;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class ProjectRequest {

    private String name;

    private String code;

    private Date startDate;

    private Date endDate;

    private Long managerId;

    private List<Long> employeeId;
}
