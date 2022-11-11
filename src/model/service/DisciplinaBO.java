package model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Disciplina;
import model.dao.DisciplinaDAO;
import model.dao.BaseInterDAO;

public class DisciplinaBO extends BaseBO<Disciplina> implements BaseInterBO<Disciplina>{
    private static BaseInterDAO<Disciplina> dao = new DisciplinaDAO<>();
    public boolean adicionar(Disciplina disciplina){
        ResultSet rs = dao.findBySpecifiedField(disciplina, "codigo");
        try{
            if(rs == null) || !(rs.next()) {
                if(dao.inserir(disciplina) == true)
                    return true;
                    else return false;
            }
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Disciplina> listar() {
        List<Disciplina> disciplinas = new ArrayList<Disciplina>();
        
        ResultSet rs - dao.findAll();
        try {
            while(rs.next()) {
                Disciplina.disciplina = new Disciplina();
                Disciplina.setCodigo(rs.getInt("codigo"));
                Disciplina.setNome(rs.getString("nome"));
                Disciplina.setAssunto(rs.getString("assunto"));

                Disciplina.add(disciplina);
            }
            return disciplinas;
        }
     catch (SQLException e) {
        e.printStackTrace();
        return null;
     }
    }
    public boolean alterar (Disciplina disciplina) {
        ResultSet rs = dao.findBySpecifiedField(disciplina, "codigo");
        
        try {
            if(rs != null && rs.next()) {
                if(dao.deletar(disciplina) == true)
                    return true;
                    else return false;
            }
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean apagar (Disciplina disciplina) {
        ResultSet rs = dao.findBySpecifiedField(disciplina, "codigo");
        try {
            if(rs !=null && rs.next()) {
                if(dao.deletar(disciplina) == true)
                    return true;
                    else return false;
            }
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}