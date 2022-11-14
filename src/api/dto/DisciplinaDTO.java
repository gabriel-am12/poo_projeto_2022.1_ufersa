package api.dto;

public class DisciplinaDTO {
			private int Id;
		    public int getId() {
				return Id;
			}

			public void setId(int id) {
				Id = id;
			}

			private String nome;
		    private String assuntos;
		    
			public String getNome() {
				return nome;
			}
			
			public void setNome(String nome) {
				this.nome = nome;
			}
			
			public String getAssuntos() {
				return assuntos;
			}
			
			public void setAssunto(String assuntos) {
				this.assuntos = assuntos;
			}
}
