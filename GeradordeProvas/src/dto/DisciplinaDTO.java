package dto;

public class DisciplinaDTO {
		private int id;
	    private String codigo;
	    private String nome;
	    private String assuntos;
	    
		public String getCodigo() {
			return codigo;
		}
		
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getAssuntos() {
			return assuntos;
		}
		
		public void setAssuntos(String assuntos) {
			this.assuntos = assuntos;
		}
		
		public String toString() {
			return nome;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	    
}