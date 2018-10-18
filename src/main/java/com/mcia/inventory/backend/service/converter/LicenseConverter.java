package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.License;
import com.mcia.inventory.backend.entity.Supplier;
import com.mcia.inventory.backend.repository.SupplierRepository;
import com.mcia.inventory.backend.service.request.LicenseRequest;
import org.springframework.stereotype.Component;


@Component
public class LicenseConverter implements RequestConverter<License, LicenseRequest> {

    private SupplierRepository supplierRepository;

    @Override
    public License toEntity(LicenseRequest request, Long... optId) {
        Long id = (optId[0] != null) ? optId[0] : -1;

        Supplier supplier = supplierRepository.findById(request.getSupplierId()).orElse(null);

        return new License(id,
                request.getName(),
                request.getSoftwareType(),
                request.getType(),
                request.getDongle(),
                request.getActivationDate(),
                request.getRenewalDate(),
                request.getRenewalType(),
                supplier);
    }


}
