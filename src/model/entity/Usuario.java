package model.entity;

import api.dto.UsuarioDTO;

public class Usuario {
    private int id_usuario;
    private String email;
    private String nome;
    private String login;
    private String senha;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmai1(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public static Usuario converter(UsuarioDTO usudto) {
    	Usuario usuario = new Usuario();
    	usuario.setNome(usudto.getNome());
    	usuario.setEmai1(usudto.getEmail());
	  	usuario.setLogin(usudto.getLogin());
	  	usuario.setSenha(usudto.getSenha());
    	return usuario;
    }
}