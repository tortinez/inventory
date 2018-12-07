package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.Supplier;
import com.mcia.inventory.backend.service.request.SupplierRequest;
import org.springframework.stereotype.Component;

@Component
public class SupplierConverter implements RequestConverter<Supplier, SupplierRequest> {


    @Override
    public Supplier toEntity(SupplierRequest request, Long Id) {

        return new Supplier(Id,
                request.getName(),
                request.getPhone(),
                request.getCIF(),
                request.getContact());
    }


    @Override
    public Supplier toEntity(SupplierRequest request) {
        return toEntity(request, (long) -1);
    }


}
