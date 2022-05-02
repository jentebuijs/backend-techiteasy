package nl.novi.backend.techiteasy.controllers;

import nl.novi.backend.techiteasy.services.RemoteControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("remotecontrols")
public class RemoteControlController {
    private final RemoteControlService remoteControlService;

    @Autowired
    public RemoteControlController(RemoteControlService remoteControlService) {
        this.remoteControlService = remoteControlService;
    }
}
