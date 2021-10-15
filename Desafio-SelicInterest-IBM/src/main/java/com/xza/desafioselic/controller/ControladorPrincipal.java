package com.xza.desafioselic.controller;

import java.util.Calendar;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xza.desafioselic.entidades.TaxaSelicJson;

@Controller
@RequestMapping(value = "/taxas")
public class ControladorPrincipal {
	
	@Autowired
	ControladorOnboard conector;
	
	//Inicial
	@GetMapping
	public ResponseEntity<List<JSONObject>> encontrarTodos(){
		List<JSONObject> taxas = conector.criarListaJson();
		return ResponseEntity.ok(taxas);
	}
	
	@GetMapping(value = "/{anoConsultado}")
	public ResponseEntity<Integer> filtrarPorAno(@PathVariable Integer anoConsultado){
		List<JSONObject> taxas = conector.criarListaJson();
		Calendar paraMes = Calendar.getInstance();
		
		Object desconhecido = taxas.get(2);
		
		return ResponseEntity.ok(anoConsultado);
	}

}
