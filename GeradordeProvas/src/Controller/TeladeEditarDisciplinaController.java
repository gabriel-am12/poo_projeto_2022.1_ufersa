package Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import View.Telas;
import dto.DisciplinaDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entity.Disciplina;
import model.service.DisciplinaBO;

public class TeladeEditarDisciplinaController {
	@FXML private Button BotãoDisciplina;
	@FXML private Button BotaoQuestoes;
	@FXML private Button BotaoInicio;
	@FXML private Button BotaoProvas;
	@FXML private Button Voltar;
	@FXML private Button EditarDisciplina;
	@FXML private TextField EditarAssuntosTexto;
	@FXML private TextField EditarNomeTexto;
	@FXML private TableView<DisciplinaDTO> tabelaDisciplina;
	@FXML private TableColumn<DisciplinaDTO, String> columnCodigo;
	@FXML private TableColumn<DisciplinaDTO, String> columnNome;
	@FXML private TableColumn<DisciplinaDTO, String> columnAssunto;
	private DisciplinaBO bo = new DisciplinaBO();
    private ObservableList<DisciplinaDTO> listaDeDisciplinas;
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listarDisciplinas();
	}
	public void listarDisciplinas() {
		List<DisciplinaDTO> disciplinas = bo.listar();
		listaDeDisciplinas = FXCollections.observableArrayList(disciplinas);
		columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnAssunto.setCellValueFactory(new PropertyValueFactory<>("assuntos"));
		tabelaDisciplina.setItems(listaDeDisciplinas);
	}
	

	/*
	public void EditarDisciplina(ActionEvent event){
		Disciplina disciplina = TabelaDisciplinas.getSelectionModel().getSelectedItem(); 
		try { 
			if (disciplina == null) {
				throw new Exception(); 
				} 
			else { 
				if (EditarNomeTexto.getText().length() < 1 || EditarAssuntosTexto.getText().length() < 1) {
					throw new Exception(); 
					} 
		disciplina.setAssuntos(EditarAssuntosTexto.getText()); 
		disciplina.setNome(EditarNomeTexto.getText()); 
		bo.alterar(disciplina);  
		listaDeDisciplinas.set(disciplina.getCodigo(), disciplina); 
			} 
		}  
		catch (Exception e) {
			
			} 
		}
	
	*/
	public void Voltar(ActionEvent event){
		Telas.TeladeDisciplina();
	}
	public void Disciplinas(ActionEvent event){
		Telas.TeladeDisciplina();
	}
	public void Questoes(ActionEvent event){
		Telas.TeladeQuestoes();
	}
	public void Inicio(ActionEvent event){
		Telas.TelaDashboard();
	}
	public void Provas(ActionEvent event){
		Telas.TeladeProvas();
	}
}
