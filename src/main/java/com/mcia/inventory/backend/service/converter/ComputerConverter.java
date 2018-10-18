package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.*;
import com.mcia.inventory.backend.repository.EmployeeRepository;
import com.mcia.inventory.backend.repository.LicenseRepository;
import com.mcia.inventory.backend.repository.LocationRepository;
import com.mcia.inventory.backend.repository.MonitorRepository;
import com.mcia.inventory.backend.service.request.ComputerRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComputerConverter implements RequestConverter<Computer, ComputerRequest> {

    private LocationRepository locationRepository;
    private LicenseRepository licenseRepository;
    private MonitorRepository monitorRepository;
    private EmployeeRepository employeeRepository;


    @Override
    public Computer toEntity(ComputerRequest request, Long... optId) {
        Long id = (optId[0] != null) ? optId[0] : -1;

        List<License> licenses = new ArrayList<>();
        List<Monitor> monitors = new ArrayList<>();
        List<Employee> users = new ArrayList<>();

        Location location = locationRepository.findById(request.getLocationId()).orElse(null);
        licenseRepository.findAllById(request.getLicenseId()).forEach(licenses::add);
        monitorRepository.findAllById(request.getMonitorId()).forEach(monitors::add);
        employeeRepository.findAllById(request.getUserId()).forEach(users::add);


        return new Computer(id,
                request.getBrand(),
                request.getModel(),
                request.getLabel(),
                location,
                request.getRemovalDate(),
                request.getCpu(),
                request.getRam(),
                request.getGpu(),
                request.getHdd(),
                request.getPrice(),
                request.getPurchaseDate(),
                request.getNetworkSocket(),
                request.getSpecificHardware(),
                request.getEnabled(),
                monitors,
                users,
                licenses);
    }


}
