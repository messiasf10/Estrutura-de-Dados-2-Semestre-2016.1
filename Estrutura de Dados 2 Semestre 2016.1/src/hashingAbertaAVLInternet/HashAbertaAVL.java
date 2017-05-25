package hashingAbertaAVLInternet;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class HashAbertaAVL {
	
	private AvlTree[] hash;
	private int TH, FC; //Fator de carga
	private double FB; //Fator de balanceamento
	
	public HashAbertaAVL (int tamanhoHash){
		this.TH = tamanhoHash;
		this.FC = 0; 
		this.FB = 0; 
		this.hash = new AvlTree[TH];
		for (int i =0; i < hash.length; i++)
			hash[i] = new AvlTree();		
	}
	
	public void inserir(int valor){
		int indice = valor % TH;
		hash[indice].insert(valor);		
	}

	/*public void deletar(int valor){
		if (!this.vazia()){
			int indice = valor % TH;
			hash[indice].remove(valor);
		}
	}*/

	public void imprimir(){
		for (int i = 0; i < hash.length; i++) {
			System.out.print("("+i+") ");
			hash[i].displayTree();
		}
		System.out.println("");
	}

	private boolean vazia(){
		for(int i = 0; i < hash.length; i++)
			if (!hash[i].isEmpty())
				return false;		
		return true;
	}

	/*private int calcularFC(){
		for (int i = 0;i<hash.length; i++)
			FC = hash[i].tamanho() > FC ? hash[i].tamanho() : FC;		
		return this.FC;
	}*/
	
	/*private double calcularFB(){
		int somatorio = 0;
		
		for (int i = 0; i< hash.length; i++)
			somatorio += hash[i].tamanho();
		
		this.FB = (this.getFC() != 0) ? (double) somatorio/(TH*FC) : 0;
		
		return this.FB;
	}*/

	/*public int getFC(){		
		return calcularFC();
	}*/

	/*public double getFB(){
		return calcularFB();
	}*/
	
}
