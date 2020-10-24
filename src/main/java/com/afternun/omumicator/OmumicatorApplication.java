package com.afternun.omumicator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@SpringBootApplication
public class OmumicatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OmumicatorApplication.class, args);
    }

    @Bean
    KeyPairGenerator keyPairGenerator() throws NoSuchAlgorithmException {
        return KeyPairGenerator.getInstance("RSA");
    }

    @Bean
    Base64.Encoder encoder() {
        return Base64.getEncoder();
    }

    @Bean
    Base64.Decoder decoder() {
        return Base64.getDecoder();
    }
}
