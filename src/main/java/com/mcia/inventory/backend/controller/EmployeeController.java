package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.Employee;
import com.mcia.inventory.backend.repository.EmployeeRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EmployeeController.URI)
public class EmployeeController extends BaseController<Employee>{

    public static final String URI = WebConfig.BASE_API_PATH + "/employee";


    protected EmployeeController(EmployeeRepository repository){
        super(repository);
    }

}