package terceiraQuestao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class Principal {

	public static final int NUMERO_DE_INDIVIDUOS = 100000;
	public static final int NUMERO_DE_BUSCAS = 100;
	public static final int INTERVALO = 1000;
	
	public static void main(String[] args) throws IOException {
		
		File f = new File("SaidaTempoMedioDeBuscaListaSimplesJava.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		
		ListaLigada listaLigada = new ListaLigada();
		Random gerador = new Random();
		int minimo = 1, maximo = 1000, cont = 1;
		
		for(int i = 0; i < NUMERO_DE_INDIVIDUOS; i++)
			listaLigada.adiciona(new Estrutura(GeradorAleatorio.nomeAleatorio(20), 
					gerador.nextInt(100),
					gerador.nextInt(100), 
					gerador.nextInt(100), 
					GeradorAleatorio.nomeAleatorio(20)));
				
		while (maximo <= NUMERO_DE_INDIVIDUOS){
			
			long tempoMedio = 0, tempoInicial = 0, tempoFinal = 0, tempoDif = 0;
			
			//System.out.println("\n**** INTERVALO DE "+minimo+" A "+maximo);
			
			for (int j = 0; j < NUMERO_DE_BUSCAS; j++){
				int numeroAleatorio = gerador.nextInt((maximo - minimo)+1) + minimo;
				
				tempoInicial = System.currentTimeMillis();
				
				Estrutura retorno = (Estrutura) listaLigada.pega(numeroAleatorio);
				
				tempoFinal = System.currentTimeMillis();
				
				tempoDif = tempoFinal - tempoInicial;
				
				tempoMedio = tempoMedio + tempoDif;
			}
			
			System.out.println(cont+"  "+((double)tempoMedio/NUMERO_DE_BUSCAS));
			
			bw.write(cont+"  "+((double)tempoMedio/NUMERO_DE_BUSCAS));
		    bw.newLine();
			
			cont++;
			
			minimo += INTERVALO;
			maximo += INTERVALO;
			
		}
		
		bw.close();
		fw.close();

	}

}
