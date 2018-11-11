package aplicacionesDeColas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OficinaVirtualApp {

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File(
					"src/aplicacionesDeColas/datosOficina3.txt"));
			int n = input.nextInt(); // número de elementos a considerar
			int posicion = input.nextInt();
			int[] solicitudes = new int[n];
			for (int i = 0; i < n; i++) {
				solicitudes[i] = input.nextInt();
			}
			input.close();
			int prioridad = solicitudes[posicion - 1];

			OficinaVirtual ofi = new OficinaVirtual(solicitudes, posicion,
					prioridad);
			int num = ofi.AtendidasAntesQue(posicion, prioridad);
			System.out.println("Solicitudes atendidas antes: " + num);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
