package Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import View.Telas;
import dto.DisciplinaDTO;
import dto.QuestoesObjetivasDTO;
import model.service.QuestoesObjetivasBO; 
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TeladeQuestoesController implements Initializable{
	@FXML private TableView<QuestoesObjetivasDTO> tabelaQuestoesObjetivas;
	@FXML private TableColumn<QuestoesObjetivasDTO, String> columnCodigoObjetivas;
	@FXML private TableColumn<QuestoesObjetivasDTO, String> columnDisciplinaObjetivas;
	@FXML private TableColumn<QuestoesObjetivasDTO, String> columnDificuldadeObjetivas;
	@FXML private TableColumn<QuestoesObjetivasDTO, String> columnAssuntoObjetivas;
	@FXML private TableColumn<QuestoesObjetivasDTO, String> columnEnunciadoObjetivas;
	
	private QuestoesObjetivasBO bo = new QuestoesObjetivasBO();
	 private ObservableList<QuestoesObjetivasDTO> listaDeQuestoesObjetivas;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void adicionar(){
		Telas.TelaTipodeQuestao();
	}
	
	public void inicio() {
		Telas.TelaDashboard();
	}
	
	public void provas() {
		Telas.TeladeProvas();
	}
	
	public void disciplinas() {
		Telas.TeladeDisciplina();
	}
	
	public void questoes() {
		Telas.TeladeQuestoes();
	}
}
