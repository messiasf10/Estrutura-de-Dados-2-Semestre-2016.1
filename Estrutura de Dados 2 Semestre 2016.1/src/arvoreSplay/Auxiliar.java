package arvoreSplay;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class Auxiliar {

	public static NoBinaria noPai = null;
	public static NoBinaria vetorAncestrais[] = new NoBinaria[10];
	public static int limiteDeAncestrais = -1;
	public static boolean vetorFilhoEsquerdo[] = new boolean[10];
	public static NoBinaria noAchado = null;

	public static boolean buscarChaveComPai(NoBinaria noBinaria, Integer valor) {
		int comparacao = noBinaria.getChave().compareTo(valor);
		if (comparacao == 0) {
			noAchado = noBinaria;
			return true;
		}
		noPai = noBinaria;
		if (comparacao > 0) //retorna numero maior que zero se node maior do que valor
			if (noBinaria.getNoEsquerdo() != null)
				return buscarChaveComPai(noBinaria.getNoEsquerdo(), valor);
			else
				return false;
		else
			if (noBinaria.getNoDireito() != null)
				return buscarChaveComPai(noBinaria.getNoDireito(), valor);
			else
				return false;
	}

	public static boolean buscarChaveComAncestrais(NoBinaria noBinaria, Integer valor) {
		if (limiteDeAncestrais == vetorAncestrais.length - 1) { //caso o limite de ancestrais tenha atingido a capacidade maximo do vetor entao...
			vetorAncestrais = dobraTamanhoDoVetorNo(vetorAncestrais); //duploca o tamanho do vetor de nodes e repssa os valores
			vetorFilhoEsquerdo = dobraTamanhoDoVetorBool(vetorFilhoEsquerdo); //duploca o tamanho do vetor de boolean e repssa os valores
		}
		limiteDeAncestrais++;
		vetorAncestrais[limiteDeAncestrais] = noBinaria;
		int comparacao = noBinaria.getChave().compareTo(valor);
		if (comparacao == 0) {
			noAchado = noBinaria;
			return true;
		}
		noPai = noBinaria;
		if (comparacao > 0)
			if (noBinaria.getNoEsquerdo() != null) {
				vetorFilhoEsquerdo[limiteDeAncestrais] = true;
				return buscarChaveComAncestrais(noBinaria.getNoEsquerdo(), valor);
			} else {
				return false;
			}
		if (noBinaria.getNoDireito() != null) {
			vetorFilhoEsquerdo[limiteDeAncestrais] = false;
			return buscarChaveComAncestrais(noBinaria.getNoDireito(), valor);
		} else {
			return false;
		}
	}

	public static NoBinaria[] dobraTamanhoDoVetorNo(NoBinaria vetor[]) {
		NoBinaria retorno[] = new NoBinaria[vetor.length * 2];
		for (int i = 0; i < vetor.length; i++)
			retorno[i] = vetor[i];

		return retorno;
	}

	public static boolean[] dobraTamanhoDoVetorBool(boolean vetor[]) {
		boolean retorno[] = new boolean[vetor.length * 2];
		for (int i = 0; i < vetor.length; i++)
			retorno[i] = vetor[i];

		return retorno;
	}

	public static void zerarVariaveis() {
		for (int i = 0; i < vetorAncestrais.length; i++)
			vetorAncestrais[i] = null;

		limiteDeAncestrais = -1;
		noAchado = null;
		noPai = null;
	}	

}
