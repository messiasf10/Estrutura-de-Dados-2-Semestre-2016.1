package arvoreAVL;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class AVL {
	
	public static final int POR_FUSAO = 1;
	public static final int POR_COPIA = 2;

	public static final int EXTENCAO = 1;
	public static final int PROFUNDIDADE = 2;

	public static final int PREORDEM = 1;
	public static final int EMORDEM = 2;
	public static final int POSORDEM = 3;
	
	private AVLNo raiz;

	public boolean vazia(){
		return this.raiz == null;
	}
	
	public int altura(){
		return this.altura(raiz);
	}
	
	public AVLNo buscar(int dado){
		return this.buscar(raiz,dado);
	}
	
	public void calculaFB(){
		this.calculaFB(raiz);
	}
	
	public void balancear(){
		this.calculaFB();
		this.balancear(raiz,null);
	}
	
	public void inserir(int dado){
		AVLNo noNovo = new AVLNo(dado);
		
		if(this.vazia())
			this.raiz = noNovo;
		else {
			AVLNo no = raiz;
			
			while(dado != no.chave){
				if(dado < no.chave){
					if(no.esq == null)
						no.esq = noNovo;
					no = no.esq;
				} else if(dado > no.chave){
					if (no.dir == null)
						no.dir = noNovo;
					no = no.dir;
				} 
			}
			this.balancear();
		}		
	}
	
	public void remover(int tipo, int dado) {
	    if(tipo != 0) {
	        AVLNo filho = buscar(dado),
	              pai = buscarPai(filho);

	        if(filho != null && dado == filho.chave) {
	            if(tipo == POR_FUSAO)
	                remover_porFusao(filho,pai);
	            else if(tipo == POR_COPIA)
	                remover_porCopia(filho,pai);
	        } else if(!vazia()) {
	            System.out.println("A CHAVE [" + dado + "] NAO ESTA NA ARVORE");	            
	        } else 
	            System.out.println("A ARVORE ESTA VAZIA");
	        this.balancear();
	    } else
	        remover(raiz);
	}
	
	public void percorrer(int tipo, int ordem){
		System.out.print("[ ");
		if(tipo == EXTENCAO)
	        largura();
	    else if(tipo == PROFUNDIDADE)
	        profundidade(ordem);
		System.out.print(" ]");
	}
	
	public void largura() {
		Fila aux = new Fila();
		AVLNo no = raiz;
		
		if (no != null){
			aux.inserir(no.chave);
			
			while (!aux.vazia()){
				no = buscar(aux.getTopo());
				aux.remover();
				
				imprimirNo(no);
				if(no.esq != null)
					aux.inserir(no.esq.chave);
				if(no.dir != null)
					aux.inserir(no.dir.chave);
			}
		}
	}
	
	public void profundidade(int ordem) {
		if(ordem == PREORDEM) preOrdem();
	    if(ordem == EMORDEM) emOrdem();
	    if(ordem == POSORDEM) posOrdem();		
	}
	
	public void preOrdem() {
		preOrdem(raiz);		
	}

	public void emOrdem() {
		emOrdem(raiz);
		
	}
	
	public void posOrdem() {
		posOrdem(raiz);		
	}
	
	public int chaveRaiz(){
		return this.raiz.chave;
	}
	
	private int altura(AVLNo no) {
		if (no == null){
			return -1;
		} else {
			int altEsq = 1 + altura(no.esq);
			int altDir = 1 + altura(no.dir);
			return (altEsq > altDir) ? altEsq : altDir;
		}		
	}

	private AVLNo buscar(AVLNo no, int dado) {
		while (no != null && dado != no.chave){
			if (dado < no.chave)
				no = no.esq;
			else if (dado > no.chave)
				no = no.dir;			
		}
		return no;
	}

	private AVLNo buscarPai(AVLNo filho) {
		if (filho != null){
			AVLNo no = raiz;
			
			while(no != null)
				if(filho.chave < no.chave){
					if(filho.chave == no.esq.chave)
						return no;
					no = no.esq;
				} else if (filho.chave > no.chave){
					if(filho.chave == no.dir.chave)
						return no;
					no = no.dir;
				} else
					return null;
		}
		return null;
	}

	private void calculaFB(AVLNo no) {
		if (no != null){
			no.FB = altura(no.esq) - altura(no.dir);
			calculaFB(no.esq);
			calculaFB(no.dir);
		}		
	}

	private void balancear(AVLNo pai, AVLNo avo){
		if (pai != null){
			if(pai.FB == -2){
				if(pai.dir.FB == -1){
					rotacaoSimplesEsq(pai,avo);
					balancear();
				} else if (pai.dir.FB == 1) {
					rotacaoDuplaEsq(pai.dir,pai,avo);
					balancear();
				}				
			} else if (pai.FB == 2){
				if (pai.esq.FB == 1){
					rotacaoSimplesDir(pai,avo);
					balancear();
				} else if (pai.esq.FB == -1){
					rotacaoDuplaDir(pai.esq,pai,avo);
					balancear();
				}				
			}
			balancear(pai.esq,pai);
			balancear(pai.dir,pai);
		}
	}

	private void rotacaoSimplesEsq(AVLNo pai, AVLNo avo) {
		AVLNo filho = pai.dir;
		
		pai.dir = filho.esq;
		filho.esq = pai;
		
		if(avo == null) raiz = filho;
		else if (avo.esq == pai) avo.esq = filho;
		else if (avo.dir == pai) avo.dir = filho;		
	}

	private void rotacaoSimplesDir(AVLNo pai, AVLNo avo) {
		AVLNo filho = pai.esq;
		
		pai.esq = filho.dir;
		filho.dir = pai;
		
		if (avo == null) raiz = filho;
		else if (avo.esq == pai) avo.esq = filho;
		else if (avo.dir == pai) avo.dir = filho;		
	}

	private void rotacaoDuplaEsq(AVLNo filho, AVLNo pai, AVLNo avo) {
		AVLNo filhoEsq = filho.esq;
	
	    filho.esq = filhoEsq.dir;
	    filhoEsq.dir = filho;
	
	    pai.dir = filhoEsq.esq;
	    filhoEsq.esq = pai;
	
	    if(avo == null) raiz = filhoEsq;
	    else if(avo.esq == pai) avo.esq = filhoEsq;
	    else if(avo.dir == pai) avo.dir = filhoEsq;		
	}

	private void rotacaoDuplaDir(AVLNo filho, AVLNo pai, AVLNo avo) {
		AVLNo filhoDir = filho.dir;
	
	    filho.dir = filhoDir.esq;
	    filhoDir.esq = filho;
	
	    pai.esq = filhoDir.dir;
	    filhoDir.dir = pai;
	
	    if(avo == null) raiz = filhoDir;
	    else if(avo.esq == pai) avo.esq = filhoDir;
	    else if(avo.dir == pai) avo.dir = filhoDir;
		
	}

	private void remover(AVLNo no) {
		if (no != null){
			remover(no.esq);
			remover(no.dir);
			if(no == this.raiz)
				this.raiz = null;
		}		
	}

	private void remover_porFusao(AVLNo filho, AVLNo pai) {
		AVLNo temp = filho;
		
		if(filho != null){
			if(filho.dir == null)
				filho = filho.esq;
			else if (filho.esq == null)
				filho = filho.dir;
			else {
				temp = filho.esq;
				
				while(temp.dir != null)
					temp = temp.dir;
				temp.dir = filho.dir;
				temp = filho;
				filho = filho.esq;
			}
			if (pai == null) raiz = filho;
			else if (pai.esq == temp) pai.esq = filho;
			else if (pai.dir == temp) pai.dir = filho;
		}		
	}

	private void remover_porCopia(AVLNo filho, AVLNo pai) {
		AVLNo ante, temp = filho;
		
		if(filho.dir == null)
			filho = filho.esq;
		else if (filho.esq == null)
			filho = filho.dir;
		else {
			ante = filho;
			temp = filho.esq;
			while(temp.dir != null) {
				ante = temp;
				temp = temp.dir;
			}
			filho.chave = temp.chave;
			if(ante == filho)
				ante.esq = temp.esq;
			else
				ante.dir = temp.esq;
		}
		if (pai == null) raiz = filho;
		else if (pai.esq == temp) pai.esq = filho;
		else if (pai.dir == temp) pai.dir = filho;
		
	}

	private void preOrdem(AVLNo no) {
		if(no != null) {
	        imprimirNo(no);
	        preOrdem(no.esq);
	        preOrdem(no.dir);
	    }		
	}

	private void emOrdem(AVLNo no) {
		if(no != null) {
	        preOrdem(no.esq);
	        imprimirNo(no);
	        preOrdem(no.dir);
	    }		
	}

	private void posOrdem(AVLNo no) {
		if(no != null) {
	        preOrdem(no.esq);
	        preOrdem(no.dir);
	        imprimirNo(no);
	    }		
	}

	private void imprimirNo(AVLNo no) {
		System.out.print(no.chave+" ");		
	}

	public void displayTree(){
		if (this.vazia()){
			System.out.println("Arvore vazia!");
			return;
		}
		String separator = String.valueOf("  |__");  
	    System.out.println(this.raiz.chave+"("+this.altura(raiz)+")");
	    displaySubTree(raiz.esq,  separator);  
	    displaySubTree(raiz.dir, separator);
	}
	
	private void displaySubTree(AVLNo no, String separator) {
		
		if (no != null){
			
			AVLNo pai = this.buscarPai(no);
			if (no.equals(pai.esq))
				System.out.println(separator+no.chave+"("+this.altura(no)+")"+" (ESQ)");
			else
				System.out.println(separator+no.chave+"("+this.altura(no)+")"+" (DIR)");
			
			displaySubTree(no.esq,  "     "+separator);  
	        displaySubTree(no.dir, "     "+separator);
			
		}
		
	}
	
	public void printArvoreBinaria(){
		this.printBinaryTree(this.raiz, this.altura());
	}
	
	private void printBinaryTree(AVLNo root, int level)
    {
		if(root==null)
            return;
         printBinaryTree(root.dir, level+1);
         if(level!=0)
         {
            for(int i=0;i<level-1;i++)
                System.out.print("|\t");
            System.out.println("|-------"+root.chave);
        }
        else
            System.out.println(root.chave);
        printBinaryTree(root.esq, level+1);
    }
	
}
