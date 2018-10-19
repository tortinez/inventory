package com.mcia.inventory.backend.service;

import com.mcia.inventory.backend.entity.OtherDevice;
import com.mcia.inventory.backend.repository.OtherDeviceRepository;
import com.mcia.inventory.backend.service.converter.OtherDeviceConverter;
import com.mcia.inventory.backend.service.request.OtherDeviceRequest;
import org.springframework.stereotype.Service;

@Service
public class OtherDeviceService extends BaseService<OtherDevice, OtherDeviceRequest> {

    public OtherDeviceService(OtherDeviceRepository repository, OtherDeviceConverter converter){
        super(OtherDevice.RESOURCE, repository, converter);
    }

}
