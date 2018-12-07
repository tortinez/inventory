package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.Employee;
import com.mcia.inventory.backend.entity.Location;
import com.mcia.inventory.backend.entity.NetworkSocket;
import com.mcia.inventory.backend.entity.Printer;
import com.mcia.inventory.backend.repository.EmployeeRepository;
import com.mcia.inventory.backend.repository.LocationRepository;
import com.mcia.inventory.backend.repository.NetworkSocketRepository;
import com.mcia.inventory.backend.service.exception.ResourceNotFoundException;
import com.mcia.inventory.backend.service.request.PrinterRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class PrinterConverter implements RequestConverter<Printer, PrinterRequest> {

    private LocationRepository locationRepository;
    private EmployeeRepository employeeRepository;
    private NetworkSocketRepository networkSocketRepository;


    @Override
    public Printer toEntity(PrinterRequest request, Long Id) {

        List<NetworkSocket> networkSockets = new ArrayList<>();

        Location location = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("location id not found."));
        Employee responsible = employeeRepository.findById(request.getResponsibleId())
                .orElseThrow(() -> new ResourceNotFoundException("responsible id not found."));

        networkSocketRepository.findAllById(request.getNetworkSocketId()).forEach(networkSockets::add);
        if (networkSockets.size() != request.getNetworkSocketId().size()) {
            throw new ResourceNotFoundException("one or more network-socket id not found");
        }


        return new Printer(Id,
                request.getBrand(),
                request.getModel(),
                request.getLabel(),
                location,
                request.getRemovalDate(),
                request.getCartridgeK(),
                request.getCartridgeCMY(),
                networkSockets,
                responsible);
    }


    @Override
    public Printer toEntity(PrinterRequest request) {
        return toEntity(request, (long) -1);
    }


}
