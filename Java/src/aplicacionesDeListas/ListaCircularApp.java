package aplicacionesDeListas;

public class ListaCircularApp {

	public static void main(String args[]) {
		ListaCircular<Integer> corro = new ListaCircular<Integer>();
		int numElementos = 10;
		int numConteo = 2;
		int numInicio = 10;

		for (int i = 1; i <= numElementos; i++) {
			corro.insertar(new Integer(i));
		}

		if (corro.contains(numInicio)) {
			while (corro.size() > 1) {
				System.out.println(corro.removeSiguiente(numConteo));
				System.out.println(corro.toString());
				System.out.println("-----------");
			}
		}

		System.out.print("El elemento que queda es: " + corro.toString());
	}
}
