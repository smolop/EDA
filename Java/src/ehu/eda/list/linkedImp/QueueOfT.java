package ehu.eda.list.linkedImp;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


/**
 * Una implementación simple de COLAs (colas FIFO), usando una lista ligada
 * (linked-list).
 * 
 * En esta implementación, las colas tienen capacidad limitada solo por la
 * memoria disponible.
 * 
 * Todas las operaciones tienen tiempo de ejecucion en Theta(1) (tiempo
 * constante: independiente de la entrada y del tama�o de la cola).
 *
 * Esta es una clase "genérica".
 */
public class QueueOfT<T> {
	/*
	 * T: tipo de elementos almacenados en la cola (parámetro de la clase
	 * genérica).
	 */
	private Node<T> first; // el primer nodo de la cola
	private Node<T> last; // es el último nodo de la cola
	private int n; // número de elementos en la cola

	/**
	 * Retira y devuelve el primer elemento en la cola.
	 * 
	 * PRECONDICIÓN: la cola no está vacía
	 */
	public T dequeue() {
		assert first != null; // la expresión booleana debería ser true

		T item = first.item;
		first = first.next;
		n--;
		return item;
	}

	/*
	 * Pone a item al final de la cola
	 */
	public void enqueue(T item) {
		Node<T> newNode = new Node<>();
		newNode.item = item;
		if (first == null) {
			first = newNode;
		} else {
			last.next = newNode;
		}
		last = newNode;
		n++;
	}

	public boolean isEmpty() {
		return first == null;
	}

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
	private static class Node<T> {
		T item;
		Node<T> next;
	}

	public Iterator<Integer> queueIterator() {
		
		return null;
	}
	
	private class Iter<E> implements Iterator<E> {

		private Node<T> lastReturned;
		private Node<T> next;
		private int nextIndex;
		
		Iter() {
			next =  first;
			nextIndex = 0;
		}
		
		@Override
		public boolean hasNext() {
			return nextIndex < n;
		}

		@Override
		public E next() {
			if(!hasNext())
				throw new NoSuchElementException();
			
			lastReturned =  next;
			updateNext();
			increase();
			return (E) lastReturned;
		}

		private void updateNext() {
			next = next.next;
		}

		private void increase() {
			nextIndex++;
		}
		
	}
	
}
