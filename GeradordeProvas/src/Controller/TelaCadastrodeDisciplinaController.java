package Controller;

import View.Telas;
import dto.DisciplinaDTO;
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
	@FXML private TextField assuntos;
	@FXML private TextField nome;
	@FXML private TextField codigo;
			private DisciplinaBO bo = new DisciplinaBO();
	
			/*
	public void CadastrarDisciplina(ActionEvent event) {
		try { 
			Disciplina disciplina = new Disciplina();
			if (NomeTexto.getText().length() < 1) {
				throw new Exception(); 
				} 
			disciplina.setAssuntos(AssuntosTexto.getText());
			disciplina.setNome(NomeTexto.getText());
			try { 
				bo.adicionar(disciplina); 
				} 
			catch (Exception e) {
				throw new Exception(); 
				} 
				try { 
					Telas.TeladeDisciplina(); 
					} 
				catch (Exception e) { 
					// TODO Auto-generated catch block 
					e.printStackTrace(); 
					 } 
				} 
		catch (Exception e) {
		
		}
	}*/
			
	public void CadastrarDisciplina(ActionEvent event) {
		DisciplinaDTO dto = new DisciplinaDTO();
		dto.setCodigo(codigo.getText());
		dto.setNome(nome.getText());
		dto.setAssuntos(assuntos.getText());
		bo.adicionar(dto);
		Telas.TeladeDisciplina();
	}
	
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
	public void voltar() {
		Telas.TeladeDisciplina();
	}
}
