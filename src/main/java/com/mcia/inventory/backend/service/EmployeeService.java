package com.mcia.inventory.backend.service;

import com.mcia.inventory.backend.entity.Employee;
import com.mcia.inventory.backend.repository.EmployeeRepository;
import com.mcia.inventory.backend.service.converter.EmployeeConverter;
import com.mcia.inventory.backend.service.request.EmployeeRequest;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends BaseService<Employee, EmployeeRequest> {

    public EmployeeService(EmployeeRepository repository, EmployeeConverter converter) {
        super(Employee.RESOURCE, repository, converter);
    }

}
