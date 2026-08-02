package com.profiles.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
//    private final KafkaTemplate<String,String> kafkaTemplate;
	private final KafkaTemplate<String, String> kafkaTemplate;

    KafkaProducerService(KafkaTemplate<String,String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    } 

    public void publishMessage(String topic, String message){
        ProducerRecord<String,String> record = new ProducerRecord<String,String>(topic, message);
        kafkaTemplate.send(record);
    }

}
