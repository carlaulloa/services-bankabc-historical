package com.app.abc.historical.service;

import java.util.List;

import com.app.abc.historical.model.entity.Transaction;

public interface ITransactionService {

	Transaction save(Transaction transaction);
	
	List<Transaction> findAll();
	
	List<Transaction> findByNroPrestamo(Integer nroPrestamo);
}
