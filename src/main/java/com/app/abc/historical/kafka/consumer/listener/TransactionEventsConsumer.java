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

@Component
public class TransactionEventsConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionEventsConsumer.class);
	private @Autowired TransactionEvents transactionEvents;
	
	@KafkaListener(topics = {"payment-events"})
	public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, 
		JsonProcessingException {
		LOGGER.info("Consumer record historical {}", consumerRecord);
		this.transactionEvents.processTransactionEvent(consumerRecord);
	}
}
