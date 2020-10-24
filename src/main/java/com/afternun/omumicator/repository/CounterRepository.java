package com.afternun.omumicator.repository;

import com.afternun.omumicator.types.DocumentCounter;
import com.couchbase.client.java.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CounterRepository {

    private final Bucket bucket;

    public CounterRepository(Bucket bucket) {
        this.bucket = bucket;
    }

    public String incrementCommunicationCounter() {
        return bucket.defaultCollection()
                .binary()
                .increment(DocumentCounter.COMMUNICATION_COUNTER.getCounterName())
                .toString();
    }
}
