package listasEncadeadas;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class ListaLigadaDupla {

	private Celula primeira;
	private Celula ultima;
	private int totalDeElementos;

	private boolean posicaoOcupada(int posicao){
		return posicao>=0 && posicao<this.totalDeElementos;
	}
	
	private Celula pegaCelula(int posicao){
		if (!this.posicaoOcupada(posicao))
			throw new IllegalArgumentException("Posi��o n�o existe");
		
		Celula atual = primeira;
		for (int i = 0; i < posicao; i++)
			atual = atual.getProxima();
		
		return atual;
	}
	
	public void adicionaNoComeco(Object elemento){
		if (this.totalDeElementos == 0){
			Celula nova = new Celula(elemento);
			this.primeira = nova;
			this.ultima = nova;
		} else {
			Celula nova = new Celula(this.primeira, elemento);
			this.primeira.setAnterior(nova);
			this.primeira = nova;
		}
		this.totalDeElementos++;
	}
	
	public void adiciona(Object elemento){
		if(this.totalDeElementos == 0){
			this.adicionaNoComeco(elemento);			
		} else{
			Celula nova = new Celula(elemento);
			this.ultima.setProxima(nova);
			nova.setAnterior(this.ultima);
			this.ultima = nova;
			this.totalDeElementos++;
		}
	}
	
	public void adiciona(int posicao, Object elemento){
		if (posicao==0){
			this.adicionaNoComeco(elemento);
		} else if (posicao == this.totalDeElementos){
			this.adiciona(elemento);			
		} else {
			Celula anterior = this.pegaCelula(posicao-1);
			Celula proxima = anterior.getProxima();
			Celula nova = new Celula(anterior.getProxima(), elemento);
			nova.setAnterior(anterior);
			anterior.setProxima(nova);
			proxima.setAnterior(nova);
			this.totalDeElementos++;
		}
	}
	

}
