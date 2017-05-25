package arvoreAVL;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class Fila {

	private Celula inicio, fim;
	
	public Fila(){
		this.inicio = this.fim = null;
	}
	
	public boolean vazia(){
		return this.inicio == null;
	}
	
	public void inserir(int dado){
		Celula nova = new Celula(dado);
		
		if (this.vazia())
			this.inicio = this.fim = nova;
		else {
			this.fim.prox = nova;
			this.fim = nova;
		}
	}
	
	public void remover(){
		if (!vazia()){
			//Celula aux = this.inicio;
			
			if (this.inicio.equals(this.fim))
				this.fim = null;
			
			this.inicio = this.inicio.prox;
		}
	}
	
	public int getTopo(){
		return this.inicio.chave;
	}
	
	public String toString(){
		String result= "[ ";
		
		if (!vazia()){
			Fila aux = new Fila();
			
			while(!vazia()){
				result += this.inicio.chave+" ";
				aux.inserir(this.inicio.chave);
				this.remover();
			}
			while(!aux.vazia()){
				this.inserir(aux.inicio.chave);
				aux.remover();
			}			 
		}
		result += "]";
		return result;
	}
	
	public void imprimir(){
		System.out.println(this.toString());
	}
	
}
