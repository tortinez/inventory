package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.Employee;
import com.mcia.inventory.backend.entity.Location;
import com.mcia.inventory.backend.entity.OtherDevice;
import com.mcia.inventory.backend.repository.EmployeeRepository;
import com.mcia.inventory.backend.repository.LocationRepository;
import com.mcia.inventory.backend.service.request.OtherDeviceRequest;
import org.springframework.stereotype.Component;

@Component
public class OtherDeviceConverter implements RequestConverter<OtherDevice, OtherDeviceRequest> {

    private LocationRepository locationRepository;
    private EmployeeRepository employeeRepository;


    @Override
    public OtherDevice toEntity(OtherDeviceRequest request, Long... optId) {
        Long id = (optId[0] != null) ? optId[0] : -1;

        Location location = locationRepository.findById(request.getLocationId()).orElse(null);
        Employee responsible = employeeRepository.findById(request.getResponsibleId()).orElse(null);


        return new OtherDevice(id,
                request.getBrand(),
                request.getModel(),
                request.getLabel(),
                location,
                request.getRemovalDate(),
                request.getType(),
                request.getNetworkSocket(),
                responsible);
    }


}
