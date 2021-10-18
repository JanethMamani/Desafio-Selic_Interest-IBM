package com.xza.desafioselic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xza.desafioselic.entidades.TaxaSelic;
import com.xza.desafioselic.servicos.TSConector;

@RestController
@RequestMapping(value = "/taxas")
public class TSControladores {
	
	@Autowired
	TSConector conector = new TSConector();
	
	@GetMapping
	public ResponseEntity<List<TaxaSelic>> todasTaxas(){
		return ResponseEntity.ok(conector.encontrarLista());
	}
	
	@GetMapping(value = "/{anoConsultado}")
	public ResponseEntity<Integer> filtrarPorAno(@PathVariable Integer anoConsultado){
		List<TaxaSelic> taxas = conector.encontrarLista();
		System.out.println(taxas.get(2));
		return ResponseEntity.ok(anoConsultado);
	}

}
