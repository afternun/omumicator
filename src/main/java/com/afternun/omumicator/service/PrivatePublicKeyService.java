package com.afternun.omumicator.service;

import com.afternun.omumicator.model.KeyPairModel;
import org.springframework.stereotype.Service;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PrivatePublicKeyService {

    private final KeyPairGenerator keyPairGenerator;
    private final Base64.Encoder encoder;
    private final Base64.Decoder decoder;

    private final static int KEY_SIZE = 2048;
    private final static String PUBLIC_TYPE = "PUBLIC";
    private final static String PRIVATE_TYPE = "PRIVATE";

    public PrivatePublicKeyService(KeyPairGenerator keyPairGenerator, Base64.Encoder encoder, Base64.Decoder decoder) {
        this.keyPairGenerator = keyPairGenerator;
        this.encoder = encoder;
        this.decoder = decoder;
    }

    public KeyPairModel generateKeyPair() {
        keyPairGenerator.initialize(KEY_SIZE);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return new KeyPairModel(encoder.encodeToString(keyPair.getPublic().getEncoded()), encoder.encodeToString(keyPair.getPrivate().getEncoded()));
    }


    public boolean areKeysMatching(KeyPairModel keyPairModel) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        byte[] pvt = decoder.decode(keyPairModel.getPrivateKey());
        byte[] pub = decoder.decode(keyPairModel.getPublicKey());
        PKCS8EncodedKeySpec specPvt = new PKCS8EncodedKeySpec(pvt);
        X509EncodedKeySpec specPub = new X509EncodedKeySpec(pub);

        // create a challenge
        byte[] challenge = new byte[10000];
        ThreadLocalRandom.current().nextBytes(challenge);

        // sign using the private key
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initSign(KeyFactory.getInstance("RSA").generatePrivate(specPvt));
        sig.update(challenge);
        byte[] signature = sig.sign();

        // verify signature using the public key
        sig.initVerify(KeyFactory.getInstance("RSA").generatePublic(specPub));
        sig.update(challenge);

        return sig.verify(signature);
    }
}
