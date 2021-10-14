package com.xza.desafioselic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xza.desafioselic.entidades.TaxaSelic;
import com.xza.desafioselic.services.ServicoConversao;

@Controller
@RequestMapping(value = "/taxas")
public class ControladorPrincipal {
	
	//private static final String PAGINA_PRINCIPAL = "principal";
	private static final String JSON_TAXA_URL = "https://api.bcb.gov.br/dados/serie/bcdata.sgs.4390/dados?formato=json";
	
	@Autowired
	private ServicoConversao servicoConversao;
	
	//Inicial
	@GetMapping
	public ResponseEntity<List<TaxaSelic>> encontrarTodos(final Model modelo){
		List<TaxaSelic> taxasS = (List<TaxaSelic>) servicoConversao.parse(JSON_TAXA_URL);
		modelo.addAllAttributes(taxasS);
		return ResponseEntity.ok(taxasS);
	}

}
