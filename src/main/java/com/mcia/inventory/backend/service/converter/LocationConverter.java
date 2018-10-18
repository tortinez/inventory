package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.Location;
import com.mcia.inventory.backend.service.request.LocationRequest;
import org.springframework.stereotype.Component;


@Component
public class LocationConverter implements RequestConverter<Location, LocationRequest> {

    @Override
    public Location toEntity(LocationRequest request, Long... optId) {
        Long id = (optId[0] != null) ? optId[0] : -1;

        return new Location(id,
                request.getBuilding(),
                request.getFloor(),
                request.getOffice(),
                request.getNetworkSocket());
    }


}
