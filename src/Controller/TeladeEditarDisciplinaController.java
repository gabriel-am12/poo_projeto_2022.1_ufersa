package Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import View.Telas;
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
	@FXML private TableView<Disciplina> TabelaDisciplinas;
	@FXML private TableColumn<Disciplina, String> ColunaDisciplinasID;
	@FXML private TableColumn<Disciplina, String> ColunaDisciplinasNome;
	@FXML private TableColumn<Disciplina, String> ColunaDisciplinasAssunto;
	private DisciplinaBO bo = new DisciplinaBO();
    private ObservableList<Disciplina> listaDeDisciplinas;
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listarDisciplinas();
	}
	public void listarDisciplinas() {
		List<Disciplina> disciplinas = bo.listar();
		listaDeDisciplinas = FXCollections.observableArrayList(disciplinas);
		ColunaDisciplinasID.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		ColunaDisciplinasNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		ColunaDisciplinasAssunto.setCellValueFactory(new PropertyValueFactory<>("assunto"));
		TabelaDisciplinas.setItems(listaDeDisciplinas);
	}
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
		disciplina.setAssunto(EditarAssuntosTexto.getText()); 
		disciplina.setNome(EditarNomeTexto.getText()); 
		bo.alterar(disciplina);  
		listaDeDisciplinas.set(disciplina.getCodigo(), disciplina); 
			} 
		}  
		catch (Exception e) {
			
			} 
		}
	
	
	public void Voltar(ActionEvent event){
		Telas.telaDisciplinas();
	}
	public void Disciplinas(ActionEvent event){
		Telas.telaDisciplinas();
	}
	public void Questoes(ActionEvent event){
		Telas.telaQuestoes();
	}
	public void Inicio(ActionEvent event){
		Telas.telaCadastro();
	}
	public void Provas(ActionEvent event){
		Telas.telaProva();
	}
}
