package Controller;

import Dto.DisciplinaDTO;
import model.service.DisciplinaBO;
import View.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CadastroDisciplinaController {
	
	@FXML private TextField nome;
	@FXML private TextField codigo;
	@FXML private TextField assuntos;
		  
	private DisciplinaBO bo = new DisciplinaBO();
	
	public void cadastrar() {
		DisciplinaDTO dto = new DisciplinaDTO();
		dto.setCodigo(codigo.getText());
		dto.setNome(nome.getText());
		dto.setAssuntos(assuntos.getText());
		bo.adicionar(dto);
		Telas.listarDisciplinas();
	}

}
