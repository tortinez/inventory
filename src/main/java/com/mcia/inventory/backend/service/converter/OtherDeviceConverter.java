package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.*;
import com.mcia.inventory.backend.repository.EmployeeRepository;
import com.mcia.inventory.backend.repository.LocationRepository;
import com.mcia.inventory.backend.repository.NetworkSocketRepository;
import com.mcia.inventory.backend.repository.OtherDeviceTypeRepository;
import com.mcia.inventory.backend.service.exception.ResourceNotFoundException;
import com.mcia.inventory.backend.service.request.OtherDeviceRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class OtherDeviceConverter implements RequestConverter<OtherDevice, OtherDeviceRequest> {

    private LocationRepository locationRepository;
    private EmployeeRepository employeeRepository;
    private NetworkSocketRepository networkSocketRepository;
    private OtherDeviceTypeRepository otherDeviceTypeRepository;


    @Override
    public OtherDevice toEntity(OtherDeviceRequest request, Long Id) {

        List<NetworkSocket> networkSockets = new ArrayList<>();


        Location location = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("location id not found."));
        Employee responsible = employeeRepository.findById(request.getResponsibleId())
                .orElseThrow(() -> new ResourceNotFoundException("responsible id not found."));
        OtherDeviceType otherDeviceType = otherDeviceTypeRepository.findById(request.getTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("other device type id not found."));

        networkSocketRepository.findAllById(request.getNetworkSocketId()).forEach(networkSockets::add);
        if (networkSockets.size() != request.getNetworkSocketId().size()) {
            throw new ResourceNotFoundException("one or more network-socket id not found");
        }


        return new OtherDevice(Id,
                request.getBrand(),
                request.getModel(),
                request.getLabel(),
                location,
                request.getRemovalDate(),
                otherDeviceType,
                networkSockets,
                responsible);
    }


    @Override
    public OtherDevice toEntity(OtherDeviceRequest request) {
        return toEntity(request, (long) -1);
    }


}
