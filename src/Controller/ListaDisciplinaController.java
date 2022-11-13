package Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Dto.DisciplinaDTO;
import View.Telas;
import model.service.DisciplinaBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaDisciplinaController implements Initializable {
	@FXML private TableView<DisciplinaDTO> tabelaDisciplina;
	@FXML private TableColumn<DisciplinaDTO, String> columnNome;
	@FXML private TableColumn<DisciplinaDTO, String> columnCodigo;
	@FXML private TableColumn<DisciplinaDTO, String> columnAssuntos;
	private DisciplinaBO bo = new DisciplinaBO();
    private ObservableList<DisciplinaDTO> listaDeDisciplinas;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listarDisciplinas();
	}
	public void listarDisciplinas() {
		List<DisciplinaDTO> disciplinas = bo.listar();
		listaDeDisciplinas = FXCollections.observableArrayList(disciplinas);
		columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnAssuntos.setCellValueFactory(new PropertyValueFactory<>("assuntos"));
		tabelaDisciplina.setItems(listaDeDisciplinas);
		
	}
	
	public void realizarcadastro() {
		Telas.telaCadastroDisciplina();
	}
	
	public void voltar() {
		Telas.telaDashboard();
	}
	
	public void eliminardisciplina() {
		
	}
	
	public void editardisciplina() {
		
	}
}
