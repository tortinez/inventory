package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.*;
import com.mcia.inventory.backend.repository.ComputerRepository;
import com.mcia.inventory.backend.repository.EmployeeRepository;
import com.mcia.inventory.backend.repository.ProjectRepository;
import com.mcia.inventory.backend.repository.SupplierRepository;
import com.mcia.inventory.backend.service.exception.ResourceNotFoundException;
import com.mcia.inventory.backend.service.request.LicenseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@AllArgsConstructor
public class LicenseConverter implements RequestConverter<License, LicenseRequest> {

    private SupplierRepository supplierRepository;
    private ProjectRepository projectRepository;
    private ComputerRepository computerRepository;
    private EmployeeRepository employeeRepository;

    @Override
    public License toEntity(LicenseRequest request, Long Id) {

        List<Computer> computers = new ArrayList<>();
        List<Employee> users = new ArrayList<>();

        Supplier supplier = supplierRepository.findById(request.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("supplier id not found."));
        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(() -> new ResourceNotFoundException("project id not found."));
        computerRepository.findAllById(request.getComputerId()).forEach(computers::add);
        if (computers.size() != request.getComputerId().size()) {
            throw new ResourceNotFoundException("one or more computers id not found");
        }
        employeeRepository.findAllById(request.getUserId()).forEach(users::add);
        if (users.size() != request.getUserId().size()) {
            throw new ResourceNotFoundException("one or more users id not found");
        }


        return new License(Id,
                request.getName(),
                request.getSoftwareType(),
                request.getType(),
                request.isDongle(),
                request.getActivationDate(),
                request.getRenewalDate(),
                request.getRenewalType(),
                supplier,
                computers,
                users,
                project);
    }

    @Override
    public License toEntity(LicenseRequest request) {
        return toEntity(request, (long) -1);
    }


}
