package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.NetworkSocket;
import com.mcia.inventory.backend.service.NetworkSocketService;
import com.mcia.inventory.backend.service.request.NetworkSocketRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(NetworkSocketController.URI)
public class NetworkSocketController extends BaseController<NetworkSocket, NetworkSocketRequest> {

    static final String URI = WebConfig.BASE_API_PATH + "/" + NetworkSocket.RESOURCE;


    protected NetworkSocketController(NetworkSocketService service) {
        super(NetworkSocketController.URI, service);
    }

}