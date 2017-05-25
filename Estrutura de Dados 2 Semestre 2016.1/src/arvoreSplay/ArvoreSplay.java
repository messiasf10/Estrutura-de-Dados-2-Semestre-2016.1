package arvoreSplay;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class ArvoreSplay extends ArvoreBinaria {

	public ArvoreSplay() {
	}
	
	public boolean buscar(Integer valor) {
		boolean retorno = super.buscar(valor);
		if (!retorno)
			return false;
		for (int nivelAtual = Auxiliar.limiteDeAncestrais; nivelAtual > 0;)
			if (nivelAtual == 1) {
				if (Auxiliar.vetorFilhoEsquerdo[0])
					rotacaoZig();
				else
					rotacaoZag();
				nivelAtual--;
			} else {
				if (Auxiliar.vetorFilhoEsquerdo[nivelAtual - 1]) {
					if (Auxiliar.vetorFilhoEsquerdo[nivelAtual - 2])
						rotacaoZigZig(nivelAtual);
					else
						rotacaoZigZag(nivelAtual);
				} else if (Auxiliar.vetorFilhoEsquerdo[nivelAtual - 2])
					rotacaoZagZig(nivelAtual);
				else
					rotacaoZagZag(nivelAtual);
				nivelAtual -= 2;
			}

		return true;
	}

	public void rotacaoZig() {
		
		System.out.println("\n** ROTACAO A DIREITA - ZIG **");
		
		this.printArvoreBinaria();
		System.out.println("\n\t|  |\n\t|  |\n\t\\  /\n\t \\/\n");
		
		Auxiliar.vetorAncestrais[0].setNoEsquerdo(Auxiliar.vetorAncestrais[1].getNoDireito());
		Auxiliar.vetorAncestrais[1].setNoDireito(Auxiliar.vetorAncestrais[0]);
		raiz = Auxiliar.vetorAncestrais[1];
	}

	public void rotacaoZag() {
		
		System.out.println("\n** ROTACAO A ESQUERDA - ZAG **");
		
		this.printArvoreBinaria();
		System.out.println("\n\t|  |\n\t|  |\n\t\\  /\n\t \\/\n");
		
		Auxiliar.vetorAncestrais[0].setNoDireito(Auxiliar.vetorAncestrais[1].getNoEsquerdo());
		Auxiliar.vetorAncestrais[1].setNoEsquerdo(Auxiliar.vetorAncestrais[0]);
		raiz = Auxiliar.vetorAncestrais[1];
	}

	public void rotacaoZigZig(int nivelAtual) {
		System.out.println("\n** ROTACAO ZIG-ZIG **");
		
		this.printArvoreBinaria();
		System.out.println("\n\t|  |\n\t|  |\n\t\\  /\n\t \\/\n");		
		
		Auxiliar.vetorAncestrais[nivelAtual - 1].setNoEsquerdo(Auxiliar.vetorAncestrais[nivelAtual].getNoDireito());
		Auxiliar.vetorAncestrais[nivelAtual - 2].setNoEsquerdo(Auxiliar.vetorAncestrais[nivelAtual - 1].getNoDireito());
		Auxiliar.vetorAncestrais[nivelAtual].setNoDireito(Auxiliar.vetorAncestrais[nivelAtual - 1]);
		Auxiliar.vetorAncestrais[nivelAtual - 1].setNoDireito(Auxiliar.vetorAncestrais[nivelAtual - 2]);
		if (nivelAtual == 2)
			raiz = Auxiliar.vetorAncestrais[2];
		else
			Auxiliar.vetorAncestrais[nivelAtual - 2] = Auxiliar.vetorAncestrais[nivelAtual];
	}

	public void rotacaoZagZag(int nivelAtual) {
		
		System.out.println("\n** ROTACAO ZAG-ZAG **");
		
		this.printArvoreBinaria();
		System.out.println("\n\t|  |\n\t|  |\n\t\\  /\n\t \\/\n");
		
		Auxiliar.vetorAncestrais[nivelAtual - 1].setNoDireito(Auxiliar.vetorAncestrais[nivelAtual].getNoEsquerdo());
		Auxiliar.vetorAncestrais[nivelAtual - 2].setNoDireito(Auxiliar.vetorAncestrais[nivelAtual - 1].getNoEsquerdo());
		Auxiliar.vetorAncestrais[nivelAtual].setNoEsquerdo(Auxiliar.vetorAncestrais[nivelAtual - 1]);
		Auxiliar.vetorAncestrais[nivelAtual - 1].setNoEsquerdo(Auxiliar.vetorAncestrais[nivelAtual - 2]);
		if (nivelAtual == 2)
			raiz = Auxiliar.vetorAncestrais[2];
		else
			Auxiliar.vetorAncestrais[nivelAtual - 2] = Auxiliar.vetorAncestrais[nivelAtual];
	}

	public void rotacaoZagZig(int nivelAtual) {
		
		System.out.println("\n** ROTACAO ZAG-ZIG **");
		
		this.printArvoreBinaria();
		System.out.println("\n\t|  |\n\t|  |\n\t\\  /\n\t \\/\n");
		
		Auxiliar.vetorAncestrais[nivelAtual - 1].setNoDireito(Auxiliar.vetorAncestrais[nivelAtual].getNoEsquerdo());
		Auxiliar.vetorAncestrais[nivelAtual - 2].setNoEsquerdo(Auxiliar.vetorAncestrais[nivelAtual].getNoDireito());
		Auxiliar.vetorAncestrais[nivelAtual].setNoEsquerdo(Auxiliar.vetorAncestrais[nivelAtual - 1]);
		Auxiliar.vetorAncestrais[nivelAtual].setNoDireito(Auxiliar.vetorAncestrais[nivelAtual - 2]);
		if (nivelAtual == 2)
			raiz = Auxiliar.vetorAncestrais[2];
		else
			Auxiliar.vetorAncestrais[nivelAtual - 2] = Auxiliar.vetorAncestrais[nivelAtual];
	}

	public void rotacaoZigZag(int nivelAtual) {
		
		System.out.println("\n** ROTACAO ZIG-ZAG **");
		
		this.printArvoreBinaria();
		System.out.println("\n\t|  |\n\t|  |\n\t\\  /\n\t \\/\n");
		
		Auxiliar.vetorAncestrais[nivelAtual - 2].setNoDireito(Auxiliar.vetorAncestrais[nivelAtual].getNoEsquerdo());
		Auxiliar.vetorAncestrais[nivelAtual - 1].setNoEsquerdo(Auxiliar.vetorAncestrais[nivelAtual].getNoDireito());
		Auxiliar.vetorAncestrais[nivelAtual].setNoEsquerdo(Auxiliar.vetorAncestrais[nivelAtual - 2]);
		Auxiliar.vetorAncestrais[nivelAtual].setNoDireito(Auxiliar.vetorAncestrais[nivelAtual - 1]);
		if (nivelAtual == 2)
			raiz = Auxiliar.vetorAncestrais[2];
		else
			Auxiliar.vetorAncestrais[nivelAtual - 2] = Auxiliar.vetorAncestrais[nivelAtual];
	}
	
	public int altura(){
		return this.altura(raiz);
	}
	
	private int altura(NoBinaria noBinaria) {
		if (noBinaria == null){
			return -1;
		} else {
			int altEsq = 1 + altura(noBinaria.getNoEsquerdo());
			int altDir = 1 + altura(noBinaria.getNoDireito());
			return (altEsq > altDir) ? altEsq : altDir;
		}		
	}
	
	public void printArvoreBinaria(){
		this.printBinaryTree(this.raiz, this.altura());
	}
	
	private void printBinaryTree(NoBinaria root, int level)
    {
		if(root==null)
            return;
         printBinaryTree(root.getNoDireito(), level+1);
         if(level!=0)
         {
            for(int i=0;i<level-1;i++)
                System.out.print("|\t");
            System.out.println("|-------"+root.chave);
        }
        else
            System.out.println(root.chave);
        printBinaryTree(root.getNoEsquerdo(), level+1);
    }
	
}
