package com.mcia.inventory.backend.service;

import com.mcia.inventory.backend.entity.NetworkSocket;
import com.mcia.inventory.backend.repository.NetworkSocketRepository;
import com.mcia.inventory.backend.service.converter.NetworkSocketConverter;
import com.mcia.inventory.backend.service.request.NetworkSocketRequest;
import org.springframework.stereotype.Service;

@Service
public class NetworkSocketService extends BaseService<NetworkSocket, NetworkSocketRequest> {

    public NetworkSocketService(NetworkSocketRepository repository, NetworkSocketConverter converter) {
        super(NetworkSocket.RESOURCE, repository, converter);
    }

}
