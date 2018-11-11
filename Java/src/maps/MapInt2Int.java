package maps;

import java.util.NoSuchElementException;

/**
 * Las instancias de esta clase representan "aplicaciones de Z en Z". Los
 * valores de las claves están limitados al intervalo establecido en la
 * constructora.
 * 
 * Todas las operaciones tienen tiempo de ejecución en O(1).
 */

public class MapInt2Int {

	private int rangeMin;
	/*
	 * keys[i] = true <=> hay un par con clave = rangeMin + i y valor =
	 * values[rangeMin + i]
	 */
	private boolean[] keys;
	private int[] values;

	public MapInt2Int(int rangeMin, int rangeMax) {
		this.rangeMin = rangeMin;
		keys = new boolean[rangeMax - rangeMin + 1];
		values = new int[rangeMax - rangeMin + 1];
	}

	/**
	 * Devuelve true si hay un par en el conjunto con la clave especificada.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             si key no est� dentro del rango permitido
	 */
	public boolean containsKey(int key) {
		return keys[key - rangeMin];
	}

	/**
	 * Returns the value to which the specified key is mapped.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             si key no está dentro del rango permitido
	 * @throws NoSuchElementException
	 *             si no hay un par con clave igual a "key"
	 */
	public int get(int key) {
		if (!keys[key - rangeMin]) {
			throw new NoSuchElementException();
		}
		return values[key - rangeMin];
	}

	/**
	 * Associates the specified value with the specified key in this map. If the map
	 * previously contained a mapping for the key, the old value is replaced by the
	 * specified value.
	 * 
	 * Se añade un par (key, value) al conjunto. Si había un par con clave igual a
	 * key, se cambia la segunda componente del par (el valor) por value.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             si key no está dentro del rango permitido
	 */
	public void put(int key, int value) {
		keys[key - rangeMin] = true;
		values[key - rangeMin] = value;
	}

	/**
	 * Removes the entry for the specified key only if it is currently mapped to the
	 * specified value.
	 * 
	 * Se retira del conjunto el par cuya clave sea igual "key".
	 * 
	 * @return true si se retira un par; false, en caso contrario.
	 * @throws IndexOutOfBoundsException
	 *             si key no está dentro del rango permitido
	 */
	public boolean remove(int key) {
		boolean old = keys[key - rangeMin];
		keys[key - rangeMin] = false;
		return old;
	}
}
