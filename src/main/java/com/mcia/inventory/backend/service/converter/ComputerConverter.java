package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.*;
import com.mcia.inventory.backend.repository.EmployeeRepository;
import com.mcia.inventory.backend.repository.LocationRepository;
import com.mcia.inventory.backend.repository.MonitorRepository;
import com.mcia.inventory.backend.repository.NetworkSocketRepository;
import com.mcia.inventory.backend.service.request.ComputerRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComputerConverter implements RequestConverter<Computer, ComputerRequest> {

    private LocationRepository locationRepository;
    private NetworkSocketRepository networkSocketRepository;
    private MonitorRepository monitorRepository;
    private EmployeeRepository employeeRepository;


    @Override
    public Computer toEntity(ComputerRequest request, Long... optId) {
        Long id = (optId[0] != null) ? optId[0] : -1;


        List<Monitor> monitors = new ArrayList<>();
        List<Employee> users = new ArrayList<>();
        List<NetworkSocket> networkSockets = new ArrayList<>();

        Location location = locationRepository.findById(request.getLocationId()).orElse(null);
        networkSocketRepository.findAllById(request.getNetworkSocketId()).forEach(networkSockets::add);
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
                request.getGpu0(),
                request.getGpu1(),
                request.getHdd0(),
                request.getHdd1(),
                request.getHdd2(),
                request.getPrice(),
                request.getPurchaseDate(),
                request.getSpecificHardware(),
                request.getEnabled(),
                networkSockets,
                monitors,
                users);
    }


}
