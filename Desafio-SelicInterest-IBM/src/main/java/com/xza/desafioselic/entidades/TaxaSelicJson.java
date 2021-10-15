package com.xza.desafioselic.entidades;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Table

@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"data", "valor"})
@Generated("org.jsonschema2pojo")

public class TaxaSelicJson {
	
	@JsonProperty("data")
	private Date data;
	@JsonProperty("valor")
	private Double taxa;
	
	public TaxaSelicJson() {
		
	}
	
	public TaxaSelicJson(Date data, Double taxa) {
		
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
