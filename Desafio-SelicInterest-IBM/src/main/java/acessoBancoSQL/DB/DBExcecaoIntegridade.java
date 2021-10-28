package acessoBancoSQL.DB;

public class DBExcecaoIntegridade extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public DBExcecaoIntegridade(String mensagem) {
		super(mensagem);
	}
}