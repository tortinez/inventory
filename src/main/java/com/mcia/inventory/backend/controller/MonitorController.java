package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.Monitor;
import com.mcia.inventory.backend.service.MonitorService;
import com.mcia.inventory.backend.service.request.MonitorRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MonitorController.URI)
public class MonitorController extends BaseController<Monitor, MonitorRequest> {

    static final String URI = WebConfig.BASE_API_PATH + "/" + Monitor.RESOURCE;


    protected MonitorController(MonitorService service) {
        super(MonitorController.URI, service);
    }

}