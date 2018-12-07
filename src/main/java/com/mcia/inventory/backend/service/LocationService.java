package com.mcia.inventory.backend.service;

import com.mcia.inventory.backend.entity.Location;
import com.mcia.inventory.backend.repository.LocationRepository;
import com.mcia.inventory.backend.service.converter.LocationConverter;
import com.mcia.inventory.backend.service.request.LocationRequest;
import org.springframework.stereotype.Service;

@Service
public class LocationService extends BaseService<Location, LocationRequest> {

    public LocationService(LocationRepository repository, LocationConverter converter) {
        super(Location.RESOURCE, repository, converter);
    }

}
