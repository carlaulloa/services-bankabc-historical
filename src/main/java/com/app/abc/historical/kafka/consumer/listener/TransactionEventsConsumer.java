package com.app.abc.historical.kafka.consumer.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.app.abc.historical.service.TransactionEvents;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import brave.Tracer;

@Component
public class TransactionEventsConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionEventsConsumer.class);
	private @Autowired TransactionEvents transactionEvents;
	private @Autowired Tracer tracer;
	
	@KafkaListener(topics = {"payment-events"})
	public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, 
		JsonProcessingException {
		LOGGER.info("Consumer record historical {}", consumerRecord);
		this.tracer.currentSpan().tag("info", "Consumer record recibido " + consumerRecord.value());
		this.transactionEvents.processTransactionEvent(consumerRecord);
	}
}
