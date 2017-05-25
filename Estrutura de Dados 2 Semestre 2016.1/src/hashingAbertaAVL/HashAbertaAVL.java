package hashingAbertaAVL;

import arvoreAVL.AVL;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class HashAbertaAVL {
	
	private AVL[] hash;
	private int TH, FC; //Fator de carga
	private double FB; //Fator de balanceamento
	
	public HashAbertaAVL (int tamanhoHash){
		this.TH = tamanhoHash;
		this.FC = 0; 
		this.FB = 0; 
		this.hash = new AVL[this.TH];
		for (int i =0; i < this.TH; i++)
			hash[i] = new AVL();		
	}
	
	public void inserir(int valor){
		int indice = valor % TH;
		System.out.println("INSERIR CHAVE "+valor+"\n"
				+ "\t"+valor+" MOD "+this.TH+" = "+indice);		
		hash[indice].inserir(valor);		
	}

	public void deletar(int valor){
		if (!this.vazia()){
			int indice = valor % TH;
			System.out.println("DELETAR CHAVE "+valor+"\n"
					+ "\t"+valor+" MOD "+this.TH+" = "+indice);		
			hash[indice].remover(2, valor);
		}
	}

	public void imprimir(){
		for (int i = 0; i < this.TH; i++) {
			System.out.print("(CELULA "+i+") \n");
			hash[i].printArvoreBinaria();			
		}		
		System.out.println();
	}

	public boolean vazia(){
		for(int i = 0; i < hash.length; i++)
			if (!hash[i].vazia())
				return false;		
		return true;
	}
	
	public int getTH(){
		return this.TH;
	}
	
	public int getFC(){		
		return this.calculoFC();
	}
	
	public double getFB(){
		return calculoFB()*100;
	}

	private int calculoFC(){
		int fatorDeCarga = 0;
		
		for (int i = 0;i<this.TH; i++)
			fatorDeCarga = (hash[i].altura()+1 > fatorDeCarga) ? hash[i].altura()+1 : fatorDeCarga;		
		
		this.FC = fatorDeCarga;
		
		return this.FC;
	}
	
	private double calculoFB(){
		int somatorio = 0;
		
		for (int i = 0; i< this.TH; i++)
			somatorio += hash[i].altura()+1;
		
		this.FB = (this.getFC() != 0) ? (double) somatorio/(TH*FC) : 0;
		
		return this.FB;
	}
	
}
