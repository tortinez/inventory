package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.Printer;
import com.mcia.inventory.backend.repository.PrinterRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PrinterController.URI)
public class PrinterController extends BaseController<Printer>{

    public static final String URI = WebConfig.BASE_API_PATH + "/" + Printer.RESOURCE;


    protected PrinterController(PrinterRepository repository){
        super(repository);
    }

}