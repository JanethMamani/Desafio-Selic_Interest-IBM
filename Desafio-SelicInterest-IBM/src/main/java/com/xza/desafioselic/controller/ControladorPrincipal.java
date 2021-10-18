package com.xza.desafioselic.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xza.desafioselic.entidades.TaxaSelic;

@Controller
@RequestMapping(value = "/taxas")
public class ControladorPrincipal {
	
	@Autowired
	ControladorOnboard conector;
	
	//Inicial
	@GetMapping
	public ResponseEntity<TaxaSelic> encontrarTodos(){
		TaxaSelic taxas = conector.criarListaJson();
		return ResponseEntity.ok(taxas);
	}
	
	@GetMapping(value = "/{anoConsultado}")
	public ResponseEntity<Integer> filtrarPorAno(@PathVariable Integer anoConsultado){
		TaxaSelic taxas = conector.criarListaJson();
		Calendar paraMes = Calendar.getInstance();
		System.out.println(taxas.getTaxa());
		return ResponseEntity.ok(anoConsultado);
	}

}
