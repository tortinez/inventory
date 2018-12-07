package com.mcia.inventory.backend.service;

import com.mcia.inventory.backend.entity.Computer;
import com.mcia.inventory.backend.repository.ComputerRepository;
import com.mcia.inventory.backend.service.converter.ComputerConverter;
import com.mcia.inventory.backend.service.request.ComputerRequest;
import org.springframework.stereotype.Service;

@Service
public class ComputerService extends BaseService<Computer, ComputerRequest> {

    public ComputerService(ComputerRepository repository, ComputerConverter converter) {
        super(Computer.RESOURCE, repository, converter);
    }

}
