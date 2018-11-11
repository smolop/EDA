package paraAnalisis;

import java.util.Scanner;

public class RaizPE {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Escribe un número entero:");
		int num = input.nextInt();
		input.close();
		int resultado = raizPE(num);
		System.out.println("La parte entera de la raíz cuadrada de " + num + " es " + resultado);

	}

	public static int raizPE(int n) {
		// Pre: n >= 0
		int i = 0;
		while (i * i <= n) {
			i = i + 1;
		}
		return i - 1;
	}

}
