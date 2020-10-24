package com.afternun.omumicator.types;

import lombok.Getter;

@Getter
public enum DocumentType {
    COMMUNICATION("COMMUNICATION");

    private final String type;

    DocumentType(String type) {
        this.type = type;
    }

}
