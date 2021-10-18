package com.xza.desafioselic.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.xza.desafioselic.entidades.TaxaSelic;
import com.xza.desafioselic.entidades.TaxaSelicJson;
import com.xza.desafioselic.services.ServicoConversao;

@RestController
public class ControladorOnboard {
	
	private static final String JSON_TAXA_URL = "https://api.bcb.gov.br/dados/serie/bcdata.sgs.4390/dados?formato=json";
	SimpleDateFormat dataGeral = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private ServicoConversao servicoConversao;
	
	public TaxaSelic criarListaJson() {
		TaxaSelic taxa =  servicoConversao.parse(JSON_TAXA_URL);
		return taxa;
	}
	
	public List<TaxaSelic> converterJson(List<TaxaSelicJson> listaP){
		
		return null;
	}

}
