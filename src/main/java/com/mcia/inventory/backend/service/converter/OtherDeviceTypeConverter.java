package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.OtherDeviceType;
import com.mcia.inventory.backend.service.request.OtherDeviceTypeRequest;
import org.springframework.stereotype.Component;

@Component
public class OtherDeviceTypeConverter implements RequestConverter<OtherDeviceType, OtherDeviceTypeRequest> {


    @Override
    public OtherDeviceType toEntity(OtherDeviceTypeRequest request, Long... optId) {
        Long id = (optId[0] != null) ? optId[0] : -1;

        return new OtherDeviceType(id,
                request.getName());
    }

}
