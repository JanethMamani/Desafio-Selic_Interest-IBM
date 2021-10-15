package com.xza.desafioselic.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
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
	
	public List<JSONObject> criarListaJson() {
		List<JSONObject> taxas = (List<JSONObject>) servicoConversao.parse(JSON_TAXA_URL);
		return taxas;
	}
	
	public List<TaxaSelic> converterJson(List<TaxaSelicJson> listaP){
		List<TaxaSelic> taxasConvertidas = new ArrayList<>();
		for(TaxaSelicJson item : listaP) {
			System.out.println(item.getData());
		}
		return taxasConvertidas;
	}

}
