package aplicacionesDeListas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import ehu.eda.list.linkedImp.LinkedOrdList;

public class LinkedOrdListApp {

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("src/aplicacionesDeListas/datosStringRandom.txt"));
			int n = input.nextInt(); // número de elementos a considerar
			LinkedOrdList<String> miLista = new LinkedOrdList<String>();
			for (int i = 1; i <= n; i++) {
				miLista.add(input.next());
			}
			input.close();

			PrintWriter resultado = new PrintWriter(new File("src/aplicacionesDeListas/datosStringOrd.txt"));
			resultado.println(n);
			for (int i = 1; i <= n; i++) {
				resultado.println(miLista.removeFirst());
			}
			resultado.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
