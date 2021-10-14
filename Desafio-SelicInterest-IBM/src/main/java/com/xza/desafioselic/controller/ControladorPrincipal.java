package com.xza.desafioselic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.xza.desafioselic.entidades.TaxaSelic;
import com.xza.desafioselic.services.ServicoConversao;

@Controller
public class ControladorPrincipal {
	
	private static final String PAGINA_PRINCIPAL = "principal";
	private static final String JSON_TAXA_URL = "https://api.bcb.gov.br/dados/serie/bcdata.sgs.4390/dados?formato=json";
	
	@Autowired
	private ServicoConversao servicoConversao;
	
	@GetMapping
	public String principal(final Model modelo) {
		List<TaxaSelic> taxas = (List<TaxaSelic>) servicoConversao.parse(JSON_TAXA_URL);
		modelo.addAllAttributes(taxas);
		return PAGINA_PRINCIPAL;
	}

}
