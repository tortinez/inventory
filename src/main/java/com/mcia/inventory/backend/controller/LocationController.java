package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.Location;
import com.mcia.inventory.backend.service.LocationService;
import com.mcia.inventory.backend.service.request.LocationRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(LocationController.URI)
public class LocationController extends BaseController<Location, LocationRequest> {

    static final String URI = WebConfig.BASE_API_PATH + "/" + Location.RESOURCE;


    protected LocationController(LocationService service) {
        super(LocationController.URI, service);
    }

}