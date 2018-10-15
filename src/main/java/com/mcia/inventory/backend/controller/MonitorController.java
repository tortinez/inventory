package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.Monitor;
import com.mcia.inventory.backend.repository.MonitorRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MonitorController.URI)
public class MonitorController extends BaseController<Monitor>{

    public static final String URI = WebConfig.BASE_API_PATH + "/monitor";


    protected MonitorController(MonitorRepository repository){
        super(repository);
    }

}