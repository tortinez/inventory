package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.NetworkSocket;
import com.mcia.inventory.backend.service.request.NetworkSocketRequest;
import org.springframework.stereotype.Component;

@Component
public class NetworkSocketConverter implements RequestConverter<NetworkSocket, NetworkSocketRequest> {


    @Override
    public NetworkSocket toEntity(NetworkSocketRequest request, Long... optId) {
        Long id = (optId[0] != null) ? optId[0] : -1;

        return new NetworkSocket(id,
                request.getLabel());
    }


}
