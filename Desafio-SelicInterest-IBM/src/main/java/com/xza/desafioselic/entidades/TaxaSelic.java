package com.xza.desafioselic.entidades;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties
public class TaxaSelic {
	
	private Date data;
	private Double taxa;
	
	public TaxaSelic(Date data, Double taxa) {
		
		this.data = data;
		this.taxa = taxa;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getTaxa() {
		return taxa;
	}
	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	
}
