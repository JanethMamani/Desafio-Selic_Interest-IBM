package com.xza.desafioselic.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xza.desafioselic.entidades.TaxaSelic;
import com.xza.desafioselic.servicos.ServicoTaxa;
import com.xza.desafioselic.servicos.TSConector;

@RestController
@RequestMapping(value = "/taxas")
public class TSControladores {
	
	SimpleDateFormat ano = new SimpleDateFormat("yyyy");
	SimpleDateFormat dataI = new SimpleDateFormat("dd-MM-yyyy");
	
	ServicoTaxa servicoT = new ServicoTaxa();
	
	@Autowired
	TSConector conector = new TSConector();
	
	@GetMapping
	public ResponseEntity<String> todasTaxas() throws ParseException{
		return ResponseEntity.ok(servicoT.atualizarTodos().toString());
	}
	
	@GetMapping(value = "/{anoConsultado}")
	public ResponseEntity<String> filtrarPorAno(@PathVariable Integer anoConsultado) throws ParseException{
		List<TaxaSelic> taxas = servicoT.listar();
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
		List<TaxaSelic> taxas = servicoT.listar();
		int id = taxas.size() + 1;
		TaxaSelic novaTaxa = new TaxaSelic(id, dataI.parse(data), valor);
		servicoT.inserir(novaTaxa);
		taxas = servicoT.listar();
		return ResponseEntity.ok(taxas.toString());
	}
	
	@PutMapping(value = "/{id}/{data}/{valor}")
	public ResponseEntity<String> atualizarDado(@PathVariable Integer id, @PathVariable String data, @PathVariable Double valor) throws ParseException{
		TaxaSelic taxaAtualizar = new TaxaSelic(id, dataI.parse(data), valor);
		servicoT.atualizar(taxaAtualizar);
		List<TaxaSelic> taxas = servicoT.listar();
		return ResponseEntity.ok(taxas.toString());
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deletarDado(@PathVariable Integer id){
		servicoT.deletarPorId(id);
		List<TaxaSelic> taxas = servicoT.listar();
		return ResponseEntity.ok(taxas.toString());
	}

}
