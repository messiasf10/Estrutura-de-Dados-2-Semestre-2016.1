package arvoreAVLDefinitiva;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class AVLNode {

	public int valor;
	public int altura;
	public AVLNode esquerdo;
	public AVLNode direito;	

	public AVLNode() {
	}

	public AVLNode(int valor) {
		this(valor, null, null);
	}

	public AVLNode(int valor, AVLNode esquerdo, AVLNode direito) {
		this.valor = valor;
		this.esquerdo = esquerdo;
		this.direito = direito;
		this.altura = 0;		
	}

	public String toString() {
		return " "+this.valor+" ";
	}

}
