package com.mcia.inventory.backend.service;

import com.mcia.inventory.backend.entity.License;
import com.mcia.inventory.backend.repository.LicenseRepository;
import com.mcia.inventory.backend.service.converter.LicenseConverter;
import com.mcia.inventory.backend.service.request.LicenseRequest;
import org.springframework.stereotype.Service;

@Service
public class LicenseService extends BaseService<License, LicenseRequest> {

    public LicenseService(LicenseRepository repository, LicenseConverter converter){
        super(License.RESOURCE, repository, converter);
    }

}
