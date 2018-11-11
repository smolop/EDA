package aplicacionesDeListas;

public class ListaCircular<T> {
	private Nodo<T> current;
	private int n;

	private static class Nodo<T> {
		public T data;
		public Nodo<T> next;

		public Nodo(T element) {
			data = element;
		}
	}

	public ListaCircular() {
		current = null;
		n = 0;
	}

	/**
	 * Devuelve true si existe al menos un elemento en la lista.
	 */
	private boolean isEmpty() {
		return current == null;
	}

	public int size() {
		return n;
	}

	/**
	 * Método para insertar nuevo nodo a la lista circular. Se inserta a
	 * continuación de current. Al finalizar, current referencia al nodo
	 * insertado.
	 */
	public void insertar(T element) {
		Nodo<T> newNode = new Nodo<T>(element);

		if (isEmpty()) {
			newNode.next = newNode;
		} else {
			newNode.next = current.next;
			current.next = newNode;
		}
		current = newNode;
		n++;
	}

	/**
	 * Elimina el nodo siguiente al apuntado por current, devuelve el elemento
	 * que contenía ese nodo, y current queda donde esta estaba. Si no quedan
	 * nodos, current será null. Si, inicialmente, la lista está vacía, devuelve
	 * null.
	 */
	public T remove() {
		if (this.isEmpty()) {
			return null;
		} else {
			Nodo<T> retirar = current.next;
			T result = retirar.data;
			if (retirar == current) {
				current = null;
			} else {
				current.next = retirar.next;
			}
			n--;
			return result;
		}
	}

	/**
	 * Elimina, de una lista circular, el siguiente nodo según un conteo
	 * establecido: Si numConteo==1, el primero después de current. Si
	 * numConteo==2, el segundo después de current, y así sucesivamente.
	 * Devuelve el elemento del nodo eliminado. Current queda situado en el
	 * anterior nodo al eliminado. Precondición: numConteo > 0
	 */
	public T removeSiguiente(int numConteo) {
		for (int i = 1; i < numConteo; i++) {
			this.step();
		}
		T result = remove();
		return result;
	}

	/**
	 * Devuelve true si element se encuentra en la lista; y, en tal caso,
	 * current apunta al nodo en que se encuentra.
	 * 
	 * Devuelve false si element no está en la lista; y, en tal caso, current
	 * sigue apuntando al nodo al que apuntaba antes de la llamada.
	 */
	public boolean contains(T element) {
		Nodo<T> inicio = current;
		if (this.isEmpty()) {
			return false;
		} else {
			while (!current.data.equals(element) && current.next != inicio) {
				step();
			}
			if (current.data.equals(element)) {
				return true;
			} else {
				step();
				return false;
			}
		}
	}

	/**
	 * Elimina elem de la lista, si está. En tal caso, devuelve true y deja
	 * current apuntando al nodo anterior. Si elem no está en la lista, devuelve
	 * falso y deja current donde estaba al inicio.
	 */
	public boolean remove(T elem) {
		Nodo<T> inicio = current;
		if (this.isEmpty()) {
			return false;
		} else {
			Nodo<T> retirar = current.next;
			while (!retirar.data.equals(elem) && current.next != inicio) {
				retirar = retirar.next;
				step();
			}
			if (retirar.data.equals(elem)) {
				if (this.size() > 1) {
					current.next = retirar.next;
				} else {
					current = null;
				}
				n--;
				return true;
			} else {
				step();
				return false;
			}
		}
	}

	/**
	 * Método para avanzar current, un paso, en la lista.
	 */
	private void step() {
		current = current.next;
	}

	/**
	 * Devuelve el elemento del nodo apuntado por current. Precondición: current
	 * != null
	 */
	public T getData() {
		return current.data;
	}

	/**
	 * Para visualizar los elementos de la lista.
	 */
	@Override
	public String toString() {
		String resultado = "";
		if (!isEmpty()) {
			Nodo<T> paraString = current.next;
			for (int i = 1; i <= n; i++) {
				resultado += paraString.data.toString() + " ";
				paraString = paraString.next;
			}
		} else {
			System.out.println("Lista circular vacía.");
		}

		return resultado;
	}

	public String toStringAlternativo() {
		String resultado = "";

		if (!isEmpty()) {
			Nodo<T> paraString = current.next;

			do {
				resultado += paraString.data.toString() + " ";
				paraString = paraString.next;
			} while (paraString != current);
		} else {
			System.out.println("Lista circular vacía.");
		}

		return resultado;
	}

}