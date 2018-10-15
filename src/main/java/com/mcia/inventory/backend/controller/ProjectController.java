package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.Project;
import com.mcia.inventory.backend.repository.ProjectRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ProjectController.URI)
public class ProjectController extends BaseController<Project>{

    public static final String URI = WebConfig.BASE_API_PATH + "/project";


    protected ProjectController(ProjectRepository repository){
        super(repository);
    }

}