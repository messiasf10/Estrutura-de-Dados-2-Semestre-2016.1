package arvoreAVL;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class Celula {
	
	protected int chave;
	protected Celula prox;
	
	public Celula(int dado, Celula proxima){
		this.chave = dado;
		this.prox = proxima;
	}
	
	public Celula(Celula copia){
		this.chave = copia.chave;
		this.prox = copia.prox;
	}

	public Celula(int dado){
		this.chave = dado;
		this.prox = null;
	}
	
}
