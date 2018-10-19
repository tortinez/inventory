package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.Printer;
import com.mcia.inventory.backend.service.PrinterService;
import com.mcia.inventory.backend.service.request.PrinterRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PrinterController.URI)
public class PrinterController extends BaseController<Printer, PrinterRequest> {

    static final String URI = WebConfig.BASE_API_PATH + "/" + Printer.RESOURCE;


    protected PrinterController(PrinterService service) {
        super(PrinterController.URI, service);
    }

}