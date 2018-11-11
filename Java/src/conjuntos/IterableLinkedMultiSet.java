package conjuntos;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class IterableLinkedMultiSet<T> {

	private int cardinal; // número de elementos en contenido
	private LinearNode<T> contenido;

	private static Random rand = new Random();

	private static class LinearNode<T> {
		LinearNode<T> next;
		T element;

		public LinearNode(T elem) {
			next = null;
			element = elem;
		}
	}

	public IterableLinkedMultiSet() {
		cardinal = 0;
		contenido = null;
	}

	public boolean isEmpty() {
		return cardinal == 0;
	}

	public void add(T elem) {
		LinearNode<T> newElem = new LinearNode<T>(elem);
		newElem.next = contenido;
		contenido = newElem;
		cardinal++;
	}

	public Iterator<T> iterator() {
		return new LinkedIterator();
	}

	public void addAll(IterableLinkedMultiSet<T> mset) {
		Iterator<T> scanSet = mset.iterator();
		while (scanSet.hasNext()) {
			this.add(scanSet.next());
		}
	}

	public boolean contains(T target) {
		Iterator<T> scan = this.iterator();
		while (scan.hasNext()) {
			if (scan.next().equals(target)) {
				return true;
			}
		}
		return false;
	}

	// Precondición: Hay algún elemento en el conjunto
	public T removeRandom() {
		assert !this.isEmpty(); // cardinal != 0

		T result = null;

		int choice = rand.nextInt(cardinal) + 1; // entero entre 1 y cardinal

		if (choice == 1) { // retira el primer elemento
			result = contenido.element;
			contenido = contenido.next;
		} else {
			LinearNode<T> previo = contenido;
			for (int i = 2; i < choice; i++) {
				previo = previo.next;
			}
			LinearNode<T> sigPrevio = previo.next;
			result = sigPrevio.element;
			previo.next = sigPrevio.next;
		}
		cardinal--;

		return result;
	}

	// Retira y devuelve una aparición de elem en contenido.
	// Si tal elem no aparece en contenido, devuelve null.
	public T remove(T elem) {
		LinearNode<T> previo = null;
		LinearNode<T> sigPrevio = contenido;
		while (sigPrevio != null && !sigPrevio.element.equals(elem)) {
			previo = sigPrevio;
			sigPrevio = sigPrevio.next;
		}
		if (sigPrevio == null) {
			return null;
		} else {
			previo.next = sigPrevio.next;
			cardinal--;
			return sigPrevio.element;
		}
	}

	public int size() {
		return cardinal;
	}

	/*
	 * Devuelve true si this y mset tienen la misma colección de elementos y
	 * cada elemento repetido el mismo número de veces. En caso contrario,
	 * devuelve false.
	 */
	public boolean equals(LinkedMultiSet<T> set) {
		// HACER
		return false; // para evitar, de momento, problemas de compilación
	}

	@Override
	public String toString() {
		String result = "";
		Iterator<T> scanThis = this.iterator();
		while (scanThis.hasNext()) {
			result = result + scanThis.next().toString() + "\n";
		}
		return result;
	}

	private class LinkedIterator implements Iterator<T> {

		private LinearNode<T> current; // la posición actual

		// Inicializa un iterador para recorrer contenido
		public LinkedIterator() {
			current = contenido;
		}

		// Devuelve true si la colección tiene al menos un elemento más,
		// que todavía no ha sido visitado
		@Override
		public boolean hasNext() {
			return current != null;
		}

		// Devuelve el siguiente elemento de la colección, según el recorrido.
		// Se supone que hay elemento siguiente.
		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T result = current.element;
			current = current.next;
			return result;
		}

		// La operación de eliminación no está soportada
		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
	}
}
