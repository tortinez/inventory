package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.Employee;
import com.mcia.inventory.backend.service.EmployeeService;
import com.mcia.inventory.backend.service.request.EmployeeRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EmployeeController.URI)
public class EmployeeController extends BaseController<Employee, EmployeeRequest> {

    static final String URI = WebConfig.BASE_API_PATH + "/" + Employee.RESOURCE;


    protected EmployeeController(EmployeeService service) {
        super(EmployeeController.URI, service);
    }

}