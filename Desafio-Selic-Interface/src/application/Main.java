package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader carregador = new FXMLLoader(getClass().getResource("InterfaceUsuario/JanelaPrincipal.fxml"));
			Parent parent = carregador.load();
			Scene scenePrincipal = new Scene(parent);
			primaryStage.setScene(scenePrincipal);
			primaryStage.setTitle("Desafio aplicação consulta das Taxas SELIC");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
