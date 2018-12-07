package com.mcia.inventory.backend.service;

import com.mcia.inventory.backend.entity.Project;
import com.mcia.inventory.backend.repository.ProjectRepository;
import com.mcia.inventory.backend.service.converter.ProjectConverter;
import com.mcia.inventory.backend.service.request.ProjectRequest;
import org.springframework.stereotype.Service;

@Service
public class ProjectService extends BaseService<Project, ProjectRequest> {

    public ProjectService(ProjectRepository repository, ProjectConverter converter) {
        super(Project.RESOURCE, repository, converter);
    }

}
