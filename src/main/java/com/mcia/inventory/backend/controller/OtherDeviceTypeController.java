package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.OtherDeviceType;
import com.mcia.inventory.backend.service.OtherDeviceTypeService;
import com.mcia.inventory.backend.service.request.OtherDeviceTypeRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(OtherDeviceTypeController.URI)
public class OtherDeviceTypeController extends BaseController<OtherDeviceType, OtherDeviceTypeRequest> {

    static final String URI = WebConfig.BASE_API_PATH + "/" + OtherDeviceType.RESOURCE;


    protected OtherDeviceTypeController(OtherDeviceTypeService service) {
        super(OtherDeviceTypeController.URI, service);
    }

}