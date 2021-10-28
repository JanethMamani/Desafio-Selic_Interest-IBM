package acessoBancoSQL.ImplementaDAO;

import acessoBancoSQL.DB.DB;

public class CriaDAO {
	
	public static TaxaDAO criarTaxaDAO() {
		return new TaxaSelicImpDAO(DB.getConnection());
	}

}
