package com.afternun.omumicator.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunicatorController {

    private final CommunicationInitializerService communicationInitializerService;

    public CommunicatorController(CommunicationInitializerService communicationInitializerService) {
        this.communicationInitializerService = communicationInitializerService;
    }

    @RequestMapping(value = "initialize")
    @ResponseBody
    public String initializeCommunication() {
        return communicationInitializerService.initializeCommunication();
    }
}
