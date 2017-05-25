package hashingFechada;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class HashFechada {
	
	public static final int LINEAR = 1;
	public static final int QUADRATICO = 2;
	public static final int DUPLO_HASHING = 3;
	
	private Integer[] hash;
	private int TH, tentativa;
	
	public HashFechada(int tamanho, int tentativa){
		this.TH = tamanho;
		this.tentativa = tentativa;
		hash = new Integer[this.TH];
		for(Integer i : hash)
			i = null;		
	}
	
	public boolean vazia(){
		for(Integer i : hash)
			if (!i.equals(null))
				return false;
		return true;
	}

	public void inserir(int valor){
		int indice, thAux = this.TH, flagContDois = 0;		
		for (int i = 0; i < this.TH; i++){
			if (this.tentativa == LINEAR) {
				indice = (valor + i) % this.TH;
				if (i==0){
					System.out.println("INSERIR CHAVE "+valor);
					System.out.println("\t"+valor+" MOD "+this.TH+" = "+indice);
				} else 
					System.out.println("\t"+valor+"+"+i+" MOD "+this.TH+" = "+indice);						
			}
			else if (this.tentativa == QUADRATICO) {
				indice = (valor + i*i) % this.TH;
				if (i==0){
					System.out.println("INSERIR CHAVE "+valor);
					System.out.println("\t"+valor+" MOD "+this.TH+" = "+indice);
				} else 
					System.out.println("\t"+valor+"+"+i+"^2 MOD "+this.TH+" = "+indice);				
			}
			else {
				indice = valor % thAux;
				if (i == 0){
					System.out.println("INSERIR CHAVE "+valor);
					System.out.println("\tTH("+i+")="+thAux+"\t"+valor+" MOD "+thAux+" = "+indice);
				}
				else 
					System.out.println("\tTH("+i+")="+thAux+"\t"+valor+" MOD "+thAux+" = "+indice);
				thAux = proximoPrimoMenor(thAux);	
				
				if(flagContDois > 0)
					break;
				
			}
			if (hash[indice] == null){
				hash[indice] = valor;
				System.out.println("\tCHAVE "+valor+" INSERIDA NO INDICE "+indice);
				return;
			}		
			if (i == 0)
				System.out.println("\tCOLIDE COM "+hash[indice]+" EM "+indice);
			
			if (thAux == 2)
				flagContDois++;
		}
		System.out.println("\tCHAVE "+valor+" NAO PODE SER INSERIDA");		
	}

	public void deletar(int valor){
		int indice, thAux = this.TH, flagContDois = 0;		
		for (int i = 0; i < this.TH; i++){
			if (this.tentativa == LINEAR) {
				indice = (valor + i) % this.TH;
				if (i==0){
					System.out.println("DELETAR CHAVE "+valor);
					System.out.println("\t"+valor+" MOD "+this.TH+" = "+indice);
				} else 
					System.out.println("\t"+valor+"+"+i+" MOD "+this.TH+" = "+indice);
			}
			else if (this.tentativa == QUADRATICO) {
				indice = (valor + i*i) % this.TH;
				if (i==0){
					System.out.println("DELETAR CHAVE "+valor);
					System.out.println("\t"+valor+" MOD "+this.TH+" = "+indice);
				} else 
					System.out.println("\t"+valor+"+"+i+"^2 MOD "+this.TH+" = "+indice);
			}
			else {
				indice = valor % thAux;
				if (i == 0){
					System.out.println("DELETAR CHAVE "+valor);
					System.out.println("\tTH("+i+")="+thAux+"\t"+valor+" MOD "+thAux+" = "+indice);
				}
				else 
					System.out.println("\tTH("+i+")="+thAux+"\t"+valor+" MOD "+thAux+" = "+indice);
				thAux = proximoPrimoMenor(thAux);
				
				if(flagContDois > 0)
					break;
			}
			if (hash[indice] == valor){
				hash[indice] = null;
				System.out.println("\tCHAVE "+valor+" DELETADA DO INDICE "+indice);
				return;
			}
			
			if (thAux == 2)
				flagContDois++;			
		}
		System.out.println("\tCHAVE "+valor+" NAO ESTA INSERIDA NA HASH");
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
	
	private int proximoPrimoMenor(int thAux) {
		for (int i = thAux - 1; i >=1; i--)
			if (ehPrimo(i))
				return i;
		return 2;
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
	
	public int getTH() {
		return this.TH;
	}
	
}
