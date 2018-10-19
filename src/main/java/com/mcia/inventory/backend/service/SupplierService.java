package com.mcia.inventory.backend.service;

import com.mcia.inventory.backend.entity.Supplier;
import com.mcia.inventory.backend.repository.SupplierRepository;
import com.mcia.inventory.backend.service.converter.SupplierConverter;
import com.mcia.inventory.backend.service.request.SupplierRequest;
import org.springframework.stereotype.Service;

@Service
public class SupplierService extends BaseService<Supplier, SupplierRequest> {

    public SupplierService(SupplierRepository repository, SupplierConverter converter){
        super(Supplier.RESOURCE, repository, converter);
    }

}
