package com.app.abc.historical.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.abc.historical.model.entity.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import brave.Tracer;

@Service
public class TransactionEvents {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionEvents.class);
	private @Autowired ITransactionService transactionService;
	private @Autowired ObjectMapper objectMapper;
	private @Autowired Tracer tracer;
	
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, 
		JsonProcessingException {
		LOGGER.info("Before process consumer record {}", consumerRecord);
		Transaction transaction = this.objectMapper.readValue(consumerRecord.value(), Transaction.class);
		LOGGER.info("Mapped transaction");
		this.tracer.currentSpan().tag("info", "Consumer record mapeado.");
		this.transactionService.save(transaction);
		LOGGER.info("Persisted successfully transaction {}", transaction);
		this.tracer.currentSpan().tag("info", "Transaccion guardada con exito.");
	}
}
