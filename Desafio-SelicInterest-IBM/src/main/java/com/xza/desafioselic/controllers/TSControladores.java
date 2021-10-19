package com.xza.desafioselic.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xza.desafioselic.entidades.TaxaSelic;
import com.xza.desafioselic.entidades.TaxaSelicJson;
import com.xza.desafioselic.servicos.TSConector;

@RestController
@RequestMapping(value = "/taxas")
public class TSControladores {
	
	@Autowired
	TSConector conector = new TSConector();
	
	@GetMapping
	public ResponseEntity<List<TaxaSelic>> todasTaxas() throws ParseException{
		return ResponseEntity.ok(conector.criarLista());
	}
	
	@GetMapping(value = "/{anoConsultado}")
	public ResponseEntity<Integer> filtrarPorAno(@PathVariable Integer anoConsultado) throws ParseException{
		List<TaxaSelic> taxas = conector.criarLista();
		System.out.println(taxas.get(2).getData());
		return ResponseEntity.ok(anoConsultado);
	}

}
