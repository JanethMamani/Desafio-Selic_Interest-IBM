package InterfaceUsuario;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.xza.desafioselic.servicos.ServicoTaxa;

import Entidades.TaxaSelic;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TaxasController implements Initializable{
	
	private ServicoTaxa servicoT;
	
	@FXML
	private TableView<TaxaSelic> tabelaTaxas;
	
	@FXML
	private TableColumn<TaxaSelic, Integer> ColunaId;
	
	@FXML
	private TableColumn<TaxaSelic, Date> ColunaData;
	
	@FXML
	private TableColumn<TaxaSelic, Double> ColunaValor;
	
	@FXML
	private Button atualizar;
	
	private ObservableList <TaxaSelic> obsLista;
	
	@FXML
	public void onAtualizarAction() {
		List<TaxaSelic> taxas = servicoT.listar();
		obsLista = FXCollections.observableArrayList(taxas);
		tabelaTaxas.setItems(obsLista);
	}
	
	public void setServicoTaxa(ServicoTaxa servico) {
		servicoT = servico;
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		initializeNodes();
	}
	
	public void initializeNodes() {
		ColunaId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		ColunaData.setCellValueFactory(new PropertyValueFactory<>("Data"));
		ColunaValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
		
		Stage stage = (Stage) Main.getScenePrincipal().getWindow();
		tabelaTaxas.prefHeightProperty().bind(stage.heightProperty());
	}
	
	public void atualizarTabela() {
		if(servicoT == null) {
			throw new IllegalStateException("Serviço está nulo");
		}
		List<TaxaSelic> taxas = servicoT.listar();
		obsLista = FXCollections.observableArrayList(taxas);
		tabelaTaxas.setItems(obsLista);
	}
	
	}
