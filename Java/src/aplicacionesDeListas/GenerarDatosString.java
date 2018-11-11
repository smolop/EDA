package aplicacionesDeListas;

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
		final int NumElementos = 60;
		try {
			PrintWriter output = new PrintWriter(new File(
					"src/aplicacionesDeListas/datosString.txt"));
			output.println(NumElementos);
			String[] array = new String[NumElementos];

			// El primer número es el número de datos a considerar
			for (int i = 1; i <= NumElementos; i++) {
				output.println("Apellido" + i);
				array[i - 1] = "Apellido" + i;
			}
			output.close();

			shuffleArray(array);
			PrintWriter output2 = new PrintWriter(new File(
					"src/aplicacionesDeListas/datosStringRandom.txt"));
			output2.println(NumElementos);

			// El primer número es el número de datos a considerar
			for (int i = 0; i < NumElementos; i++) {
				output2.println(array[i]);
			}
			output2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
