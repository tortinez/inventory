package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.OtherDeviceType;
import com.mcia.inventory.backend.service.request.OtherDeviceTypeRequest;
import org.springframework.stereotype.Component;

@Component
public class OtherDeviceTypeConverter implements RequestConverter<OtherDeviceType, OtherDeviceTypeRequest> {


    @Override
    public OtherDeviceType toEntity(OtherDeviceTypeRequest request, Long Id) {

        return new OtherDeviceType(Id,
                request.getName());
    }


    @Override
    public OtherDeviceType toEntity(OtherDeviceTypeRequest request) {

        return toEntity(request, (long) -1);
    }

}
