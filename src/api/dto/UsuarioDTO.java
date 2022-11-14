package api.dto;

public class UsuarioDTO {
	private String email;
    private String nome;
    private String login;
    private String senha;

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
}
