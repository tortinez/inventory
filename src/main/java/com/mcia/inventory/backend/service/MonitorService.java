package com.mcia.inventory.backend.service;

import com.mcia.inventory.backend.entity.Monitor;
import com.mcia.inventory.backend.repository.MonitorRepository;
import com.mcia.inventory.backend.service.converter.MonitorConverter;
import com.mcia.inventory.backend.service.request.MonitorRequest;
import org.springframework.stereotype.Service;

@Service
public class MonitorService extends BaseService<Monitor, MonitorRequest> {

    public MonitorService(MonitorRepository repository, MonitorConverter converter) {
        super(Monitor.RESOURCE, repository, converter);
    }

}
