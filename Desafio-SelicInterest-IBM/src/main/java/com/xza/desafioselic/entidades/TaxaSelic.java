package com.xza.desafioselic.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaxaSelic {
	
<<<<<<< HEAD
	private int id;
	
=======
>>>>>>> parent of d62068e (Acesso ao banco de dados)
	private Date data;
	private Double valor;
	
	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
	
<<<<<<< HEAD
	public TaxaSelic(int id, Date data, Double valor) {
		this.id = id;
=======
	public TaxaSelic(Date data, Double valor) {
>>>>>>> parent of d62068e (Acesso ao banco de dados)
		this.data = data;
		this.valor = valor;
	}
	
<<<<<<< HEAD
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
=======
>>>>>>> parent of d62068e (Acesso ao banco de dados)
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
		return id + " - " + "Data: " + formatoData.format(data) + " - " + "Valor = " + String.format("%.2f", valor) + "\n";
	}
	
}
