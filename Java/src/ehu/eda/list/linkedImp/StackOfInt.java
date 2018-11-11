package ehu.eda.list.linkedImp;

/**
 * Una implementación simple de PILAs (colas LIFO), usando una lista ligada
 * (linked-list).
 * 
 * En esta implementación, las pilas tienen capacidad limitada solo por la
 * memoria disponible.
 * 
 * Todas las operaciones tienen tiempo de ejecucion en Theta(1) (tiempo
 * constante: independiente de la entrada y del tamaño de la pila).
 *
 */
public class StackOfInt {

	private Node first; // es el nodo con la cima de la pila, o null si la pila está vacía
	private int n; // número de elementos en la pila

	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Devuelve el elemento en la cima de la pila.
	 * 
	 * PRECONDICIÓN: la pila no está vacía
	 */
	public int peek() {
		return first.item;
	}

	/**
	 * Retira y devuelve el elemento en la cima de la pila.
	 * 
	 * PRECONDICIÓN: la pila no está vacía
	 */
	public int pop() {
		int item = first.item;
		first = first.next;
		n--;
		return item;
	}

	public void push(int item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		n++;
	}

	/**
	 * Devuelve la cantidad de elememtos en la pila.
	 */
	public int size() {
		return n;
	}

	/*
	 * Una clase "static" dentro de otra es como cualquier otra clase. Pero, si
	 * además es "private", no puede usarse fuera de aquí.
	 * 
	 * Así, los detalles de la implementación quedan totalmente ocultados a los
	 * clientes.
	 */
	private static class Node {
		int item;
		Node next;
	}
}
