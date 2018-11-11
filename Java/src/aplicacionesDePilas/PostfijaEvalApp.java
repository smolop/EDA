package aplicacionesDePilas;

import java.util.Scanner;

public class PostfijaEvalApp {

	public static void main(String[] args) {
		System.out.println("Escribe una expresión en notación postfija.");
		System.out.println("Debes poner solo números y operadores +, -, * o /, " + "separados por algún espacio: ");
		Scanner entrada = new Scanner(System.in);
		String expresion = entrada.nextLine();

		PostfijaEval evaluador = new PostfijaEval(expresion);
		int valor = evaluador.evaluar();
		System.out.println("El valor de ( " + expresion + " ) es: " + valor);
	}
}
