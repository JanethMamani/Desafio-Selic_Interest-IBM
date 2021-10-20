package com.xza.desafioselic.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	public ResponseEntity<String> todasTaxas() throws ParseException{
		return ResponseEntity.ok(conector.criarLista().toString());
	}
	
	@GetMapping(value = "/{anoConsultado}")
	public ResponseEntity<String> filtrarPorAno(@PathVariable Integer anoConsultado) throws ParseException{
		List<TaxaSelic> taxas = conector.criarLista();
		SimpleDateFormat ano = new SimpleDateFormat("yyyy");
		
		List<TaxaSelic> taxasPorMes = new ArrayList<>();
		for (TaxaSelic taxa : taxas) {
			if(Integer.parseInt(ano.format(taxa.getData())) == anoConsultado) {
				taxasPorMes.add(taxa);
			}
		}
		return ResponseEntity.ok(taxasPorMes.toString());
	}

}
