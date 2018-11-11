package paraAnalisis;

import java.util.Scanner;

public class Brinco {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Escribe un número entero:");
		int num = input.nextInt();
		int resultado = brincoPorDos(num);
		System.out.println("La suma de potencias de 2 menores o iguales que " + num + " es " + resultado);
		input.close();
	}

	public static int brincoPorDos(int n) {
		// Pre: n >= 0
		int suma = 0;
		for (int i = 1; i <= n; i = i * 2) {
			suma += i;
		}
		return suma;
	}
}