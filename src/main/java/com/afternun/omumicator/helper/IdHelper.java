package com.afternun.omumicator.helper;

import com.afternun.omumicator.types.DocumentType;

public class IdHelper {

    private static final String SEPARATOR = "_";

    public static String generateCommunicationId(long id) {
        return concat(DocumentType.COMMUNICATION, id);
    }

    private static String concat(DocumentType documentType, long id) {
        return documentType.getType() + SEPARATOR + id;
    }
}
