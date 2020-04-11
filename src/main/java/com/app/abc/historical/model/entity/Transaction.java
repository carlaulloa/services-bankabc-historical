package com.app.abc.historical.model.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transaccion")
public class Transaction {

	private String id;
	
	private Integer nroPrestamo;
	
	private double importeCuota;
	
	private Integer cuota;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNroPrestamo() {
		return nroPrestamo;
	}

	public void setNroPrestamo(Integer nroPrestamo) {
		this.nroPrestamo = nroPrestamo;
	}

	public double getImporteCuota() {
		return importeCuota;
	}

	public void setImporteCuota(double importeCuota) {
		this.importeCuota = importeCuota;
	}

	public Integer getCuota() {
		return cuota;
	}

	public void setCuota(Integer cuota) {
		this.cuota = cuota;
	}
	
	
}
