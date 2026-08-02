package com.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.producer.KafkaProducerService;

@Service
public class KafkaService {
	
	@Autowired
	KafkaProducerService kafkaProducerService;
	
	public void publishToKafka(String pnr) {
		for(int i=1;i<=200; ++i)
			kafkaProducerService.publishMessage("booking-confirmed",i+"", "This is a test booking with pnr ="+pnr);
	}
	
}
