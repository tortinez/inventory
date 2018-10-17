package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.Computer;
import com.mcia.inventory.backend.repository.ComputerRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ComputerController.URI)
public class ComputerController extends BaseController<Computer>{

    public static final String URI = WebConfig.BASE_API_PATH + "/computer";


    protected ComputerController(ComputerRepository repository){
        super(repository);
    }

}