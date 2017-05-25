package listasVetor;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class Aluno {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toSrting(){
		return this.nome;		
	}
	
	public boolean equals(Object o){
		Aluno outro = (Aluno) o;
		return this.nome.equals(outro);
	}

}
