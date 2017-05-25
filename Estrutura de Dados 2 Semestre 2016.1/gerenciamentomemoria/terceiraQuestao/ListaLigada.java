package terceiraQuestao;

import listaSimples.Celula;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class ListaLigada {

	private Celula primeira;
	private Celula ultima;
	private int totalDeElementos;

	public void adiciona(Object elemento) {
		if (this.totalDeElementos == 0)
			this.adicionaNoComeco(elemento);
		else {
			Celula nova = new Celula(elemento);
			this.ultima.setProxima(nova);
			this.ultima = nova;
			this.totalDeElementos++;
		}
		
	}
	
	public void adicionaNoComeco(Object elemento) {
		Celula nova = new Celula(this.primeira, elemento);
		this.primeira = nova;
		
		if (this.totalDeElementos == 0)
			this.ultima = this.primeira;
		
		totalDeElementos++;
	}

	public Object pega(int posicao) {
		return this.pegaCelula(posicao).getElemento();
	}

	public int tamanho() {
		return this.totalDeElementos;
	}

	public boolean contem(Object elemento) {
		Celula atual = this.primeira;
		while (atual != null) {
			if (atual.getElemento().equals(elemento))
				return true;
			atual = atual.getProxima();
		}
		return false;
	}

	public String toString(){
		if(this.totalDeElementos == 0)
			return "[]";
		
		StringBuilder builder = new StringBuilder("[");
		Celula atual = primeira;
		
		//while (atual != null) {..}
		for (int i = 0; i < this.totalDeElementos - 1; i++){
			builder.append(atual.getElemento());
			builder.append(", ");
			atual = atual.getProxima();
		}
		
		builder.append(atual.getElemento());
		builder.append("]");
		
		return builder.toString();
	}
	
	private boolean posicaoOcupada(int posicao){
		return posicao>=0 && posicao<this.totalDeElementos;
	}
	
	private Celula pegaCelula(int posicao){
		if (!this.posicaoOcupada(posicao))
			throw new IllegalArgumentException("Posição não existe");
		
		Celula atual = primeira;
		for (int i = 0; i < posicao; i++)
			atual = atual.getProxima();
		
		return atual;
	}

}
