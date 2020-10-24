package com.afternun.omumicator.service;

import com.afternun.omumicator.dao.Communication;
import com.afternun.omumicator.helper.IdHelper;
import com.afternun.omumicator.repository.CommunicationRepository;
import com.afternun.omumicator.repository.CounterRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommunicationInitializerService {

    private final CommunicationRepository communicationRepository;
    private final CounterRepository counterRepository;

    public CommunicationInitializerService(CommunicationRepository communicationRepository, CounterRepository counterRepository) {
        this.communicationRepository = communicationRepository;
        this.counterRepository = counterRepository;
    }

    public String initializeCommunication() {
        String id = counterRepository.incrementCommunicationCounter();
        Communication communication = Communication.builder()
                .id(IdHelper.generateCommunicationId(id))
                .leftUser("123456")
                .rightUser("643343")
                .startTime(LocalDateTime.now().toString())
                .publicKey("someKey")
                .build();
        communicationRepository.save(communication);
        return id;
    }
}
