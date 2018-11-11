package ehu.eda.list.arrayImp;

/**
 * Una implementación simple de PILAs (listas LIFO), usando un array.
 * 
 * En esta implementación, la capacidad de una pila solo está limitada por la
 * memoria disponible. Es decir, esa capacidad no se fija en la constructora
 * (como se hace en StackOfT<>), y se pueden añadir tantos elementos a la pila
 * como se desee.
 * 
 * "pop", "size", "isEmpty" tienen tiempo de ejecucion en Theta(1) (tiempo
 * constante: independiente de la entrada y del tamaño de la pila).
 *
 * La implementación es casi igual que en StackOfT<>. Pero cuando se añade un
 * elemento a la pila, y el array subyacente está lleno, ese array se cambia por
 * otro más grande. También hay que copiar el contenido del array original en el
 * nuevo.
 * 
 * "push" y "pop" tienen, EN EL PEOR CASO, tiempo de ejecucion en Theta(n),
 * siendo "n" el número de elementos de la pila. Pero puede demostrarse que ese
 * tiempo "puede repartirse" entre el resto de métodos que se realizan sobre el
 * objeto pila, de manera que el efecto final es como si cada método hubiera
 * gastado una cantidad constante de tiempo.
 * 
 */
public class StackOfTResizable<T> {

	private Object[] s;
	private int n; // cantidad de elementos en la pila

	public StackOfTResizable() {
		s = new Object[2];
		n = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * Devuelve el elemento en la cima de la pila o null si la pila está vacía.
	 */
	public T peek() {
		return isEmpty() ? null : (T) s[n - 1];
	}

	/**
	 * Retira y devuelve el elemento en la cima de la pila.
	 * 
	 * PRECONDICIÓN: la pila no está vacía
	 */
	public T pop() {
		T item = (T) s[n - 1]; // "casting": los elementos de la cola deben ser instancias de T.
		s[n - 1] = null; // Para evitar malgastar espacio (loitering)
		n = n - 1;
		// Disminuir el tamaño del array si es necesario
		if (n > 0 && n == s.length / 4) {
			resize(s.length / 2);
		}
		return item;
	}

	public void push(T item) {
		if (n == s.length) {
			// La cola está llena: reemplazar el array por uno más grande
			resize(2 * s.length);
		}
		s[n] = item;
		n = n + 1;
	}

	private void resize(int capacity) {
		Object[] temp = s;
		Object[] s = new Object[capacity];
		for (int i = 0; i < n; i++) {
			s[i] = temp[i];
		}
	}

	public int size() {
		return n;
	}
}
