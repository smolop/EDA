package ehu.eda.list.arrayImp;

import java.time.LocalDate;

/**
 * Una implementación simple de PILAs (listas LIFO), usando un array.
 * 
 * En esta implementación, las pilas tienen capacidad limitada, que se establece
 * en la constructora.
 * 
 * Todas las operaciones tienen tiempo de ejecución en Theta(1) (tiempo
 * constante: independiente de la entrada y del tamaño de la pila).
 *
 */
public class StackOfLocalDate {
	private LocalDate[] s; // array para almacenar los elementos de la pila
	private int n; // cantidad de elementos en la pila

	public StackOfLocalDate(int capacity) {
		s = new LocalDate[capacity];
		n = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * Devuelve el elemento en la cima de la pila o null si la pila está vacía.
	 */
	public LocalDate peek() {
		return isEmpty() ? null : s[n - 1];
	}

	/**
	 * Retira y devuelve el elemento en la cima de la pila.
	 * 
	 * PRECONDICIÓN: la pila no está vacía
	 */
	public LocalDate pop() {
		n = n - 1;
		return s[n];
	}

	/**
	 * PRECONDICIÓN: la pila no está llena
	 */
	public void push(LocalDate item) {
		s[n] = item;
		n = n + 1;
	}

	public int size() {
		return n;
	}
}
