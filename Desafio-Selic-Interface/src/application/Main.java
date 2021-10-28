package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Scene scenePrincipal;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader carregador = new FXMLLoader(getClass().getResource("/InterfaceUsuario/JanelaPrincipal.fxml"));
			ScrollPane container = carregador.load();
			
			container.setFitToHeight(true);
			container.setFitToWidth(true);
			
			scenePrincipal = new Scene(container);
			primaryStage.setScene(scenePrincipal);
			primaryStage.setTitle("Desafio aplicação consulta das Taxas SELIC");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Scene getScenePrincipal() {
		return scenePrincipal;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
