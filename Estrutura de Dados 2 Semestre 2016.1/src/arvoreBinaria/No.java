package arvoreBinaria;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class No {
	
	private No esquerdo;	
	private No direito;
	private int valor;
	
	public No(int valor){
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}



	public No getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}

	public No getDireito() {
		return direito;
	}

	public void setDireito(No direito) {
		this.direito = direito;
	}	
	
}
