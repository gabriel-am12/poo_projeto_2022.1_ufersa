package Controller;

import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.entity.Disciplina;
import model.service.BaseInterBO;
import model.service.DisciplinaBO;

public class TelaCadastrodeDisciplinaController {
	@FXML private Button BotãoDisciplina;
	@FXML private Button BotaoQuestoes;
	@FXML private Button BotaoInicio;
	@FXML private Button BotaoProvas;
	@FXML private Button Voltar;
	@FXML private Button CadastrarDisciplina;
	@FXML private TextField AssuntosTexto;
	@FXML private TextField NomeTexto;
	BaseInterBO<Disciplina> bo = new DisciplinaBO();
	
	public void CadastrarDisciplina(ActionEvent event) {
		try { 
			Disciplina disciplina = new Disciplina();
			if (NomeTexto.getText().length() < 1) {
				throw new Exception(); 
				} 
			disciplina.setAssunto(AssuntosTexto.getText());
			disciplina.setNome(NomeTexto.getText());
			try { 
				bo.adicionar(disciplina); 
				} 
			catch (Exception e) {
				throw new Exception(); 
				} 
				try { 
					Telas.telaDisciplinas(); 
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
