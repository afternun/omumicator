package com.afternun.omumicator.service;

import com.afternun.omumicator.model.CommunicationModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

@RestController
public class CommunicatorController {

    private final CommunicationInitializerService communicationInitializerService;

    public CommunicatorController(CommunicationInitializerService communicationInitializerService) {
        this.communicationInitializerService = communicationInitializerService;
    }

    @RequestMapping(value = "initializeCommunication")
    @ResponseBody
    public CommunicationModel initializeCommunication() {
        return communicationInitializerService.initializeCommunication();
    }

    @RequestMapping(value = "connectCommunication")
    @ResponseBody
    public String connectCommunication(@RequestBody CommunicationModel communicationModel) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        return communicationInitializerService.connectCommunication(communicationModel);
    }

    @RequestMapping(value = "killCommunication")
    @ResponseBody
    public String killCommunication(@RequestBody CommunicationModel communicationModel) {
        return communicationInitializerService.killCommunication(communicationModel);
    }
}
