package hashingAbertaLista;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class ListaLigada {

	private Celula primeira;
	private Celula ultima;
	private int totalDeElementos;

	public void adicionaNoComeco(Object elemento) {
		Celula nova = new Celula(this.primeira, elemento);
		this.primeira = nova;
		
		if (this.totalDeElementos == 0)
			this.ultima = this.primeira;
		
		totalDeElementos++;
	}

	public void adicionaNoFim(Object elemento) {
		if (this.totalDeElementos == 0)
			this.adicionaNoComeco(elemento);
		else {
			Celula nova = new Celula(elemento);
			this.ultima.setProxima(nova);
			this.ultima = nova;
			this.totalDeElementos++;
		}
		
	}

	public void remove(Object elemento) {
		if (this.tamanho() != 0){
			Celula anterior = null;
			Celula aux = this.primeira;
			while (aux != null && !aux.getElemento().equals(elemento)){
				anterior = aux;
				aux = aux.getProxima();
			}
			if (aux != null){
				if (aux.equals(this.ultima))
					this.ultima = anterior;
				if (aux.equals(this.primeira))
					this.primeira = this.primeira.getProxima();
				else
					anterior.setProxima(aux.getProxima());
				totalDeElementos--;
			}
		}
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

	public int tamanho() {
		return this.totalDeElementos;
	}

	public String toString(){
		if(this.totalDeElementos == 0)
			return "[]";
		
		StringBuilder builder = new StringBuilder("[");
		Celula atual = primeira;
		
		for (int i = 0; i < this.totalDeElementos - 1; i++){
			builder.append(atual.getElemento());
			builder.append(" -> ");
			//builder.append(", ");
			atual = atual.getProxima();
		}
		
		builder.append(atual.getElemento());
		builder.append("]");
		
		return builder.toString();
	}

}
