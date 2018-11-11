package aplicacionesDePilas;

import java.util.Scanner;

import ehu.eda.list.linkedImp.StackOfT;

public class PostfijaEval {
	private String exp;
	private Integer valor;

	public PostfijaEval(String s) {
		exp = s;
	}

	/*
	 * PRECONDICIÓN: la expresión postfija está bien formada
	 */
	public int evaluar() {

		Integer resultado = 0;
		StackOfT<Integer> laPila = new StackOfT<Integer>();
		Scanner laEntrada = new Scanner(this.exp);

		while (laEntrada.hasNext()) {
			String elem = laEntrada.next();
			if (esOperador(elem)) {
				Integer op2 = laPila.pop();
				Integer op1 = laPila.pop();
				resultado = calcula(elem.charAt(0), op1, op2);
				laPila.push(resultado);
			} else {
				laPila.push(Integer.parseInt(elem)); // laPila.push(new Integer(Integer.parseInt(elem)));
			}
		}
		this.valor = laPila.pop();

		return this.valor.intValue();
	}

	private boolean esOperador(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}

	private Integer calcula(char operador, int operando1, int operando2) {
		int result = 0;

		switch (operador) {
		case '+':
			result = operando1 + operando2;
			break;
		case '-':
			result = operando1 - operando2;
			break;
		case '*':
			result = operando1 * operando2;
			break;
		case '/':
			result = operando1 / operando2;
			break;
		}
		return result; // new Integer(result);
	}

}