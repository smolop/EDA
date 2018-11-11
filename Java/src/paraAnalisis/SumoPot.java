package paraAnalisis;

import java.util.Scanner;

public class SumoPot {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Escribe un número entero:");
		int num = input.nextInt();
		int resultado = sumaLasPot(num);
		System.out.println("La suma de potencias de 2 menores o iguales que " + num + " es " + resultado);
		input.close();
	}

	public static int sumaLasPot(int n) {
		int suma = 0;
		for (int i = 1; i <= n; i = i * 2) {
			for (int j = 1; j <= i; j++) {
				suma++;
			}
		}
		return suma;
	}
}
