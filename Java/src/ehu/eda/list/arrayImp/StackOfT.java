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
 * Esta es una clase "genérica". Revisar StackOfStrings y StackOfLocalDate, y
 * comprobar que las dos clases son casi idénticas. Con esta clase se evita la
 * necesidad de definir esas clases haciendo "cut&paste".
 */
public class StackOfT<T> {
	private Object[] s; // array para almacenar los elementos de la pila
	private int n; // cantidad de elementos en la pila

	public StackOfT(int capacity) {
		s = new Object[capacity]; // Se crea un array para albergar hasta "capacity" elementos
		n = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * Devuelve el elemento en la cima de la pila o null si la pila está vacía.
	 */
	public T peek() {
		T o = isEmpty() ? null : (T) s[n - 1];
		return o;
	}

	/**
	 * Retira y devuelve el elemento en la cima de la pila.
	 * 
	 * PRECONDICIÓN: la pila no está vacía
	 */
	public T pop() {
		n = n - 1;
		Object o = s[n];
		T e = (T) o;
		/*
		 * "casting" o es de tipo Object, e es de tipo T Error ClassCastException en
		 * ejecución si el objeto o no es instancia de T.
		 */
		return e;
	}

	/**
	 * PRECONDICIÓN: la pila no está llena
	 */
	public void push(T item) {
		s[n] = item;
		n = n + 1;
	}

	public int size() {
		return n;
	}
}
