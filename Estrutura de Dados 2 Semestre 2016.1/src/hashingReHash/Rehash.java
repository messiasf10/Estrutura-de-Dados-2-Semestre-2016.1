package hashingReHash;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class Rehash {
	
	/**
	 * Variavel que indica a proporcao de elementos na hash
	 * Podemos alterar a proporcao de acordo com o que pensamos 
	 */
	public static final double HASH_CHEIA = 0.5;
	
	private Integer[] hash;
	private int TH, numeroDeElementos;
	
	public Rehash(int tamanho){
		this.TH = tamanho;
		this.hash = new Integer[this.TH];
		for(Integer i : hash)
			i = null;
	}

	/**
	 * Insere valores utilizando a tentativa quadratica
	 * @param int valor
	 */
	public void inserir(int valor){
		int indice;
		for (int i = 0; i < this.TH; i++){
			indice = (valor + i*i) % this.TH;
			
			if (i==0){
				System.out.println("INSERIR CHAVE "+valor);
				System.out.println("\t"+valor+" MOD "+this.TH+" = "+indice);
			} else 
				System.out.println("\t"+valor+"+"+i+"^2 MOD "+this.TH+" = "+indice);
			
			if(hash[indice] == null){
				hash[indice] = valor;
				numeroDeElementos++;
				System.out.println("\tCHAVE "+valor+" INSERIDA NO INDICE "+indice);
				if (this.cheia() > HASH_CHEIA) {
					System.out.println("\tHASH ESTA CHEIA. NECESSARIO FAZER REHASHING");
					this.fazerRehashing();
				}
				return;
			}
			if (i == 0)
				System.out.println("\tCOLIDE COM "+hash[indice]+" EM "+indice);
		}
		System.out.println("\nCHAVE "+valor+" NAO PODE SER INSERIDA. NECESSARIO FAZER REHASHING PARA PODER INSERIR A CHAVE "+valor);
		//Faz rehashing caso nao consiga inserir o numero
		this.fazerRehashing();
		this.inserir(valor);
	}

	public void deletar(int valor){
		if (!this.vazia()){
			int indice;	
			
			for (int i = 0; i < this.TH; i++){
				indice = (valor + i*i) % this.TH;
				
				if (i==0){
					System.out.println("DELETAR CHAVE "+valor);
					System.out.println("\t"+valor+" MOD "+this.TH+" = "+indice);
				} else 
					System.out.println("\t"+valor+"+"+i+"^2 MOD "+this.TH+" = "+indice);
				
				if(this.hash[indice] != null && this.hash[indice] == valor){
					this.hash[indice] = null;
					this.numeroDeElementos--;
					System.out.println("\tCHAVE "+valor+" DELETADA DO INDICE "+indice);
					return;
				}
			}
			System.out.println("\tCHAVE "+valor+" NAO ESTA INSERIDA NA HASH");
		}
	}

	public boolean vazia(){
		for(Integer i : hash)
			if (i != null)
				return false;
		return true;
	}
	
	private double cheia(){
		return  ((double) this.numeroDeElementos / (double) this.TH);
	}
	
	private int proximoPrimo(int thAux) {
		for (int i = thAux + 1; ; i++)
			if (this.ehPrimo(i)) 
				return i;
	}
	
	private int anteriorPrimo(int thAux){
		for (int i = thAux - 1; i >= 1; i--)
			if (ehPrimo(i)) 
				return i;			
		return 2;
	}
	
	private int primoMaisProximo(int thAux){
		int anteriorPrimo = this.anteriorPrimo(thAux),
				proximoPrimo = this.proximoPrimo(thAux);
		return thAux-anteriorPrimo >= proximoPrimo-thAux ? proximoPrimo : anteriorPrimo;
	}
	
	private boolean ehPrimo(int valor){
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
	
	/**
	 * Aplica a Rehashing duplicando o tamanho da hash para o primo mais proximo
	 */
	private void fazerRehashing() {
		this.numeroDeElementos = 0;
		Integer[] hashAux = new Integer[this.TH];
		int thAntigo = this.TH;
		
		for (int i = 0; i < this.TH; i++)
			hashAux[i] = this.hash[i]; 
		
		this.TH = this.proximoPrimo(this.TH * 2); //Podemos mudar para o poximo primo como no slide mais novo do navio
		this.hash = new Integer[this.TH];
		
		System.out.println("\tTH NOVO = "+this.TH);
		
		for (int i = 0; i < this.TH; i++)
			this.hash[i] = null;
		
		System.out.println("\tINSERINDO VALORES PARA A NOVA HASH DE TAMANHO "+this.TH);
		
		for (int i = 0; i < thAntigo; i++)
			if (hashAux[i] != null)
				this.inserir(hashAux[i]);		
	}
	
	public String toString(){
		String resultado = "";
		for (int i = 0; i < this.TH; i++){
			String valor = (hash[i] == null) ? "" : hash[i]+"";
			resultado += "(CELULA "+i+") ["+valor+"]\n";
		}
		return resultado;
	}
	
	public void imprimir(){
		System.out.println(this.toString());
	}
	
}
