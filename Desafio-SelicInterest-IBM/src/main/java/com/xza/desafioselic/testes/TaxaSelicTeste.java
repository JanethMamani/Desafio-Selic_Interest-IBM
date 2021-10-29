package com.xza.desafioselic.testes;

import static org.junit.Assert.assertArrayEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.xza.desafioselic.entidades.TaxaSelic;
import com.xza.desafioselic.servicos.TSConector;

public class TaxaSelicTeste {
	
	@Rule
	public ErrorCollector erro = new ErrorCollector();
	
	@Test
	public void testeTaxa() throws ParseException {
		//Construtor
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		TaxaSelic taxa1 = new TaxaSelic(500, formatoData.parse("10/07/2021") , 3.38);
		TaxaSelic taxa2 = new TaxaSelic(500, formatoData.parse("10/07/2021") , 3.38);
		
		
		erro.checkThat(taxa1.getValor(), CoreMatchers.is(3.38));
		Assert.assertEquals(3.38, taxa2.getValor(), 0.1);
		Assert.assertEquals("Objetos semelhantes", taxa1, taxa2);
	}
	
	@Test
	public void testeListaNaoNula() {
		TSConector conector = new TSConector();
		
		try {
			List<TaxaSelic> taxas = conector.criarLista();
			Assert.assertEquals("A lista não está vazia", conector.criarLista().get(2), taxas.get(2));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
