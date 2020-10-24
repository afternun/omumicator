package com.afternun.omumicator.helper;

import com.afternun.omumicator.types.DocumentType;

public class IdHelper {

    private static final String SEPARATOR = "_";

    public static String generateCommunicationId(String id) {
        return concat(DocumentType.COMMUNICATION, id);
    }

    private static String concat(DocumentType documentType, String id) {
        return documentType.getType() + SEPARATOR + id;
    }
}
