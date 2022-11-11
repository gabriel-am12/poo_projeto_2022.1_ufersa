package model.entity; 

public class Usuario {
    private int id_usuario;
    private String email;
    private String nome;
    private String login;
    private String senha;

    //GARANTINDO A INTEGRIDADE DOS DADOS COM OS METODOS GETS E SETS
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
    	if(id_usuario < 0){
		Math.abs(id_usuario);
		this.id_usuario = id_usuario;
		}else{
		this.id_usuario = id_usuario;
		}
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
    	if (email != null && !email.isEmpty())
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
    	if(nome != null && !nome.isEmpty())
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
    	if(login != null && !login.isEmpty())
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
    	if(senha != null && !senha.isEmpty())
        this.senha = senha;
    }

    //CRIAÇÃO DE ALGUNS CONSTRUTORES
    
	public Usuario(int id_usuario, String email, String nome, String login, String senha) {
		setId_usuario(id_usuario);
		setEmail(email);
		setNome(nome);
		setLogin(login);
		setSenha(senha);
	}
    
    public Usuario() {
    	
    }

    public Usuario(String login, String senha) {
    	setLogin(login);
    	setSenha(senha);
    }
    
//METODO TOSTRING PARA PRINTAR TODAS AS INFORMAÇÕES NA TELA NA HOJE DOS TESTES
    
    public String toString() {
    	String frase="";
    	frase = "\nId = " + this.id_usuario;
    	frase = frase + "\nNome = " + this.nome;
    	frase = frase + "\nLogin = " + this.login;
    	frase = frase + "\nSenha = " + this.senha;
    	frase = frase + "\nEmail = " + this.email;
    	return frase;
    }
    
}