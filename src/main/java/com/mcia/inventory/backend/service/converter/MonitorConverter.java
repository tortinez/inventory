package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.*;
import com.mcia.inventory.backend.repository.EmployeeRepository;
import com.mcia.inventory.backend.repository.LocationRepository;
import com.mcia.inventory.backend.service.request.MonitorRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MonitorConverter implements RequestConverter<Monitor, MonitorRequest> {

    private LocationRepository locationRepository;
    private EmployeeRepository employeeRepository;


    @Override
    public Monitor toEntity(MonitorRequest request, Long... optId) {
        Long id = (optId[0] != null) ? optId[0] : -1;

        List<Employee> users = new ArrayList<>();

        Location location = locationRepository.findById(request.getLocationId()).orElse(null);
        employeeRepository.findAllById(request.getUserId()).forEach(users::add);


        return new Monitor(id,
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


}
