package com.example.analyticss_service.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import user.events.User;

@Component
public class KafkaConsumer {
    @KafkaListener(topics="user" , groupId = "analyticss-service")
    public void consumeEvent(byte[] event) throws InvalidProtocolBufferException {
        User user = User.parseFrom(event);
    }
}
