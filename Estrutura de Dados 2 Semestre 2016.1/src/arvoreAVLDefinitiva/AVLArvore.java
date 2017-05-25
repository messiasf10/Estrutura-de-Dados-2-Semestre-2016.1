package arvoreAVLDefinitiva;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class AVLArvore {

	public AVLNode raiz;
	private boolean aplicandoRotacaoDuplaEsquerda = false, aplicandoRotacaoDuplaDireita = false;

	public AVLArvore() {
		this.raiz = null;
	}

	public void inserir(int valor) {
		this.raiz = inserir(this.raiz, valor);
	}

	public AVLNode deletar(int valor) {
		raiz = deletar(raiz, valor);
		return raiz;
	}

	public void deletarRaiz() {
		raiz = deletar(raiz.valor);
	}

	private AVLNode inserir(AVLNode no, int x) {
		if (no == null)
			return new AVLNode(x);
		if (x < no.valor) {
			no.esquerdo = inserir(no.esquerdo, x);
			if (verificarAltura(no.esquerdo) - verificarAltura(no.direito) == 2)
				if (x < no.esquerdo.valor)
					no = rotacaoSimplesDireita(no);
				else
					no = rotacaoDuplaDireita(no);
		} else if (x > no.valor) {
			no.direito = inserir(no.direito, x);
			if (verificarAltura(no.direito) - verificarAltura(no.esquerdo) == 2)
				if (x > no.direito.valor)
					no = rotacaoSimplesEsquerda(no);
				else
					no = rotacaoDuplaEsquerda(no);
		}
		no.altura = Math.max(verificarAltura(no.esquerdo), verificarAltura(no.direito)) + 1;
		return no;
	}

	private AVLNode deletar(AVLNode p, int x) {
		AVLNode child = null;
		if (p == null)
			return null;
		if (x < p.valor) {
			p.esquerdo = deletar(p.esquerdo, x);
			if (Math.abs(verificarAltura(p.esquerdo) - verificarAltura(p.direito)) == 2)
				if (verificarAltura(p.direito.esquerdo) <= verificarAltura(p.direito.direito))
					p = rotacaoSimplesEsquerda(p);
				else
					p = rotacaoDuplaEsquerda(p);
		} else if (x > p.valor) {
			p.direito = deletar(p.direito, x);
			if (Math.abs(verificarAltura(p.esquerdo) - verificarAltura(p.direito)) == 2)
				if (verificarAltura(p.esquerdo.direito) <= verificarAltura(p.esquerdo.esquerdo))
					p = rotacaoSimplesDireita(p);
				else
					p = rotacaoDuplaDireita(p);
		} else if (p.esquerdo != null && p.direito != null) {
			p.valor = acharMinimo(p.direito).valor;
			p.direito = deletar(p.direito, p.valor);
			if (Math.abs(verificarAltura(p.esquerdo) - verificarAltura(p.direito)) == 2)
				if (verificarAltura(p.esquerdo.direito) <= verificarAltura(p.esquerdo.esquerdo))
					p = rotacaoSimplesDireita(p);
				else
					p = rotacaoDuplaDireita(p);
		} else {
			if (p.esquerdo == null)
				child = p.direito;
			if (p.direito == null)
				child = p.esquerdo;
			return child;
		}
		return p;
	}

	// rotacaoFilhoEsquerdo
	private AVLNode rotacaoSimplesDireita(AVLNode k2) {
		//System.out.println("** ROTACAO SIMPLES A DIREITA - ENTRE OS NOS k2 = " + k2.valor + " E k1 = " + k2.esquerdo);

		if (!aplicandoRotacaoDuplaDireita && !aplicandoRotacaoDuplaEsquerda){
			System.out.println();
			this.printArvoreBinaria();
			System.out.println();
			
			System.out.println("( APLICAR ROTACAO SIMPLES A DIREITA ENTRE OS NOS k2 = " + k2.valor + " E k1 = " + k2.esquerdo+" )");
			
			System.out.println("\n\t|  |\n\t|  |\n\t\\  /\n\t \\/");
		}
		
		if (aplicandoRotacaoDuplaDireita)
			aplicandoRotacaoDuplaDireita = false;

		AVLNode k1 = k2.esquerdo;
		k2.esquerdo = k1.direito;
		k1.direito = k2;
		k2.altura = Math.max(verificarAltura(k2.esquerdo), verificarAltura(k2.direito)) + 1;
		k1.altura = Math.max(verificarAltura(k1.esquerdo), k2.altura) + 1;
		return k1;
	}

	// rotacaoFilhoDireito
	private AVLNode rotacaoSimplesEsquerda(AVLNode k1) {
		
		if (!aplicandoRotacaoDuplaDireita && !aplicandoRotacaoDuplaEsquerda){
			System.out.println();
			this.printArvoreBinaria();
			System.out.println();
				
			System.out.println("( APLICAR ROTACAO SIMPLES A ESQUERDA ENTRE OS NOS k1 = " + k1.valor + " E k2 = " + k1.direito+" )");
				
			System.out.println("\n\t|  |\n\t|  |\n\t\\  /\n\t \\/"); //desenhando a seta
		}
		
		if (aplicandoRotacaoDuplaEsquerda)
			aplicandoRotacaoDuplaEsquerda = false;

		AVLNode k2 = k1.direito;
		k1.direito = k2.esquerdo;
		k2.esquerdo = k1;
		k1.altura = Math.max(verificarAltura(k1.esquerdo), verificarAltura(k1.direito)) + 1;
		k2.altura = Math.max(verificarAltura(k2.direito), k1.altura) + 1;
		return k2;
	}

	// rotacaoDuplaFilhoEsquerdo
	private AVLNode rotacaoDuplaDireita(AVLNode k3) {

		aplicandoRotacaoDuplaDireita = true;
		
		System.out.println();
		this.printArvoreBinaria();
		System.out.println();
		
		System.out.println();
		System.out.println("( APLICAR ROTACAO DUPLA A DIREITA ENTRE OS NOS k3 = " + k3.valor + "" + " k1 = "
				+ k3.esquerdo.valor + " k2 = " + k3.esquerdo.direito.valor + " )");
		
		System.out.println("\n\t|  |\n\t|  |\n\t\\  /\n\t \\/"); //desenhando a seta

		k3.esquerdo = rotacaoSimplesEsquerda(k3.esquerdo);
		return rotacaoSimplesDireita(k3);
	}

	// rotacaoDuplaFilhoDireito
	private AVLNode rotacaoDuplaEsquerda(AVLNode k1) {
		
		aplicandoRotacaoDuplaEsquerda = true;
		
		System.out.println();
		this.printArvoreBinaria();
		System.out.println();
		
		System.out.println();
		System.out.println("( APLICAR ROTACAO DUPLA A ESQUERDA ENTRE OS NOS k1 = " + k1.valor + "" + " k3 = "
				+ k1.direito.valor + " k2 = " + k1.direito.esquerdo.valor + " )");
		
		System.out.println("\n\t|  |\n\t|  |\n\t\\  /\n\t \\/"); //desenhando a seta

		k1.direito = rotacaoSimplesDireita(k1.direito);
		return rotacaoSimplesEsquerda(k1);
	}

	public int verificarAltura(AVLNode t) {
		return t != null ? t.altura : -1;
	}

	public int getAlturaArvore() {
		return verificarAltura(raiz);
	}

	public void percursoPosOrdem(AVLNode no) {
		if (no != null) {
			percursoPosOrdem(no.esquerdo);
			percursoPosOrdem(no.direito);
			System.out.print((new StringBuilder(String.valueOf(no.valor))).append(" ").toString());
		}
	}

	public void mostraArvore() {
		if (vazia())
			System.out.println("arvore vazia");
		else
			percursoPosOrdem(raiz);
	}

	public boolean vazia() {
		return raiz == null;
	}

	public int acharMinimo() {
		if (vazia())
			System.out.println("UnderflowException");
		return acharMinimo(raiz).valor;
	}

	private AVLNode acharMinimo(AVLNode t) {
		if (t == null)
			return t;
		for (; t.esquerdo != null; t = t.esquerdo)
			;
		return t;
	}

	public int acharMaximo() {
		if (vazia())
			System.out.println("UnderflowException");
		return acharMaximo(raiz).valor;
	}

	private AVLNode acharMaximo(AVLNode t) {
		if (t == null)
			return t;
		for (; t.direito != null; t = t.direito)
			;
		return t;
	}
	
	public AVLNode buscar(int dado){
		return this.buscar(raiz,dado);
	}

	private AVLNode buscar(AVLNode no, int dado) {
		while (no != null && dado != no.valor){
			if (dado < no.valor)
				no = no.esquerdo;
			else if (dado > no.valor)
				no = no.direito;			
		}
		return no;
	}
	
	public boolean find(int x) {
		return find(x, raiz);
	}

	private boolean find(int x, AVLNode t) {
		while (t != null)
			if (x < t.valor)
				t = t.esquerdo;
			else if (x > t.valor)
				t = t.direito;
			else
				return true;
		return false;
	}

	public void printArvoreBinaria() {
		this.printBinaryTree(this.raiz, this.verificarAltura(raiz));
	}

	private void printBinaryTree(AVLNode root, int level) {
		if (root == null)
			return;
		printBinaryTree(root.direito, level + 1);
		if (level != 0) {
			for (int i = 0; i < level - 1; i++)
				System.out.print("|\t");
			System.out.println("|-------" + root.valor);
		} else
			System.out.println("   "+root.valor);
		printBinaryTree(root.esquerdo, level + 1);
	}

	public int valorDaRaiz(){
		return this.raiz.valor;
	}
	
}
