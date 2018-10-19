package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.Employee;
import com.mcia.inventory.backend.entity.Project;
import com.mcia.inventory.backend.repository.EmployeeRepository;
import com.mcia.inventory.backend.repository.LicenseRepository;
import com.mcia.inventory.backend.service.request.ProjectRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectConverter implements RequestConverter<Project, ProjectRequest> {

    private LicenseRepository licenseRepository;
    private EmployeeRepository employeeRepository;


    @Override
    public Project toEntity(ProjectRequest request, Long... optId) {
        Long id = (optId[0] != null) ? optId[0] : -1;

        List<Employee> employees = new ArrayList<>();

        Employee manager = employeeRepository.findById(request.getManagerId()).orElse(null);
        employeeRepository.findAllById(request.getEmployeeId()).forEach(employees::add);

        return new Project(id,
                request.getName(),
                request.getCode(),
                request.getStartDate(),
                request.getEndDate(),
                manager,
                employees);
    }


}
