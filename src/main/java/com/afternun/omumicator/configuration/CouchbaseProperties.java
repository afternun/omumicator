package com.afternun.omumicator.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "couchbase")
@Getter
@Setter
public class CouchbaseProperties {
    private String user;
    private String bucket;
    private String password;
    private String url;
}
