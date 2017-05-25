package vetorEstatico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Messias D. P. de M. Filho
 * 
 */

public class VetorEstatico {

	public static void main(String[] args) throws IOException {

		int TAM = 1000;
		int INTERVALO = TAM;
		int MAX = 500000;
		int NUMERO_AVALIACOES = 25;
		int UNIDADE = 5;

		File f = new File("SaidaVetorEstatico.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);

		while (TAM <= MAX) {

			int i, j;
			long tempoMedio = 0;
			int vetor[];

			for (i = 0; i < NUMERO_AVALIACOES; i++) {

				vetor = new int[TAM];

				long tempoInicial = System.currentTimeMillis();

				for (j = 0; j < TAM; j++)
					vetor[j] = UNIDADE;

				long tempoFinal = System.currentTimeMillis();

				long tempoDif = tempoFinal - tempoInicial;

				tempoMedio = tempoMedio + tempoDif;

			}

			// tempoMedio = tempoMedio / NUMERO_AVALIACOES;

			System.out.println(TAM + "  "
					+ ((double) tempoMedio / NUMERO_AVALIACOES));

			bw.write(TAM + "  " + ((double) tempoMedio / NUMERO_AVALIACOES));
			bw.newLine();

			TAM += INTERVALO;

		}

		bw.close();
		fw.close();

	}

}
