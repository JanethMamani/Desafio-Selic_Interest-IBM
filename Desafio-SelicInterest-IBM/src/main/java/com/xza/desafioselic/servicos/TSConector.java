package com.xza.desafioselic.servicos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xza.desafioselic.entidades.TaxaSelic;
import com.xza.desafioselic.entidades.TaxaSelicJson;

@Service
public class TSConector {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public List<TaxaSelicJson> encontrarLista(){
		ResponseEntity<List<TaxaSelicJson>> conexao = restTemplate.exchange("https://api.bcb.gov.br/dados/serie/bcdata.sgs.4390/dados?formato=json",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<TaxaSelicJson>>() {});
		List<TaxaSelicJson> taxas = conexao.getBody();
		return taxas;
	}
	
	public List<TaxaSelic> criarLista() throws ParseException{
		List<TaxaSelicJson> paraConverter = encontrarLista();
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		List<TaxaSelic> taxas = new ArrayList<>();
		for(TaxaSelicJson item : paraConverter) {
			TaxaSelic taxa = new TaxaSelic( formatoData.parse(item.getData()), item.getValor());
			taxas.add(taxa);
		}
		return taxas;
	}

}
