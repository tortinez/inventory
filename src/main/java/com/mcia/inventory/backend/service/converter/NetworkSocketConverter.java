package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.NetworkSocket;
import com.mcia.inventory.backend.service.request.NetworkSocketRequest;
import org.springframework.stereotype.Component;

@Component
public class NetworkSocketConverter implements RequestConverter<NetworkSocket, NetworkSocketRequest> {


    @Override
    public NetworkSocket toEntity(NetworkSocketRequest request, Long Id) {

        return new NetworkSocket(Id,
                request.getLabel());
    }


    @Override
    public NetworkSocket toEntity(NetworkSocketRequest request) {

        return toEntity(request, (long) -1);
    }


}
