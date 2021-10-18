package com.xza.desafioselic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServicoConversao implements ModeloConversor {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Object parse(String url) {
		return restTemplate.getForObject(url, Object.class);
	}

}