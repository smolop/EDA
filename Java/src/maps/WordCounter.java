package maps;

/**
 * Las instancias de esta clase representan "aplicaciones" en las cuales las
 * claves son instancias de tipo "String" y los valores son instancias de tipo
 * "int".
 */
public class WordCounter {
	private static final Integer UNO = 1;

	private ToyHashMap<String, Integer> map;

	// private StackOfT<String> words = new StackOfT<>();

	public WordCounter(int capacity) {
		assert capacity > 0;
		map = new ToyHashMap<>(capacity);
	}

	/**
	 * Si la palabra ya tenía asociado un entero n, se sustituye ese entero por
	 * n+1; si no, se añade el par (word, 1)
	 * 
	 * @param word
	 */
	public void count(String word) {
		assert word != null;
		Integer n = map.get(word);
		if (n == null) {
			map.put(word, UNO);
			// words.push(word);
		} else {
			Integer n1 = Integer.valueOf(n + 1);
			map.put(word, n1);
		}
	}

	/**
	 * Devuelve una array con todas las claves de este Map.
	 */
	public String[] getAllKeys() {
		Object[] v = map.getAllKeys();
		String[] w = new String[v.length];
		System.arraycopy(v, 0, w, 0, v.length);
		return w;
	}

	/**
	 * Se imprime la palabra y el entero asociado a cada palabra, empezando por
	 * la última palabra añadida, en orden inverso al orden en el cual fueron
	 * añadidas.
	 */
	// public void printInfo() {
	// // StackOfT<String> clone = words;
	// // IMPORTANTE: sin imp.
	// // clone = words.clone();
	//
	// // MEJORABLE
	// while (!words.isEmpty()) {
	// String word = words.pop();
	// Integer n = map.get(word);
	// assert n != null;
	//
	// System.out.println(word + " >> " + n);
	// }
	// }

	public int size() {
		return map.size();
	}

}
