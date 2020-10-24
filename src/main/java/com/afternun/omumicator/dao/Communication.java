package com.afternun.omumicator.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
@Builder
@AllArgsConstructor
@Getter
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
    private String publicKey;
}
