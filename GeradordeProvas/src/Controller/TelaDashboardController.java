package Controller;

import java.awt.Label;

import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TelaDashboardController {
	
	public void inicio() {
		Telas.TelaDashboard();
	}
	
	public void questoes() {
		Telas.TeladeQuestoes();
	}
	
	public void disciplinas() {
		Telas.TeladeDisciplina();
	}
	
	public void provas() {
		Telas.TeladeProvas();
	}
	
	@FXML
    public void sair(ActionEvent event) {
		Telas.TeladeLogin();
    }
}
