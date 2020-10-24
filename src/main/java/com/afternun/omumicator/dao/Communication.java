package com.afternun.omumicator.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.time.LocalDateTime;

@Document
@Builder
@AllArgsConstructor
public class Communication {
    @Id
    private String id;

    @Field
    private String leftUser;

    @Field
    private String rightUser;

    @Field
    private String startTime;

    @Field
    private String finishTime;

    @Field
    private String publicKey;
}
