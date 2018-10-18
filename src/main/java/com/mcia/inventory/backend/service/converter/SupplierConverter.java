package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.Supplier;
import com.mcia.inventory.backend.service.request.SupplierRequest;
import org.springframework.stereotype.Component;

@Component
public class SupplierConverter implements RequestConverter<Supplier, SupplierRequest> {


    @Override
    public Supplier toEntity(SupplierRequest request, Long... optId) {
        Long id = (optId[0] != null) ? optId[0] : -1;

        return new Supplier(id,
                request.getName(),
                request.getPhone(),
                request.getCIF(),
                request.getContact());
    }


}
