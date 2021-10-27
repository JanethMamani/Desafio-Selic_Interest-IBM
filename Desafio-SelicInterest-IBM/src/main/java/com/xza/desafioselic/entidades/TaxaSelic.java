package com.xza.desafioselic.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaxaSelic {
	
	private Long id;
	
	private Date data;
	private Double valor;
	
	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
	
	public TaxaSelic(Long id, Date data, Double valor) {
		this.id = id;
		this.data = data;
		this.valor = valor;
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getData(){
		return(data);
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Data: " + formatoData.format(data) + " - " + "Valor = " + String.format("%.2f", valor) + "\n";
	}
	
}
