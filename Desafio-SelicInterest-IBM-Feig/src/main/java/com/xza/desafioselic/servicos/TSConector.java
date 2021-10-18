package com.xza.desafioselic.servicos;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.xza.desafioselic.entidades.TaxaSelic;

public class TSConector {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public List<TaxaSelic> encontrarLista(){
		ResponseEntity<List<TaxaSelic>> conexao = restTemplate.exchange("https://api.bcb.gov.br/dados/serie/bcdata.sgs.4390/dados?formato=json",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<TaxaSelic>>() {});
		List<TaxaSelic> taxas = conexao.getBody();
		return taxas;
	}

}
