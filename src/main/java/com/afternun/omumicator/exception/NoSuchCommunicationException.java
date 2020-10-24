package com.afternun.omumicator.exception;

public class NoSuchCommunicationException extends RuntimeException {
    public NoSuchCommunicationException(long id) {
        super(String.format("Document with %s id has not been found!", id));
    }
}
