package Controller;

import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TelaProvaController {
	@FXML private Button BotãoDisciplina;
	@FXML private Button BotaoQuestoes;
	@FXML private Button BotaoInicio;
	@FXML private Button BotaoProvas;
	
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