package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.*;
import com.mcia.inventory.backend.repository.EmployeeRepository;
import com.mcia.inventory.backend.repository.LocationRepository;
import com.mcia.inventory.backend.repository.NetworkSocketRepository;
import com.mcia.inventory.backend.repository.OtherDeviceTypeRepository;
import com.mcia.inventory.backend.service.request.OtherDeviceRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OtherDeviceConverter implements RequestConverter<OtherDevice, OtherDeviceRequest> {

    private LocationRepository locationRepository;
    private EmployeeRepository employeeRepository;
    private NetworkSocketRepository networkSocketRepository;
    private OtherDeviceTypeRepository otherDeviceTypeRepository;


    @Override
    public OtherDevice toEntity(OtherDeviceRequest request, Long... optId) {
        Long id = (optId[0] != null) ? optId[0] : -1;

        List<NetworkSocket> networkSockets = new ArrayList<>();


        Location location = locationRepository.findById(request.getLocationId()).orElse(null);
        Employee responsible = employeeRepository.findById(request.getResponsibleId()).orElse(null);
        OtherDeviceType otherDeviceType = otherDeviceTypeRepository.findById(request.getTypeId()).orElse(null);

        networkSocketRepository.findAllById(request.getNetworkSocketId()).forEach(networkSockets::add);


        return new OtherDevice(id,
                request.getBrand(),
                request.getModel(),
                request.getLabel(),
                location,
                request.getRemovalDate(),
                otherDeviceType,
                networkSockets,
                responsible);
    }


}
