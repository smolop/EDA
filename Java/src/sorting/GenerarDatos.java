package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GenerarDatos {

	public static void main(String[] args) {
		final int NumElementos = 400000;
		try {
			PrintWriter output = new PrintWriter(new File(
					"src/sorting/datos4.txt"));
			output.println(NumElementos);
			// El primer número es el número de datos a considerar
			for (int i = NumElementos; i >= 1; i--) {
				output.println(i);
			}
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
