package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.Location;
import com.mcia.inventory.backend.entity.NetworkSocket;
import com.mcia.inventory.backend.repository.NetworkSocketRepository;
import com.mcia.inventory.backend.service.exception.ResourceNotFoundException;
import com.mcia.inventory.backend.service.request.LocationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@AllArgsConstructor
public class LocationConverter implements RequestConverter<Location, LocationRequest> {

    private NetworkSocketRepository networkSocketRepository;

    @Override
    public Location toEntity(LocationRequest request, Long Id) {

        List<NetworkSocket> networkSockets = new ArrayList<>();

        networkSocketRepository.findAllById(request.getNetworkSocketId()).forEach(networkSockets::add);
        if (networkSockets.size() != request.getNetworkSocketId().size()) {
            throw new ResourceNotFoundException("one or more network-socket id not found");
        }

        return new Location(Id,
                request.getBuilding(),
                request.getFloor(),
                request.getOffice(),
                networkSockets);
    }


    @Override
    public Location toEntity(LocationRequest request) {
        return toEntity(request, (long) -1);
    }


}
