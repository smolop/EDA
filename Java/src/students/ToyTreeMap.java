package students;

import java.util.Comparator;

public class ToyTreeMap<Key, Value> {

	private BinaryNode<Key, Value> root;

	private int size;

	private final java.util.Comparator<? super Key> keyComparator;

	/*
	 * Metodos implementados
	 */
	public static void main(String[] args) {

		// Se asignan los valores a los nodos = 1,2,3,4,5 y 6 dentro del arbol
		// Nodo raiz = 1
		Comparator comp = new comparadorInteger();
		ToyTreeMap<Integer, Integer> raiz = new ToyTreeMap<Integer, Integer>(comp);

		// BinaryNode2 Izquierdo = 2
		ToyTreeMap<Integer, Integer> nodo2 = new ToyTreeMap<Integer, Integer>(comp);

		// BinaryNode3 Derecho = 3
		ToyTreeMap<Integer, Integer> nodo3 = new ToyTreeMap<Integer, Integer>(comp);
		System.out.println("Prueba 0: " + (raiz.put(0, 0) == null ? "Nuevo valor, antes era null" : 0));
		// Se asigna el valor 6 al nodo que sera hijo del nodo 3 a la derecha
		int var = 0;
		System.out.println("Prueba 0: " + (var = raiz.put(0, 1)) == null ? Integer.MIN_VALUE : var);

		nodo3.put(10, 1);

		// Se asigna el valor 5 al nodo que sera hijo del nodo 3 a la izquierda
		nodo2.put(20, 2);

	}

	private void InOrden(BinaryNode pivote) {
		if (pivote != null) {
			InOrden(pivote.left);
			System.out.printf((String) pivote.key, (String) pivote.value, "\n");
			InOrden(pivote.rigth);
		}
	}

	public Value put(Key key, Value value) {
		if (key == null) {
			throw new java.lang.NullPointerException();
		}
		BinaryNode<Key, Value> pivote = root;

		while (pivote != null) {
			int resultadoCompare = myCompare(root.key, key);

			if (resultadoCompare < 0) {
				if (pivote.left != null) {
					pivote = pivote.left;
				} else {
					BinaryNode hoja = new BinaryNode<Key, Value>(null, key, value, null);
					pivote.left = hoja;
				}

			} else if (resultadoCompare > 0) {
				if (pivote.rigth != null) {
					pivote = pivote.rigth;
				} else {
					BinaryNode hoja = new BinaryNode<Key, Value>(null, key, value, null);
					pivote.rigth = hoja;
				}

			} else {
				if (pivote.value == null) {
					throw new java.lang.IllegalArgumentException();
				} else {
					pivote.value = value;
				}
			}
		}
		return null;
	}

	public Value get(Key key) {
		if (key == null) {
			throw new java.lang.NullPointerException();
		}
		BinaryNode<Key, Value> pivote = root;

		while (pivote != null) {
			int resultadoCompare = myCompare(root.key, key);

			if (resultadoCompare < 0) {
				pivote = pivote.left;
			} else if (resultadoCompare > 0) {
				pivote = pivote.rigth;
			} else {
				return pivote.value;
			}
		}
		return null;
	}

	public int size() {
		return size;
	}

	public void clear() {
		root = null;
		size = 0;
	}

	public void printLexicographically() {
		if (root != null) {
			InOrden(root);
		}
	}

	public ToyTreeMap(java.util.Comparator<? super Key> comparador) {
		root = null;
		keyComparator = comparador;
	}

	private int myCompare(Key key1, Key key2) {
		if (keyComparator != null)
			return keyComparator.compare(key1, key2);
		return (Integer) null;
	}

	private static class BinaryNode<Key, Value> {
		Key key;
		Value value;

		BinaryNode<Key, Value> left;
		BinaryNode<Key, Value> rigth;

		BinaryNode(BinaryNode<Key, Value> lf, Key theElement, Value theValue, BinaryNode<Key, Value> rt) {
			this.key = theElement;
			this.value = theValue;
			this.left = lf;
			this.rigth = rt;
		}

	}
}
