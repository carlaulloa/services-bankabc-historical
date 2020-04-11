package com.app.abc.historical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.abc.historical.model.entity.Transaction;
import com.app.abc.historical.service.ITransactionService;

@RestController
public class HistoricalController {

	private @Autowired ITransactionService transactionService;
	
	@GetMapping("/v1/transactions")
	public List<Transaction> findAll(){
		return this.transactionService.findAll();
	}
	
	@GetMapping("/v1/transactions/loans/{nroPrestamo}")
	public List<Transaction> findByNroPrestamo(@PathVariable Integer nroPrestamo){
		return this.transactionService.findByNroPrestamo(nroPrestamo);
	}
}
