package hashingAbertaLista;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class HashAbertaLista {
	
	private ListaLigada[] hash;
	private int TH, FC; //Fator de carga
	private double FB; //Fator de balanceamento
	
	public HashAbertaLista (int tamanhoHash){
		this.TH = tamanhoHash;
		this.FC = 0; 
		this.FB = 0; 
		this.hash = new ListaLigada[TH];
		for (int i =0; i < hash.length; i++)
			hash[i] = new ListaLigada();		
	}
	
	public void inserir(int valor){
		int indice = valor % TH;
		System.out.println("INSERIR CHAVE "+valor+"\n"
				+ "\t"+valor+" MOD "+this.TH+" = "+indice+"\n"
						+ "\tCHAVE "+valor+" INSERIDA NO INDICE "+indice);		
		hash[indice].adicionaNoComeco(valor);		
	}

	public void deletar(int valor){
		if (!this.vazia()){
			int indice = valor % TH;
			System.out.println("DELETAR CHAVE "+valor+"\n"
					+ "\t"+valor+" MOD "+this.TH+" = "+indice+"\n"
					+ "\tCHAVE "+valor+" DELETADA DO INDICE "+indice);		
			hash[indice].remove(valor);
		}
	}

	public void imprimir(){
		for (int i = 0; i < hash.length; i++)
			System.out.println("(CELULA "+i+") -> "+hash[i].toString());
		System.out.println("");
	}

	private boolean vazia(){
		for(int i = 0; i < hash.length; i++)
			if (hash[i].tamanho() != 0)
				return false;		
		return true;
	}

	private int calcularFC(){
		for (int i = 0;i<hash.length; i++)
			FC = hash[i].tamanho() > FC ? hash[i].tamanho() : FC;		
		return this.FC;
	}
	
	//VERIFICAR NO SLIDES DE HASH ABERTA O FATOR DE BALANCEAMENTO
	private double calcularFB(){
		int somatorio = 0;
		
		for (int i = 0; i< hash.length; i++)
			somatorio += hash[i].tamanho();
		
		this.FB = (this.getFC() != 0) ? (double) somatorio/(TH*FC) : 0;
		
		return 100*this.FB;
	}

	public int getFC(){		
		return this.calcularFC();
	}

	public double getFB(){
		return this.calcularFB();
	}
	
}
