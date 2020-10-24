package com.afternun.omumicator.types;

import lombok.Getter;

@Getter
public enum DocumentCounter {
    COMMUNICATION_COUNTER("COMMUNICATION_COUNTER");

    private final String counterName;

    DocumentCounter(String counterName) {
        this.counterName = counterName;
    }
}
