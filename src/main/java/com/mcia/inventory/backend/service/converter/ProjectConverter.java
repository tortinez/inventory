package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.Employee;
import com.mcia.inventory.backend.entity.Project;
import com.mcia.inventory.backend.repository.EmployeeRepository;
import com.mcia.inventory.backend.repository.LicenseRepository;
import com.mcia.inventory.backend.service.exception.ResourceNotFoundException;
import com.mcia.inventory.backend.service.request.ProjectRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ProjectConverter implements RequestConverter<Project, ProjectRequest> {

    private LicenseRepository licenseRepository;
    private EmployeeRepository employeeRepository;


    @Override
    public Project toEntity(ProjectRequest request, Long Id) {

        List<Employee> employees = new ArrayList<>();

        Employee manager = employeeRepository.findById(request.getManagerId())
                .orElseThrow(() -> new ResourceNotFoundException("manager id not found."));
        employeeRepository.findAllById(request.getEmployeeId()).forEach(employees::add);
        if (employees.size() != request.getEmployeeId().size()) {
            throw new ResourceNotFoundException("one or more employees id not found");
        }

        return new Project(Id,
                request.getName(),
                request.getCode(),
                request.getStartDate(),
                request.getEndDate(),
                manager,
                employees);
    }


    @Override
    public Project toEntity(ProjectRequest request) {
        return toEntity(request, (long) -1);
    }


}
