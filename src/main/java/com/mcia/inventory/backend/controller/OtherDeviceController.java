package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.OtherDevice;
import com.mcia.inventory.backend.service.OtherDeviceService;
import com.mcia.inventory.backend.service.request.OtherDeviceRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(OtherDeviceController.URI)
public class OtherDeviceController extends BaseController<OtherDevice, OtherDeviceRequest> {

    static final String URI = WebConfig.BASE_API_PATH + "/" + OtherDevice.RESOURCE;


    protected OtherDeviceController(OtherDeviceService service) {
        super(OtherDeviceController.URI, service);
    }

}