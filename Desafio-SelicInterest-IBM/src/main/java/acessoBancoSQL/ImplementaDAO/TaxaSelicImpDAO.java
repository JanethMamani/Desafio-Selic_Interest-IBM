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
		PreparedStatement pt = null;
		try {
			pt = con.prepareStatement(
					"UPDATE taxas "
					+ "SET Data = ?, Valor = ? "
					+ "WHERE Id = ?");
			
			pt.setDate(1, new java.sql.Date(taxa.getData().getTime()));
			pt.setDouble(2, taxa.getValor());
			pt.setInt(3, 0);
			
			pt.executeUpdate();
		}catch(SQLException excep) {
			throw new DBExcecao(excep.getMessage());
		}finally {
			DB.fecharStatement(pt);
		}
	}

	@Override
	public void deletarPorId(Integer id) {
		
	}

	@Override
	public TaxaSelic encontrarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private TaxaSelic instanciarTaxa(ResultSet rs) throws SQLException {
		TaxaSelic taxa = new TaxaSelic(rs.getLong("Id"), rs.getDate("Data"), rs.getDouble("Valor"));
		return taxa;
	}

	@Override
	public List<TaxaSelic> encontrarTodos(){
		List<TaxaSelic> taxas = new ArrayList<>();
		PreparedStatement pt = null;
		ResultSet rs = null;
		try {
			taxas = conector.criarLista(); 
			for(TaxaSelic item : taxas) {
				pt = con.prepareStatement(
						"INSERT INTO taxas "
						+ "(Id, Data, Valor) "
						+ "VALUES "
						+ "(?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);
				
				pt.setLong(1, item.getId());
				pt.setDate(2, new java.sql.Date(item.getData().getTime()));
				pt.setDouble(3, item.getValor());
			}
		}catch(ParseException troca){
			troca.getMessage();
		}
		catch(SQLException excep) {
			throw new DBExcecao(excep.getMessage());
		}finally {
			DB.fecharStatement(pt);
			DB.fecharResultSet(rs);
		}
		return taxas;
	}

	@Override
	public List<TaxaSelic> encontrarPorTaxa(TaxaSelic taxa) {
		// TODO Auto-generated method stub
		return null;
	}

}
