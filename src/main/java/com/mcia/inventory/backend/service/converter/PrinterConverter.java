package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.Employee;
import com.mcia.inventory.backend.entity.Location;
import com.mcia.inventory.backend.entity.NetworkSocket;
import com.mcia.inventory.backend.entity.Printer;
import com.mcia.inventory.backend.repository.EmployeeRepository;
import com.mcia.inventory.backend.repository.LocationRepository;
import com.mcia.inventory.backend.repository.NetworkSocketRepository;
import com.mcia.inventory.backend.service.request.PrinterRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrinterConverter implements RequestConverter<Printer, PrinterRequest> {

    private LocationRepository locationRepository;
    private EmployeeRepository employeeRepository;
    private NetworkSocketRepository networkSocketRepository;


    @Override
    public Printer toEntity(PrinterRequest request, Long... optId) {
        Long id = (optId[0] != null) ? optId[0] : -1;

        List<NetworkSocket> networkSockets = new ArrayList<>();

        Location location = locationRepository.findById(request.getLocationId()).orElse(null);
        Employee responsible = employeeRepository.findById(request.getResponsibleId()).orElse(null);

        networkSocketRepository.findAllById(request.getNetworkSocketId()).forEach(networkSockets::add);


        return new Printer(id,
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


}
