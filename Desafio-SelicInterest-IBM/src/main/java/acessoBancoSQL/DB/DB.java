package acessoBancoSQL.DB;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	private static Connection con = null;
	
	public static Connection getConnection() {
		if(con == null) {
			try {
				Properties prop = carregarPropriedades();
				String url = prop.getProperty("dburl");
				con = DriverManager.getConnection(url, prop);
			} catch (SQLException excep) {
				throw new DBExcecao(excep.getMessage());
			}
		}
		return con;
	}
	
	public static void closeConnection() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException excep) {
				throw new DBExcecao(excep.getMessage());
			}
		}
	}
	
	public static Properties carregarPropriedades() {
		try(FileInputStream fs = new FileInputStream("db.properties")){
			Properties prop = new Properties();
			prop.load(fs);
			return prop;
		} catch(IOException excep) {
			throw new DBExcecao(excep.getMessage());
		}
	}
	
	public static void fecharStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			}catch(SQLException excep) {
				throw new DBExcecao(excep.getMessage());
			}
		}
	}
	
	public static void fecharResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			}catch(SQLException excep) {
				throw new DBExcecao(excep.getMessage());
			}
		}
	}
	
}
