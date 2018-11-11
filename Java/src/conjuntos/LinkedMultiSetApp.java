package conjuntos;

public class LinkedMultiSetApp {

	/**
	 * Para probar la clase LinkedMultiSet<T>: implementación de conjunto con
	 * estructura enlazada LinearNode<T>
	 */
	public static void main(String[] args) {

		LinkedMultiSet<String> miSet = new LinkedMultiSet<String>();
		// IterableLinkedMultiSet<String> miSet = new
		// IterableLinkedMultiSet<String>();

		// añadimos 12 elementos al multiconjunto
		miSet.add("Simpson, Homer");
		miSet.add("Simpson, Maggie");
		miSet.add("Simpson, Bart");
		miSet.add("Simpson, Lisa");
		miSet.add("Simpson, Marge");
		miSet.add("Skinner, Seymour");
		miSet.add("Burns, Monty");
		miSet.add("Van Houten, Milhouse");
		miSet.add("Muntz, Nelson");
		miSet.add("Smithers, Wylon");
		miSet.add("Skinner, Seymour");
		miSet.add("Simpson, Bart");
		System.out.print(miSet.toString());

		String searchElem = "Skinner, Seymour";
		if (miSet.contains(searchElem)) {
			miSet.remove(searchElem); // se retira Skinner de miSet
			System.out.println("Se retira " + searchElem);
		} else {
			System.out.println("Error: Skinner debería estar");
		}
		System.out.println("El cardinal de miSet es: " + miSet.size());
		System.out.print(miSet.toString());

		String elem = "Szyslak, Moe"; // para buscarlo
		if (miSet.contains(elem)) {
			System.out.println("Error: Moe no debería estar");
		} else {
			miSet.remove(elem); // se intenta retirar a Moe de miSet
		}
		System.out.println("El cardinal de miSet es: " + miSet.size());
		System.out.print(miSet.toString());

		String elegida = miSet.removeRandom(); // retiramos al azar un elemento
		System.out.println("Se retira " + elegida);
		LinkedMultiSet<String> otroSet = new LinkedMultiSet<String>();
		// IterableLinkedMultiSet<String> otroSet = new
		// IterableLinkedMultiSet<String>();
		otroSet.add(elegida);
		System.out.println("El cardinal de miSet es: " + miSet.size()
				+ " debe ser 10. " + "Y el cardinal de otroSet es: "
				+ otroSet.size() + " debe ser 1");
		System.out.print(miSet.toString());

		if (miSet.equals(otroSet)) {
			System.out.println("Error: no deberían ser iguales");
		} else {
			otroSet.addAll(miSet);
		}
		System.out.println("El cardinal de miSet es: " + miSet.size()
				+ " y debe ser 10. " + "Y el cardinal de otroSet es: "
				+ otroSet.size() + " y debe ser 11");
		System.out.print(otroSet.toString());
		System.out.print("Deberían haber aparecido 11 nombres");

	}// end main

}// end LinkedMultiSetApp
