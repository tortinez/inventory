package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.Employee;
import com.mcia.inventory.backend.entity.Location;
import com.mcia.inventory.backend.entity.Monitor;
import com.mcia.inventory.backend.repository.EmployeeRepository;
import com.mcia.inventory.backend.repository.LocationRepository;
import com.mcia.inventory.backend.service.exception.ResourceNotFoundException;
import com.mcia.inventory.backend.service.request.MonitorRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class MonitorConverter implements RequestConverter<Monitor, MonitorRequest> {

    private LocationRepository locationRepository;
    private EmployeeRepository employeeRepository;


    @Override
    public Monitor toEntity(MonitorRequest request, Long Id) {

        List<Employee> users = new ArrayList<>();

        Location location = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("location id not found."));
        employeeRepository.findAllById(request.getUserId()).forEach(users::add);
        if (users.size() != request.getUserId().size()) {
            throw new ResourceNotFoundException("one or more employees id not found");
        }


        return new Monitor(Id,
                request.getBrand(),
                request.getModel(),
                request.getLabel(),
                location,
                request.getRemovalDate(),
                request.getResolution(),
                request.getInput(),
                request.getPrice(),
                request.getPurchaseDate(),
                request.getEnabled(),
                users);
    }


    @Override
    public Monitor toEntity(MonitorRequest request) {
        return toEntity(request, (long) -1);
    }


}
