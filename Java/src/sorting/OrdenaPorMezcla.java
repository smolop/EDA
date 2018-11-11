package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class OrdenaPorMezcla {

	public static void mergeSort(int[] laTabla) {
		mergeSort(laTabla, 0, laTabla.length - 1);
	}

	private static void mergeSort(int[] tabla, int inicio, int fin) {
		if (inicio < fin) {
			mergeSort(tabla, inicio, (inicio + fin) / 2);
			mergeSort(tabla, (inicio + fin) / 2 + 1, fin);
			mezcla(tabla, inicio, (inicio + fin) / 2, fin);
		}
	}

	private static void mezcla(int[] tabla, int i, int centro, int f) {
		int[] laMezcla = new int[f - i + 1];
		int izq = i;
		int der = centro + 1;
		int k = 0; // índice para rellenar laMezcla
		while (izq <= centro && der <= f) {
			if (tabla[izq] <= tabla[der]) {
				laMezcla[k] = tabla[izq];
				k++;
				izq++;
			} else {
				laMezcla[k] = tabla[der];
				k++;
				der++;
			}
		}
		if (izq > centro) {
			while (der <= f) {
				laMezcla[k] = tabla[der];
				k++;
				der++;
			}
		} else {
			while (izq <= centro) {
				laMezcla[k] = tabla[izq];
				k++;
				izq++;
			}
		}
		for (int j = i; j <= f; j++) {
			tabla[j] = laMezcla[j - i];
		}
	}

	private static void shuffleArray(int[] array) {
		int index;
		int temp;
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("src/sorting/datos4.txt"));
			int n = input.nextInt(); // número de elementos del array V int[]
			int[] V = new int[n];
			for (int i = 0; i < V.length; i++) {
				V[i] = input.nextInt();
			}
			input.close();

			shuffleArray(V);

			mergeSort(V);

			PrintWriter output = new PrintWriter(new File(
					"src/sorting/datos4ordenado.txt"));
			output.println(V.length);
			// El primer número es el número de datos a considerar
			for (int i = 0; i < V.length; i++) {
				output.println(V[i]);
			}
			output.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
