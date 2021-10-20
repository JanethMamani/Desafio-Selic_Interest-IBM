package com.xza.desafioselic.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaxaSelic {
	
	private Date data;
	private Double valor;
	
	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
	
	public TaxaSelic(Date data, Double valor) {
		this.data = data;
		this.valor = valor;
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
