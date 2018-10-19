package com.mcia.inventory.backend.service;

import com.mcia.inventory.backend.entity.OtherDeviceType;
import com.mcia.inventory.backend.repository.OtherDeviceTypeRepository;
import com.mcia.inventory.backend.service.converter.OtherDeviceTypeConverter;
import com.mcia.inventory.backend.service.request.OtherDeviceTypeRequest;
import org.springframework.stereotype.Service;

@Service
public class OtherDeviceTypeService extends BaseService<OtherDeviceType, OtherDeviceTypeRequest> {

    public OtherDeviceTypeService(OtherDeviceTypeRepository repository, OtherDeviceTypeConverter converter) {
        super(OtherDeviceType.RESOURCE, repository, converter);
    }

}
