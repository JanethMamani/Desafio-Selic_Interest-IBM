package InterfaceUsuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import com.xza.desafioselic.servicos.ServicoTaxa;

import InterfaceUsuario.Util.Alerts;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class ControleJanelaPrincipal implements Initializable{
	
	@FXML
	private MenuItem menuItemTaxas;
	
	@FXML
	private MenuItem menuItemSobre;
	
	@FXML
	public void onMenuItemTaxasAction() {
		carregarVisual("/InterfaceUsuario/ListaTaxas.fxml", (TaxasController controleT) ->{
			controleT.setServicoTaxa(new ServicoTaxa());
			controleT.atualizarTabela();
		});
	}
	
	@FXML
	public void onMenuItemSobreAction() {
		carregarVisual("/InterfaceUsuario/Sobre.fxml", x -> {});
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	private synchronized <T> void carregarVisual(String absoluteName, Consumer<T> acaoInitial) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox novaVbox = loader.load();
			Scene scenePrincipal = Main.getScenePrincipal();
			VBox VBoxPrincipal = (VBox) ((ScrollPane) scenePrincipal.getRoot()).getContent();
			
			Node menuPrincipal = VBoxPrincipal.getChildren().get(0);
			VBoxPrincipal.getChildren().clear();
			VBoxPrincipal.getChildren().add(menuPrincipal);
			VBoxPrincipal.getChildren().addAll(novaVbox.getChildren());
			
			T controleDesejado = loader.getController();
			acaoInitial.accept(controleDesejado);
		}catch(IOException excep) {
			Alerts.showAlert("IOException", "Erro carregando página", excep.getMessage(), AlertType.ERROR);
		}
	}

}
