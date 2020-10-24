package com.afternun.omumicator.service;

import com.afternun.omumicator.dao.Communication;
import com.afternun.omumicator.exception.KeysNotMatchedException;
import com.afternun.omumicator.helper.IdHelper;
import com.afternun.omumicator.model.CommunicationModel;
import com.afternun.omumicator.model.KeyPairModel;
import com.afternun.omumicator.repository.CommunicationRepository;
import com.afternun.omumicator.repository.CounterRepository;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommunicationInitializerService {

    private final CommunicationRepository communicationRepository;
    private final CounterRepository counterRepository;
    private final PrivatePublicKeyService privatePublicKeyService;

    public CommunicationInitializerService(CommunicationRepository communicationRepository, CounterRepository counterRepository, PrivatePublicKeyService privatePublicKeyService) {
        this.communicationRepository = communicationRepository;
        this.counterRepository = counterRepository;
        this.privatePublicKeyService = privatePublicKeyService;
    }

    public CommunicationModel initializeCommunication() {
        long id = counterRepository.incrementCommunicationCounter();
        KeyPairModel keyPair = privatePublicKeyService.generateKeyPair();
        Communication communication = Communication.builder()
                .id(IdHelper.generateCommunicationId(id))
                .leftUser("123456")
                .rightUser("643343")
                .startTime(LocalDateTime.now().toString())
                .publicKey(keyPair.getPublicKey())
                .build();
        communicationRepository.save(communication);
        return new CommunicationModel(id, keyPair.getPrivateKey());
    }

    public String connectCommunication(CommunicationModel communicationModel) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Communication communication = Optional.of(communicationRepository.findById(IdHelper.generateCommunicationId(communicationModel.getId())))
                .get().orElseThrow(() -> new RuntimeException("NO SUCH DOCUMENT EXCEPTION"));

        if(privatePublicKeyService.areKeysMatching(new KeyPairModel(communication.getPublicKey(), communicationModel.getKey()))) {
            return "Good job! You can start texting!";
        }

        return "SHAME!";
    }

    public String killCommunication(CommunicationModel communicationModel) {
        Communication communication = Optional.of(communicationRepository.findById(IdHelper.generateCommunicationId(communicationModel.getId())))
                .get().orElseThrow(() -> new RuntimeException("NO SUCH DOCUMENT EXCEPTION"));
        try {
            if(privatePublicKeyService.areKeysMatching(new KeyPairModel(communication.getPublicKey(), communicationModel.getKey()))) {
                communicationRepository.deleteById(IdHelper.generateCommunicationId(communicationModel.getId()));
                return "Thank you! Communication data has been removed.";
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | SignatureException e) {
            throw new KeysNotMatchedException();
        }

        return "SHAME";
    }
}
