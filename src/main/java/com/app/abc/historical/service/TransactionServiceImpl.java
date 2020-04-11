package com.app.abc.historical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.abc.historical.model.entity.Transaction;
import com.app.abc.historical.model.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements ITransactionService {

	private @Autowired TransactionRepository transactionRepository;

	@Override
	public Transaction save(Transaction transaction) {
		return this.transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> findAll() {
		return this.transactionRepository.findAll();
	}

	@Override
	public List<Transaction> findByNroPrestamo(Integer nroPrestamo) {
		return (List<Transaction>) this.transactionRepository.findByNroPrestamo(nroPrestamo);
	}

}
