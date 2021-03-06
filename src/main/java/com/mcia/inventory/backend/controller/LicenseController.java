package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.License;
import com.mcia.inventory.backend.service.LicenseService;
import com.mcia.inventory.backend.service.request.LicenseRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(LicenseController.URI)
public class LicenseController extends BaseController<License, LicenseRequest> {

    static final String URI = WebConfig.BASE_API_PATH + "/" + License.RESOURCE;


    protected LicenseController(LicenseService service) {
        super(LicenseController.URI, service);
    }

}