package hashingMeioAbertaModificada;

import arvoreAVL.AVL;
import arvoreAVL.AVLNo;
import arvoreAVL.Fila;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class HashMeioAbertaModificada {

	public static final double MUITO_CHEIA = 0.50;
	
	private AVL[] hash;
	private int TH, FC, LFC, NCF; //NCF IGUALA A NUMERO DE CELULAS FECHADAS 
	private double FB;
	
	public HashMeioAbertaModificada(int tamHash, int limite){
		this.TH = tamHash;
		this.LFC = limite;
		this.FB = this.FC = this.NCF = 0;		
		this.hash = new AVL[this.TH];
		for(int i = 0; i < this.TH; i++)
			this.hash[i] = new AVL();
	}
	
	public boolean vazia(){
		for (int i =0; i < this.TH; i++)
			if(!hash[i].vazia())
				return false;
		return true;
	}
	
	public int getTH(){
		return this.TH;
	}
	
	/**
	 * Fator de carga eh definido aqui como sendo a altura maxima das arvores da hashing
	 */
	public void calculoFC(){
		int fatorCarga = 0;
		
		for(int i = 0; i < this.TH; i++)
			fatorCarga = (hash[i].altura()+1> fatorCarga) ? hash[i].altura()+1 : fatorCarga;
		
		this.FC = fatorCarga;
	}
	
	public int getFC(){
		return this.FC;
	}
	
	public void calculoFB(){
		int somatorio = 0;

	    for(int i=0; i<TH; i++)
	        somatorio += hash[i].altura()+1;
	    FB = (FC != 0)? (double)somatorio/(TH*FC): 0;
	    
	}
	
	public double getFB(){
		return 100*this.FB;
	}
	
	public void inserir(int valor){
		int indice;
		
		for(int i=0; i<TH; i++) {
	        indice = (valor + i*i) % this.TH;
	        
	        if (i==0){
				System.out.println("INSERIR CHAVE "+valor);
				System.out.println("\t"+valor+" MOD "+this.TH+" = "+indice);
			} else 
				System.out.println("\t"+valor+"+"+i+"^2 MOD "+this.TH+" = "+indice);
	        
	        
	        boolean celulaComCargaMaxima = celulaComCargaMaxima(hash[indice]);
	        
	        if (celulaComCargaMaxima){	        		        	
	        	System.out.println("\tCOLISAO. CELULA DE INDICE "+indice+" FECHADA POIS ATINGIU O LIMITE DE CARGA");
	        	//AGORA VAI FAZER TENTATIVA QUADRATICA	        	
	        } else {
	        	
	        	AVLNo temp = hash[indice].buscar(valor);
	        	if(temp == null) {
		            hash[indice].inserir(valor);
		            
		            System.out.println("\tCHAVE "+valor+" INSERIDA NO INDICE "+indice);
		            
		            calculoFC();
		            calculoFB();
		            calculoNCF();
		            
		            if ( getPNCF() > MUITO_CHEIA ){
		            	System.out.println("\tMAIS DA METADE DAS CELULAS DA HASHING EXCEDEU O LFC. NECESSARIO FAZER REHASHING");
		            	this.fazerRehashing();	            	
		            }
		            
		            return;
		        }	        	
	        	
	        }
	        
	        if (i == 0 && !celulaComCargaMaxima)
				System.out.println("\tCOLIDE COM "+valor+" EM "+indice);
	    }
	    System.out.println("\nESSE NUMERO NAO PODE SER INSERIDO, FAZER REHASHING");
	    fazerRehashing();
	    this.inserir(valor);
	}
	
	
	/**
	 * 
	 * @return Retorna o numero de celulas fechadas, ou seja, o numero de celulas que atingiram o fator de carga maximo
	 */
	public int calculoNCF(){
		this.NCF = 0;
        for(int j = 0; j < this.TH; j++){	            	
        	if (hash[j].altura() == this.LFC){
        		this.NCF += 1;
        	}
        }
        return this.NCF;
	}
	
	/**
	 * 
	 * @return Retorna a proporcao do numero de celulas que estao fechadas, ou seja, faz a relação entre o numero de celulas que atingiram
	 * o fator de carga maximo e o tamanho da hashing 
	 */
	private double getPNCF(){
		return  (double) this.NCF/this.TH;
	}
	
	/**
	 * 
	 * @param avl
	 * @return true se a arvore passada atingiu o limite do fator de carga
	 * 		   false se a arvore passada nao atingiu o limite do fator de carga
	 */
	private boolean celulaComCargaMaxima(AVL avl){
		return avl.altura() == this.LFC;
	}
	
	public void fazerRehashing() {
		Fila temp = new Fila();
		int th = this.TH;
		
		for (int i = 0; i < this.TH; i++){
			while(!hash[i].vazia()){
				temp.inserir(hash[i].chaveRaiz());
				hash[i].remover(2, hash[i].chaveRaiz());
			}
		}
		
		this.TH = this.proximoPrimo(2*this.TH); //Pode ser ou o primo mais proximo ou o proximo primo
		this.hash = new AVL[this.TH];
		
		System.out.println("\tTH NOVO = "+this.TH);
		
		for (int i = 0; i < this.TH; i++)
			hash[i] = new AVL();
		this.FB = this.FC = this.NCF = 0;
		
		System.out.println("\tINSERINDO VALORES PARA A NOVA HASH DE TAMANHO "+this.TH);
		
		for (int i = 0; i < th; i++){
			while(!temp.vazia()){
				this.inserir(temp.getTopo());
				temp.remover();
			}
		}
	}

	public void deletar(int valor){
		if(!this.vazia()){
			int indice = valor % this.TH;
			
			for(int i=0; i<TH; i++) {
	            indice = (valor + i*i)%TH;

	            if (i==0){
					System.out.println("DELETAR CHAVE "+valor);
					System.out.println("\t"+valor+" MOD "+this.TH+" = "+indice);
				} else 
					System.out.println("\t"+valor+"+"+i+"^2 MOD "+this.TH+" = "+indice);
	            
	            AVLNo temp = hash[indice].buscar(valor);
	            if(temp != null) {
	                hash[indice].remover(2,valor);
	                
	                System.out.println("\tCHAVE "+valor+" DELETADA DO INDICE "+indice);
	                
	                return;
	            }
	        }
			System.out.println("\tNUMERO NAO ESTA INSERIDO NA HASH");
		}
	}
	
	public boolean ehPrimo(int valor){
		int flag = 0;
		
		if (valor == 1)
			return false;	//Nao tem mais numeros primos abaixo de 1
		
		for(int i = 1; i<= valor; i++)
			if (valor % i == 0)
				flag++;
		
		if (flag == 2)
			return true;
		else 	
			return false;
	}
	
	private int proximoPrimo(int thAux) {
		for (int i = thAux + 1; ; i++)
			if (this.ehPrimo(i)) {
				return i;		
			}
		
	}
	
	private int anteriorPrimo(int thAux){
		for (int i = thAux - 1; i >= 1; i--)
			if (ehPrimo(i)) {
				return i;
			}
		return 2;
	}
	
	private int primoMaisProximo(int thAux){
		int anteriorPrimo = this.anteriorPrimo(thAux),
				proximoPrimo = this.proximoPrimo(thAux);
		return thAux-anteriorPrimo >= proximoPrimo-thAux ? proximoPrimo : anteriorPrimo;
	}
	
	public void exibir(){
		System.out.print("\n\nHashing: {");
		for (int i = 0; i < this.TH; i++){
			hash[i].percorrer(1, 0);
			if (i < this.TH - 1)
				System.out.print(", ");
		}
		System.out.print("} \n");
	}
	
	public void imprimir(){
		for (int i = 0; i < hash.length; i++) {
			System.out.print("(#"+i+") \n");
			hash[i].printArvoreBinaria();
		}
		System.out.println("");
	}
	
	
	
}
