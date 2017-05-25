package arvoreBinaria;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class ArvoreBinaria {

	private No raiz;

	public boolean estaVazia() {
		if (raiz == null)
			return true;
		return false;
	}

	public void inserir(int valor) {
		inserir(this.raiz, valor);
	}

	private void inserir(No node, int valor) {
		if (this.raiz == null) {
			this.raiz = new No(valor);
		} else {
			if (valor < node.getValor()) {
				if (node.getEsquerdo() != null) {
					inserir(node.getEsquerdo(), valor);
				} else {
					node.setEsquerdo(new No(valor));
				}
			} else if (valor > node.getValor()) {
				if (node.getDireito() != null) {
					inserir(node.getDireito(), valor);
				} else {
					node.setDireito(new No(valor));
				}
			}
		}
	}

	public No remover(int valor) throws Exception {
		return remover(this.raiz, valor);
	}

	private No remover(No node, int valor) throws Exception {
		if (this.raiz == null) {
			throw new Exception("Árvore vazia");
		} else {
			if (valor < node.getValor()) {
				node.setEsquerdo(remover(node.getEsquerdo(), valor));
			} else if (valor > node.getValor()) {
				node.setDireito(remover(node.getDireito(), valor));
			} else if (node.getEsquerdo() != null && node.getDireito() != null) {
				/* 2 filhos */
				System.out.println("  Removeu No " + node.getValor());
				node.setValor(encontraMinimo(node.getDireito()).getValor());
				node.setDireito(removeMinimo(node.getDireito()));
			} else {
				System.out.println("  Removeu No " + node.getValor());
				node = (node.getEsquerdo() != null) ? node.getEsquerdo() : node.getDireito();
			}
			return node;
		}
	}

	private No removeMinimo(No node) {
		if (node == null) {
			System.out.println("  ERRO ");
		} else if (node.getEsquerdo() != null) {
			node.setDireito(removeMinimo(node.getEsquerdo()));
			return node;
		} else {
			return node.getDireito();
		}
		return null;
	}

	private No encontraMinimo(No node) {
		if (node != null) {
			while (node.getEsquerdo() != null) {
				node = node.getEsquerdo();
			}
		}
		return node;
	}

	public void imprimirArvore() {
		if (this.raiz == null)
			System.out.println("Árvore vazia");
		else
			ordemSimetrica(this.raiz);
	}

	@SuppressWarnings("unused")
	private void preOrdem(No node) {
		System.out.println("Nó: " + node.getValor());
		if (node.getEsquerdo() != null)
			preOrdem(node.getEsquerdo());
		if (node.getDireito() != null)
			preOrdem(node.getDireito());
	}

	private void ordemSimetrica(No node) {
		if (node.getEsquerdo() != null)
			ordemSimetrica(node.getEsquerdo());
		System.out.println("Nó: " + node.getValor());
		if (node.getDireito() != null)
			ordemSimetrica(node.getDireito());
	}

	@SuppressWarnings("unused")
	private void posOrdem(No node) {
		if (node.getEsquerdo() != null)
			posOrdem(node.getEsquerdo());
		if (node.getDireito() != null)
			posOrdem(node.getDireito());
		System.out.println("Nó: " + node.getValor());
	}
	
}
