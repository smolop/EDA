package aplicacionesDeListas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GenerarDatosInt {

	public static void main(String[] args) {
		final int NumElementos = 60;
		try {
			PrintWriter output = new PrintWriter(new File("src/aplicacionesDeListas/datosInt.txt"));
			output.println(NumElementos);
			// El primer número es el número de datos a considerar
			for (int i = 1; i <= NumElementos; i++) {
				output.println(i);
			}
			output.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
