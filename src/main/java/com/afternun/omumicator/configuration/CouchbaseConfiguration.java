package com.afternun.omumicator.configuration;

import com.couchbase.client.java.Bucket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.afternun.omumicator.repository"})
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

    private final CouchbaseProperties couchbaseProperties;

    public CouchbaseConfiguration(CouchbaseProperties couchbaseProperties) {
        this.couchbaseProperties = couchbaseProperties;
    }

    @Override
    public String getConnectionString() {
        return "couchbase://" + couchbaseProperties.getUrl();
    }

    @Override
    public String getUserName() {
        return couchbaseProperties.getUser();
    }

    @Override
    public String getPassword() {
        return couchbaseProperties.getPassword();
    }

    @Override
    public String getBucketName() {
        return couchbaseProperties.getBucket();
    }

    @Bean
    public Bucket getBucket() {
        return couchbaseCluster(couchbaseClusterEnvironment()).bucket(getBucketName());
    }
}
