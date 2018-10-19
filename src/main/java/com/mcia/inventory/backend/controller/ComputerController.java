package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.Computer;
import com.mcia.inventory.backend.service.ComputerService;
import com.mcia.inventory.backend.service.request.ComputerRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ComputerController.URI)
public class ComputerController extends BaseController<Computer, ComputerRequest> {

    static final String URI = WebConfig.BASE_API_PATH + "/" + Computer.RESOURCE;


    protected ComputerController(ComputerService service) {
        super(ComputerController.URI, service);
    }

}