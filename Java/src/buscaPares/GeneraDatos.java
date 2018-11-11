package buscaPares;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GeneraDatos {

	public static void main(String[] args) {
		final int TOPE = 500000;
		try {
			PrintWriter output = new PrintWriter(new File("src/buscaPares/datosOrd5.txt"));
			output.println(TOPE);
			for (int i = 1; i <= TOPE; i++) {
				output.println(i);
			}
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
