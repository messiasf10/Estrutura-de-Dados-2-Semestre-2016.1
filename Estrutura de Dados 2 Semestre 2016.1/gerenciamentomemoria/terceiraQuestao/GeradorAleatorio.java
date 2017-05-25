package terceiraQuestao;

import java.util.Random;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class GeradorAleatorio {

	private static Random rand = new Random();
	private static char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
	public static String nomeAleatorio (int nCaracteres) {
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < nCaracteres; i++) {
	        int ch = rand.nextInt (letras.length);
	        sb.append (letras [ch]);
	    }    
	    return sb.toString();    
	}
	
	public static int numeroAleatorio(int max){
		return rand.nextInt(max+1);
	}
	
	public static int numeroAleatorioIntervalo(int min,int max){
		return rand.nextInt((max - min)+1) + min;
	}
	
}
