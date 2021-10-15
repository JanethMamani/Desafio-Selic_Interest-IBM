package com.xza.desafioselic.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xza.desafioselic.entidades.TaxaSelic;
import com.xza.desafioselic.entidades.TaxaSelicJson;
import com.xza.desafioselic.services.ServicoConversao;

@Controller
@RequestMapping(value = "/taxas")
public class ControladorPrincipal {
	
	@Autowired
	ControladorOnboard conector;
	
	//Inicial
	@GetMapping
	public ResponseEntity<List<TaxaSelicJson>> encontrarTodos(){
		List<TaxaSelicJson> taxas = conector.criarListaJson();
		return ResponseEntity.ok(taxas);
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	@GetMapping(value = "/{anoConsultado}")
	public ResponseEntity<Integer> filtrarPorAno(@PathVariable Integer anoConsultado){
		List<TaxaSelicJson> taxas = conector.criarListaJson();
		Calendar paraMes = Calendar.getInstance();
		System.out.println(taxas.get(2));
		return ResponseEntity.ok(anoConsultado);
	}

}
