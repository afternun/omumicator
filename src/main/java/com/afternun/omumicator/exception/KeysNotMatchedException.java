package com.afternun.omumicator.exception;

public class KeysNotMatchedException extends RuntimeException {
    public KeysNotMatchedException() {
        super("PROVIDED KEYS WERE WRONG!");
    }
}
