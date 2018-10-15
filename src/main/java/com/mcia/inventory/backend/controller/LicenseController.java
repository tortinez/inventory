package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.License;
import com.mcia.inventory.backend.repository.LicenseRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(LicenseController.URI)
public class LicenseController extends BaseController<License>{

    public static final String URI = WebConfig.BASE_API_PATH + "/license";


    protected LicenseController(LicenseRepository repository){
        super(repository);
    }

}