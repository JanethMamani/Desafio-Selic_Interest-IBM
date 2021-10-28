package com.xza.desafioselic.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xza.desafioselic.entidades.TaxaSelic;
import com.xza.desafioselic.servicos.ServicoTaxas;
import com.xza.desafioselic.servicos.TSConector;

@RestController
@RequestMapping(value = "/taxas")
public class TSControladores {
	
	SimpleDateFormat ano = new SimpleDateFormat("yyyy");
	SimpleDateFormat dataI = new SimpleDateFormat("dd-MM-yyyy");
	
	@Autowired
	TSConector conector = new TSConector();
	
	ServicoTaxas servicoT = new ServicoTaxas();
	
	@GetMapping
	public ResponseEntity<String> todasTaxas() throws ParseException{
		return ResponseEntity.ok(servicoT.findAll().toString());
	}
	
	@GetMapping(value = "/{anoConsultado}")
	public ResponseEntity<String> filtrarPorAno(@PathVariable Integer anoConsultado) throws ParseException{
		List<TaxaSelic> taxas = conector.criarLista();
		List<TaxaSelic> taxasPorMes = new ArrayList<>();
		for (TaxaSelic taxa : taxas) {
			if(Integer.parseInt(ano.format(taxa.getData())) == anoConsultado) {
				taxasPorMes.add(taxa);
			}
		}
		return ResponseEntity.ok(taxasPorMes.toString());
	}
	
	@PostMapping(value = "/{data}/{valor}")
	public ResponseEntity<String> inserirDado(@PathVariable String data, @PathVariable Double valor) throws ParseException{
		int id = 101;
		TaxaSelic novaTaxa = new TaxaSelic(id, dataI.parse(data), valor);
		return ResponseEntity.ok(novaTaxa.toString());
	}

}
