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
					+ "(Data, Valor) "
					+ "VALUES "
					+ "(?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			pt.setDate(1, new java.sql.Date(taxa.getData().getTime()));
			pt.setDouble(2, taxa.getValor());
			
			int linhasAfetadas = pt.executeUpdate();
			
			if(linhasAfetadas>0) {
				ResultSet rs = pt.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					//Taxa set id
				}
				DB.fecharResultSet(rs);
			} else {
				throw new DBExcecao("Erro inesperado");
			}
		} catch(SQLException excep) {
			throw new DBExcecao("Erro inesperado! Nenhuma linha afetada!");
		} finally {
			DB.fecharStatement(pt);
		}
	}

	@Override
	public void atualizar(TaxaSelic taxa) {
		
	}

	@Override
	public void deletarPorId(Integer id) {
		
	}

	@Override
	public List<TaxaSelic> encontrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<TaxaSelic> atualizarTodos(){
		List<TaxaSelic> taxas = new ArrayList<>();
		PreparedStatement pt = null;
		try {
			taxas = conector.criarLista(); 
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
