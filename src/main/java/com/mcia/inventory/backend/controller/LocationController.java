package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.Location;
import com.mcia.inventory.backend.repository.LocationRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(LocationController.URI)
public class LocationController extends BaseController<Location>{

    public static final String URI = WebConfig.BASE_API_PATH + "/" + Location.RESOURCE;


    protected LocationController(LocationRepository repository){
        super(repository);
    }

}