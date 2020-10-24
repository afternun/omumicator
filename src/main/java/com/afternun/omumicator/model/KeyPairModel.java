package com.afternun.omumicator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KeyPairModel {
    private String publicKey;
    private String privateKey;
}
