package acessoBancoSQL.ImplementaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xza.desafioselic.entidades.TaxaSelic;
import com.xza.desafioselic.servicos.TSConector;

import acessoBancoSQL.DB.DB;
import acessoBancoSQL.DB.DBExcecao;

public class TaxaSelicImpDAO implements TaxaDAO{
	
	private Connection con;
	
	@Autowired
	TSConector conector = new TSConector();
	
	public TaxaSelicImpDAO(Connection conexao) {
		con = conexao;
	}

	@Override
	public void inserir(TaxaSelic taxa) {
		PreparedStatement pt = null;
		try {
			pt = con.prepareStatement(
					"INSERT INTO taxas "
					+ "(Id, Data, Valor) "
					+ "VALUES "
					+ "(?,?,?)"
					,Statement.RETURN_GENERATED_KEYS);
				
			pt.setInt(1, taxa.getId());
			pt.setDate(2, new java.sql.Date(taxa.getData().getTime()));
			pt.setDouble(3, taxa.getValor());
				
			int linhasAfetadas = pt.executeUpdate();
				
			if(linhasAfetadas>0) {
				ResultSet rs = pt.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					taxa.setId(id);
				}
				DB.fecharResultSet(rs);
			} else {
				throw new DBExcecao("Erro inesperado. Nenhuma linha afetada!");
			}
				
		}catch(SQLException excep) {
			throw new DBExcecao(excep.getMessage());
		}finally {
			DB.fecharStatement(pt);
		}
	}

	@Override
	public void atualizar(TaxaSelic taxa) {
		
	}

	@Override
	public void deletarPorId(Integer id) {
		
	}
	
	private TaxaSelic instanciarTaxa(ResultSet rs) throws SQLException {
		TaxaSelic taxa = new TaxaSelic(rs.getInt("Id"),rs.getDate("Data"),rs.getDouble("Valor"));
		return taxa;
	}

	@Override
	public List<TaxaSelic> encontrarTodos() {
		PreparedStatement pt = null;
		ResultSet rs = null;
		List<TaxaSelic> taxas = new ArrayList<>();
		try {
			pt = con.prepareStatement(
					"SELECT * FROM taxas "
					+ "ORDER BY Id");
			rs = pt.executeQuery();
			
			while(rs.next()) {
				TaxaSelic taxa = instanciarTaxa(rs);
				taxas.add(taxa);
			}
		}catch(SQLException excep) {
			throw new DBExcecao(excep.getMessage());
		} finally {
			DB.fecharStatement(pt);
			DB.fecharResultSet(rs);
		}
		return taxas;
	}
	
	@Override
	public List<TaxaSelic> atualizarTodos(){
		List<TaxaSelic> taxas = new ArrayList<>();
		PreparedStatement pt = null;
		try {
			taxas = conector.criarLista(); 
			pt = con.prepareStatement(
					"DELETE FROM taxas WHERE Id > 0");
			pt.executeUpdate();
			for(TaxaSelic item : taxas) {
				pt = con.prepareStatement(
						"INSERT INTO taxas "
						+ "(Id, Data, Valor) "
						+ "VALUES "
						+ "(?,?,?)"
						,Statement.RETURN_GENERATED_KEYS);
				
				pt.setInt(1, item.getId());
				pt.setDate(2, new java.sql.Date(item.getData().getTime()));
				pt.setDouble(3, item.getValor());
				
				int linhasAfetadas = pt.executeUpdate();
				
				if(linhasAfetadas>0) {
					ResultSet rs = pt.getGeneratedKeys();
					if(rs.next()) {
						int id = rs.getInt(1);
						item.setId(id);
					}
					DB.fecharResultSet(rs);
				} else {
					throw new DBExcecao("Erro inesperado. Nenhuma linha afetada!");
				}
			}
				
		}catch(ParseException troca){
			troca.getMessage();
		}
		catch(SQLException excep) {
			throw new DBExcecao(excep.getMessage());
		}finally {
			DB.fecharStatement(pt);
		}
		return taxas;
	}


}
