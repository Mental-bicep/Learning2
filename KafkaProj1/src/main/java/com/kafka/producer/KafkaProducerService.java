package com.kafka.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate; // [cite: 52, 53]

    public void publishMessage(String topic,String key, String message) {
        // Create a ProducerRecord with Topic, Key, and Value/Payload [cite: 55, 57]
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, message); // [cite: 55]
        kafkaTemplate.send(record); // [cite: 53]
    }
	
}
