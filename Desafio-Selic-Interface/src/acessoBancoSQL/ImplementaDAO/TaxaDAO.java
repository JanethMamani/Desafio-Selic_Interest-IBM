package acessoBancoSQL.ImplementaDAO;

import java.util.List;

import Entidades.TaxaSelic;

public interface TaxaDAO {
	
	void inserir(TaxaSelic taxa);
	void atualizar(TaxaSelic taxa);
	void deletarPorId(Integer id);
	List<TaxaSelic> atualizarTodos();
	List<TaxaSelic> encontrarTodos();

}
