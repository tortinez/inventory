package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.Project;
import com.mcia.inventory.backend.service.ProjectService;
import com.mcia.inventory.backend.service.request.ProjectRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ProjectController.URI)
public class ProjectController extends BaseController<Project, ProjectRequest> {

    static final String URI = WebConfig.BASE_API_PATH + "/" + Project.RESOURCE;


    protected ProjectController(ProjectService service) {
        super(ProjectController.URI, service);
    }

}