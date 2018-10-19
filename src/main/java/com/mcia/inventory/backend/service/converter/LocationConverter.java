package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.Location;
import com.mcia.inventory.backend.entity.NetworkSocket;
import com.mcia.inventory.backend.repository.NetworkSocketRepository;
import com.mcia.inventory.backend.service.request.LocationRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class LocationConverter implements RequestConverter<Location, LocationRequest> {

    private NetworkSocketRepository networkSocketRepository;

    @Override
    public Location toEntity(LocationRequest request, Long... optId) {
        Long id = (optId[0] != null) ? optId[0] : -1;

        List<NetworkSocket> networkSockets = new ArrayList<>();

        networkSocketRepository.findAllById(request.getNetworkSocketId()).forEach(networkSockets::add);

        return new Location(id,
                request.getBuilding(),
                request.getFloor(),
                request.getOffice(),
                networkSockets);
    }


}
