package nl.novi.backend.techiteasy.controllers;

import nl.novi.backend.techiteasy.services.CIModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cimodules")
public class CIModuleController {
    private final CIModuleService ciModuleService;

    @Autowired
    public CIModuleController(CIModuleService ciModuleService){
        this.ciModuleService = ciModuleService;
    }
}
