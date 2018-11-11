package ehu.eda.list.arrayImp;

/**
 * Una implementación simple de PILAs (listas LIFO), usando un array.
 * 
 * En esta implementación, las pilas tienen capacidad limitada, que se establece
 * en la constructora.
 * 
 * Todas las operaciones tienen tiempo de ejecucion en Theta(1) (tiempo
 * constante: independiente de la entrada y del tamaño de la pila).
 *
 */
public class StackOfStrings {
	private String[] s; // array para almacenar los elementos de la pila
	private int n; // cantidad de elementos en la pila

	public StackOfStrings(int capacity) {
		s = new String[capacity]; // Se crea un array para albergar hasta "capacity" strings
		n = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * Devuelve el elemento en la cima de la pila o null si la pila está vacía.
	 */
	public String peek() {
		return isEmpty() ? null : s[n - 1];
		/*
		 * Expresión condicional. En general Condicion ? Exp1: Exp2 el resultado es lo
		 * que valga Exp1 si Condicion es true, o lo que valga Exp2, si Condicion es
		 * false.
		 */
	}

	/**
	 * Retira y devuelve el elemento en la cima de la pila.
	 * 
	 * PRECONDICIÓN: la pila no está vacía
	 */
	public String pop() {
		n = n - 1;
		return s[n];
		// Equivale a: return s[--n];
	}

	/**
	 * PRECONDICIÓN: la pila no está llena
	 */
	public void push(String item) {
		s[n] = item;
		n = n + 1;
		// Equivale a: s[n++] = item;
	}

	public int size() {
		return n;
	}
}
