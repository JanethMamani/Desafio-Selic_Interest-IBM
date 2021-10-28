package com.xza.desafioselic.servicos;

import java.util.List;

import com.xza.desafioselic.entidades.TaxaSelic;

import acessoBancoSQL.ImplementaDAO.CriaDAO;
import acessoBancoSQL.ImplementaDAO.TaxaDAO;

public class ServicoTaxa {
	
	private TaxaDAO taxaDAO = CriaDAO.criarTaxaDAO();
	
	public List<TaxaSelic> atualizarTodos(){
		return taxaDAO.atualizarTodos();
	}
	
	public List<TaxaSelic> listar(){
		return taxaDAO.encontrarTodos();
	}
	
	public void inserir(TaxaSelic taxa) {
		taxaDAO.inserir(taxa);
	}

}
