package ehu.eda.list.linkedImp;

public interface IStackOfT<T> {

	boolean isEmpty();

	/**
	 * Devuelve el elemento en la cima de la pila.
	 * 
	 * PRECONDICIÓN: la pila no está vacía
	 */
	T peek();

	/**
	 * Retira y devuelve el elemento en la cima de la pila.
	 * 
	 * PRECONDICIÓN: la pila no está vacía
	 */
	T pop();

	void push(T item);

	/**
	 * Devuelve la cantidad de elememtos en la pila.
	 */
	int size();

}