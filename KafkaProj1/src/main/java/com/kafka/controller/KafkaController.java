package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.KafkaProducerService;
import com.kafka.service.KafkaService;

@RestController
public class KafkaController {
	
	@Autowired
	KafkaService kafkaService;
	
	@PostMapping("/kafka/produce")
	public void produce(@RequestParam String pnr) {
		kafkaService.publishToKafka(pnr);
	}
	
}
