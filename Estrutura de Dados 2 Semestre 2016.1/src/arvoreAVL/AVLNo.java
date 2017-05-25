package arvoreAVL;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class AVLNo {

	protected int chave, FB;
	protected AVLNo esq, dir;
	
	public AVLNo(int dado, int fatorDeBalanco, AVLNo noEsq, AVLNo noDir){
		this.chave =dado;
		this.FB = fatorDeBalanco;
		this.esq = noEsq;
		this.dir = noDir;
	}

	public AVLNo(int dado) {
		this.chave = dado;
		this.FB = 0;
		this.esq = this.dir = null;
	}
	
}
