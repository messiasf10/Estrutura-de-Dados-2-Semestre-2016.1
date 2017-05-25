package vetorDinamico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * 
 * @author Messias D. P. de M. Filho
 * 
 */

public class VetorDinamico {

	public static void main(String[] args) throws IOException {

		int TAM = 1000;
		int INTERVALO = TAM;
		int MAX = 500000;
		int NUMERO_AVALIACOES = 25;
		int UNIDADE = 5;

		File f = new File("SaidaVetorDinamico.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);

		try {

			while (TAM <= MAX) {

				int i, j;
				long tempoMedio = 0;
				ArrayList<Integer> vetor;

				for (i = 0; i < NUMERO_AVALIACOES; i++) {

					vetor = new ArrayList<Integer>();

					long tempoInicial = System.currentTimeMillis();

					for (j = 0; j < TAM; j++)
						vetor.add(UNIDADE);

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

		} catch (Exception e) {
			e.printStackTrace();
		}

		bw.close();
		fw.close();

	}

}
