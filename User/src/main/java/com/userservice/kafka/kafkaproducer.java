package com.userservice.kafka;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.userservice.User.model.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafkaproducer {

    public static final String USER_EVENTS_TOPIC = "user-events";

    private static final Logger log = LoggerFactory.getLogger(kafkaproducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public kafkaproducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendUserCreatedEvent(user createdUser) {
        String key = String.valueOf(createdUser.getId());

        Map<String, String> event = new LinkedHashMap<>();
        event.put("eventType", "USER_CREATED");
        event.put("id", key);
        event.put("username", createdUser.getUsername());
        event.put("email", createdUser.getEmail());

        try {
            kafkaTemplate.send(USER_EVENTS_TOPIC, key, objectMapper.writeValueAsString(event));
            log.info("Published USER_CREATED event for user {}", key);
        } catch (JsonProcessingException e) {
            log.error("Failed to serialize USER_CREATED event for user {}", key, e);
        }
    }
}
