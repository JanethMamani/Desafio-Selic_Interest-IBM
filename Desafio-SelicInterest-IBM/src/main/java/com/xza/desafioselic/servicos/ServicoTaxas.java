package com.xza.desafioselic.servicos;

import java.util.List;

import com.xza.desafioselic.entidades.TaxaSelic;

import acessoBancoSQL.ImplementaDAO.CriaDAO;
import acessoBancoSQL.ImplementaDAO.TaxaDAO;

public class ServicoTaxas {
	
	private TaxaDAO daoT = CriaDAO.criarTaxaDAO();
	
	public List<TaxaSelic> findAll(){
		return daoT.encontrarTodos();
	}
}
