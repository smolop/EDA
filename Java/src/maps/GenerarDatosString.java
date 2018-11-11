package maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerarDatosString {

	private static void shuffleArray(String[] array) {
		int index;
		String temp;
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}

	public static void main(String[] args) {
		final int NumElementos = 600000;
		Random randomPal = new Random();
		try {
			PrintWriter output = new PrintWriter(new File(
					"src/maps/datosStringRandom.txt"));

			output.println(NumElementos);
			// El primer número es el número de datos a considerar

			int sufijo;
			for (int i = 1; i <= NumElementos; i++) {
				sufijo = randomPal.nextInt(NumElementos + 1);
				output.println("Palabra" + sufijo);
			}
			output.close();

			PrintWriter output2 = new PrintWriter(new File(
					"src/maps/datosStringNotRandom.txt"));

			output2.println(NumElementos);
			// El primer número es el número de datos a considerar
			int tasaDeCarga = 2;
			String[] array = new String[NumElementos];
			int i = 0;
			while (i < NumElementos) {
				array[i] = "Palabra" + i / tasaDeCarga;
				output2.println(array[i]);
				i++;
			}
			output2.close();

			// Si se quiere presentar de modo aleatorizado
			// shuffleArray(array);
			// y luego pasarlo a fichero
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
