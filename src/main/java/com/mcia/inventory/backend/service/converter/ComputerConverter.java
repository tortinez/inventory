package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.*;
import com.mcia.inventory.backend.repository.EmployeeRepository;
import com.mcia.inventory.backend.repository.LocationRepository;
import com.mcia.inventory.backend.repository.MonitorRepository;
import com.mcia.inventory.backend.repository.NetworkSocketRepository;
import com.mcia.inventory.backend.service.exception.ResourceNotFoundException;
import com.mcia.inventory.backend.service.request.ComputerRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ComputerConverter implements RequestConverter<Computer, ComputerRequest> {

    private LocationRepository locationRepository;
    private NetworkSocketRepository networkSocketRepository;
    private MonitorRepository monitorRepository;
    private EmployeeRepository employeeRepository;


    @Override
    public Computer toEntity(ComputerRequest request, Long Id) {

        List<Monitor> monitors = new ArrayList<>();
        List<Employee> users = new ArrayList<>();
        List<NetworkSocket> networkSockets = new ArrayList<>();

        Location location = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("location id not found."));
        networkSocketRepository.findAllById(request.getNetworkSocketId()).forEach(networkSockets::add);
        if (networkSockets.size() != request.getNetworkSocketId().size()) {
            throw new ResourceNotFoundException("one or more network-socket id not found");
        }
        monitorRepository.findAllById(request.getMonitorId()).forEach(monitors::add);
        if (monitors.size() != request.getMonitorId().size()) {
            throw new ResourceNotFoundException("one or more monitors id not found");
        }
        employeeRepository.findAllById(request.getUserId()).forEach(users::add);
        if (users.size() != request.getUserId().size()) {
            throw new ResourceNotFoundException("one or more users id not found");
        }


        return new Computer(Id,
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


    @Override
    public Computer toEntity(ComputerRequest request) {
        return toEntity(request, (long) -1);
    }

}
