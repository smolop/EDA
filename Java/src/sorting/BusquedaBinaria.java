package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BusquedaBinaria {

	// PRECONDICIÓN: laTabla está ordenada de menor a mayor
	public static int binarySearch(int[] laTabla, int target) {
		return binarySearch(laTabla, 0, laTabla.length - 1, target);
	}

	private static int binarySearch(int[] tabla, int i, int f, int target) {
		if (i > f) {
			return -1; // target no está en la tabla
		} else {
			int mitad = (i + f) / 2;
			if (tabla[mitad] == target) {
				return mitad;
			} else if (tabla[mitad] > target) {
				return binarySearch(tabla, i, mitad - 1, target);
			} else {
				return binarySearch(tabla, mitad + 1, f, target);
			}
		}
	}

	public static void main(String[] args) {
		final int NUM = 100; // elemento que se desea buscar
		try {
			Scanner input = new Scanner(new File(
					"src/sorting/datos4ordenado.txt"));
			int n = input.nextInt(); // número de elementos del array V int[]
			int[] V = new int[n];
			for (int i = 0; i < V.length; i++) {
				V[i] = input.nextInt();
			}
			input.close();

			int index = binarySearch(V, NUM);

			if (index > 0) {
				System.out.println(NUM + " está en el índice " + index);
			} else {
				System.out.println(NUM + "no está");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
