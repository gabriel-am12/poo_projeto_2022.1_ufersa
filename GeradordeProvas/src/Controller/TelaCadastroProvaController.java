package api.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import View.Telas;
import api.dto.ProvaDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.entity.Disciplina;
import model.service.ProvaBO;

public class TelaCadastroProvaController {
	@FXML private Button BotãoDisciplina;
	@FXML private Button BotaoQuestoes;
	@FXML private Button BotaoInicio;
	@FXML private Button BotaoProvas;
	@FXML private Button Voltar;
	@FXML private Button CadastrarProva;
	@FXML private ChoiceBox<String> NivelUm;
	@FXML private ChoiceBox<String> NivelDois;
	@FXML private ChoiceBox<String> NivelTres;
	@FXML private TextField DisciplinaTexto;
	private ProvaBO bo = new ProvaBO();
	private String[] opcoes = {"1", "2 ","3"};
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		NivelUm.getItems().addAll(opcoes);
		NivelDois.getItems().addAll(opcoes);
		NivelTres.getItems().addAll(opcoes);
	}
	
	public void CadastrarDisciplina(ActionEvent event) {
		try { 
			ProvaDTO prova = new ProvaDTO();
			if (DisciplinaTexto.getText().length() < 1) {
				throw new Exception(); 
				} 
			prova.setDisciplina(DisciplinaTexto.getText()); 
			int quantNivelUm = Integer.parseInt(NivelUm.getValue());
			int quantNivelDois = Integer.parseInt(NivelDois.getValue());
			int quantNivelTres = Integer.parseInt(NivelTres.getValue());
			for (int a = 0; a < quantNivelUm; a++) {
				prova.setNivelUm(prova.getNivelUm());
			}
			for (int a = 0; a < quantNivelDois; a++) {
				prova.setNivelDois(prova.getNivelDois());
			}
			for (int a = 0; a < quantNivelTres; a++) {
				prova.setNivelTres(prova.getNivelTres());
			}
			if (quantNivelUm + quantNivelDois + quantNivelTres == 0) {
				throw new Exception();
			}
			try { 
				bo.adicionar(prova); 
				} 
			catch (Exception e) {
				throw new Exception(); 
				} 
				try { 
					Telas.telaProva(); 
					} 
				catch (Exception e) { 
					// TODO Auto-generated catch block 
					e.printStackTrace(); 
					 } 
				} 
		catch (Exception e) {
		
		}
	}
	public void Voltar(ActionEvent event){
		Telas.telaProva();
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
