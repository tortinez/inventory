package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.*;
import com.mcia.inventory.backend.repository.ComputerRepository;
import com.mcia.inventory.backend.repository.EmployeeRepository;
import com.mcia.inventory.backend.repository.ProjectRepository;
import com.mcia.inventory.backend.repository.SupplierRepository;
import com.mcia.inventory.backend.service.request.LicenseRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class LicenseConverter implements RequestConverter<License, LicenseRequest> {

    private SupplierRepository supplierRepository;
    private ProjectRepository projectRepository;
    private ComputerRepository computerRepository;
    private EmployeeRepository employeeRepository;

    @Override
    public License toEntity(LicenseRequest request, Long... optId) {
        Long id = (optId[0] != null) ? optId[0] : -1;

        List<Computer> computers = new ArrayList<>();
        List<Employee> users = new ArrayList<>();

        Supplier supplier = supplierRepository.findById(request.getSupplierId()).orElse(null);
        Project project = projectRepository.findById(request.getProjectId()).orElse(null);
        computerRepository.findAllById(request.getComputerId()).forEach(computers::add);
        employeeRepository.findAllById(request.getUserId()).forEach(users::add);


        return new License(id,
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


}
