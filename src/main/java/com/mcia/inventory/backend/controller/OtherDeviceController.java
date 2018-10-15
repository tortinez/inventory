package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.OtherDevice;
import com.mcia.inventory.backend.repository.OtherDeviceRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(OtherDeviceController.URI)
public class OtherDeviceController extends BaseController<OtherDevice>{

    public static final String URI = WebConfig.BASE_API_PATH + "/other-device";


    protected OtherDeviceController(OtherDeviceRepository repository){
        super(repository);
    }

}