package com.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	@KafkaListener(topics = "booking-confirmed", groupId = "CG1") // [cite: 146, 158, 159]
    public void consume(ConsumerRecord<String, String> record) {
        // Read partition and value payload [cite: 161]
        System.out.println("Received Record: " + record.value() + " | From Partition: " + record.partition()); // [cite: 161]
        
        // Put business logic here (e.g., Send email to user) [cite: 26, 144, 162]
    }
}
