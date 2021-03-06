package com.mcia.inventory.backend.service.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

    private String fullname;

    private String email;

    private String position;

    private Date startingDate;

    private Date leavingDate;

    private String comments;
}
