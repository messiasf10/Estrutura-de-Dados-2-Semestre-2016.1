package arvoreSplay;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class ArvoreBinaria {

	protected NoBinaria raiz;
	
	public ArvoreBinaria() {
		raiz = null;
	}

	public NoBinaria getRaiz() {
		return raiz;
	}

	public void setRaiz(NoBinaria raiz) {
		this.raiz = raiz;
	}

	public boolean buscar(Integer valor) {
		Auxiliar.zerarVariaveis();
		return Auxiliar.buscarChaveComAncestrais(raiz, valor);
	}

	public boolean inserir(Integer valor) {
		boolean retornoDaBusca = false;
		Auxiliar.noPai = null;
		if (raiz != null)
			retornoDaBusca = Auxiliar.buscarChaveComPai(raiz, valor);
		if (retornoDaBusca)
			return false;
		NoBinaria novoNo = new NoBinaria(valor, null, null);
		if (raiz == null) {
			raiz = novoNo;
			return true;
		}
		if (Auxiliar.noPai.getChave().compareTo(valor) > 0)
			Auxiliar.noPai.setNoEsquerdo(novoNo);
		else
			Auxiliar.noPai.setNoDireito(novoNo);
		return true;
	}

	public void deletar() {
		deletar(raiz.chave);
	}

	public boolean deletar(Integer valor) {
		boolean retornoDaBusca = false;
		Auxiliar.noPai = null;
		if (raiz != null)
			retornoDaBusca = Auxiliar.buscarChaveComPai(raiz, valor); //retorna true se encontrar
		if (!retornoDaBusca) //caso nao encontre nao pode remover
			return false;
		NoBinaria noAuxAnterior;
		NoBinaria noAux;
		if (Auxiliar.noPai == null) { //se pai for igual a null eh pq o elemento eh a raiz da arvore
			if (raiz.getNoEsquerdo() == null && raiz.getNoDireito() == null) {
				raiz = null;
				return true;
			}
			if (raiz.getNoEsquerdo() == null) { //se tiver so filho direito entao a raiz vai ser o filho direito
				raiz = raiz.getNoDireito();
				return true;
			}
			if (raiz.getNoDireito() == null) { //se tiver so filho esquerdo entao a raiz vai ser o filho esquerdo
				raiz = raiz.getNoEsquerdo();
				return true;
			}
			
			//agora no laco 'for' vai encontrar o filho mais a esquerda da arvore direita, ou seja,
			//o meno valor do lado direito, que sera a nova raiz da arvore
			noAuxAnterior = raiz;
			for (noAux = raiz.getNoDireito(); noAux.getNoEsquerdo() != null; noAux = noAux.getNoEsquerdo())
				noAuxAnterior = noAux;

			
			if (noAuxAnterior == raiz) { //entra nesse if no caso em que o menor valor da subarvore direita eh o proprio filho direito da raiz
				noAux.setNoEsquerdo(noAuxAnterior.getNoEsquerdo()); //so atualiza o ponteiro do filho esquerdo desse no pra receber o filho esquerdo da raiz 
				raiz = noAux; //e agora esse no sera a raiz
			} else { //so vem para aqui caso encontre o filho mais a esquerda da subarvore da direita
				noAuxAnterior.setNoEsquerdo(noAux.getNoDireito());
				noAux.setNoEsquerdo(raiz.getNoEsquerdo());
				noAux.setNoDireito(raiz.getNoDireito());
				raiz = noAux;
			}
			return true;
		}
		NoBinaria noRemocao = Auxiliar.noAchado;
		NoBinaria pai = Auxiliar.noPai;
		boolean ladoEsquerdo = false;
		if (pai.getChave().compareTo(valor) > 0)
			ladoEsquerdo = true;
		if (noRemocao.getNoEsquerdo() == null && noRemocao.getNoDireito() == null) {
			if (ladoEsquerdo)
				pai.setNoEsquerdo(null);
			else
				pai.setNoDireito(null);
			return true;
		}
		if (noRemocao.getNoEsquerdo() == null) {
			if (ladoEsquerdo)
				pai.setNoEsquerdo(noRemocao.getNoDireito());
			else
				pai.setNoDireito(noRemocao.getNoDireito());
			return true;
		}
		if (noRemocao.getNoDireito() == null) {
			if (ladoEsquerdo)
				pai.setNoEsquerdo(noRemocao.getNoEsquerdo());
			else
				pai.setNoDireito(noRemocao.getNoEsquerdo());
			return true;
		}
		noAuxAnterior = noRemocao;
		for (noAux = noRemocao.getNoDireito(); noAux.getNoEsquerdo() != null; noAux = noAux.getNoEsquerdo())
			noAuxAnterior = noAux;

		if (noAuxAnterior == noRemocao) {
			noAux.setNoEsquerdo(noRemocao.getNoEsquerdo());
		} else {
			noAuxAnterior.setNoEsquerdo(noAux.getNoDireito());
			noAux.setNoEsquerdo(noRemocao.getNoEsquerdo());
			noAux.setNoDireito(noRemocao.getNoDireito());
		}
		if (ladoEsquerdo)
			pai.setNoEsquerdo(noAux);
		else
			pai.setNoDireito(noAux);
		return retornoDaBusca;
	}
	
}
