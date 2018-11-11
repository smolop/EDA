package buscaPares;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class pares {

	public static void main(String[] args) {
		final int SUMA_DE_PAREJA = 100;
		try {
			// El primer elemento del fichero debe ser el número de enteros a considerar
			// El resto de los elementos deben ser enteros distintos
			Scanner input = new Scanner(new File("src/buscaPares/datosOrd5.txt"));
			int n = input.nextInt(); // número de elementos del array V
			int[] V = new int[n];
			for (int i = 0; i < V.length; i++) {
				V[i] = input.nextInt();
			}
			input.close();

			// int[] V = { 15, 8, 20, 17, 9, 21 }; //Alternativa de generación manual
			int k = SUMA_DE_PAREJA;
			int resultado = numPares(V, k);
			System.out.println("El número de parejas que suman " + k + " es: " + resultado);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int numPares(int[] A, int k) {
		int cont = 0; // número de pares
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] + A[j] == k) {
					cont++;
				}
			}
		}
		return cont;
	}

	public static int numParesOrd(int[] A, int k) {
		int cont = 0; // número de pares
		int izq = 0; // índice para la parte izquierda
		int der = A.length - 1; // índice para la parte derecha
		while (izq < der) {
			if (A[izq] + A[der] < k) {
				izq++;
			} else if (A[izq] + A[der] > k) {
				der--;
			} else {
				cont++;
				izq++;
				der--;
			}
		}
		return cont;
	}

}
