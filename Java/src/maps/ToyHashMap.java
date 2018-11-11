package maps;

/**
 * Las instancias de esta clase representan "aplicaciones" en las cuales las
 * claves son instancias de tipo "K" y los valores son instancias de tipo "V".
 * 
 * Esta clase es genérica: "K" y "V" son los parámetros de la clase.
 */
/*
 * Un ToyHashMap se implementa mediante un array y una función "hash". Para
 * añadir un nuevo par (clave, valor), se almacena un nuevo MapEntry, en alguna
 * de las posiciones del array. Ese objeto contiene la clave y el valor del par.
 * El índice de la posición se calcula aplicando la función "hash" a la clave
 * del par. Si las cosas rodasen a la perfección, cada clave estaría asociada a
 * una posición distinta del array. Como eso no será siempre así, en cada
 * posición del array se almacenará una lista, en la cual estarán todos los
 * pares con la misma clave.
 */
public class ToyHashMap<K, V> {
	/*
	 * entries[i] = lista con todos los pares t.q. hash(clave) = i
	 */
	private MapEntry<K, V>[] entries;
	private int size;

	@SuppressWarnings("unchecked")
	public ToyHashMap(int capacity) {
		assert capacity > 0;
		entries = new MapEntry[capacity];
	}

	/**
	 * Devuelve true si hay un par en el conjunto con la clave especificada.
	 */
	public boolean containsKey(K key) {
		assert key != null;
		int keyIndex = hash(key);
		MapEntry<K, V> e = entries[keyIndex];
		while (e != null) {
			if (e.key == key || e.key.equals(key)) {
				return true;
			}
			e = e.next;
		}
		return false;
	}

	/**
	 * Returns the value to which the specified key is mapped, or null if this map
	 * contains no mapping for the key.
	 */
	public V get(K key) {
		assert key != null;
		int keyIndex = hash(key);
		MapEntry<K, V> e = entries[keyIndex];
		while (e != null) {
			if (e.key == key || e.key.equals(key)) {
				return e.value;
			}
			e = e.next;
		}
		return null;
	}

	/**
	 * Associates the specified value with the specified key in this map. If the map
	 * previously contained a mapping for the key, the old value is replaced by the
	 * specified value.
	 * 
	 * Se añade un par (key value) al conjunto. Si había un par con clave igual a
	 * key, se cambia la segunda componente del par (el valor) por value.
	 * 
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key.
	 */
	public V put(K key, V value) {
		assert key != null;
		int keyIndex = hash(key);
		MapEntry<K, V> e = entries[keyIndex];
		while (e != null) {
			if (e.key == key || e.key.equals(key)) {
				V old = e.value;
				e.value = value;
				return old;
			}
			e = e.next;
		}
		MapEntry<K, V> newMapEntry = new MapEntry<>(key, value, entries[keyIndex]);
		entries[keyIndex] = newMapEntry;
		size++;
		return null;
	}

	/**
	 * Removes the mapping for a key from this map if it is present.
	 * 
	 * Se retira del conjunto el par cuya clave sea igual a "key".
	 * 
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key.
	 */
	public V remove(K key) {
		assert key != null;
		/*
		 * HACER.
		 */
		return null;// momentáneo, para que se pueda compilar sin error.
	}

	public int size() {
		return size;
	}

	private int hash(K key) {
		int h = key.hashCode();
		h = h % entries.length;
		if (h < 0) {
			h = h + entries.length;
		}
		return h;
	}

	
	/**
	 * Devuelve una array con todas las claves de este Map.
	 */
	public Object[] getAllKeys() {
		/*
		 * HACER
		 */
		return null; // momentáneo, para que se pueda compilar sin error.
	}

	private static class MapEntry<Key, Value> {
		Key key;
		Value value;
		MapEntry<Key, Value> next;

		MapEntry(Key key, Value value, MapEntry<Key, Value> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
}
