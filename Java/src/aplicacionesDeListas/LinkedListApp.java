package aplicacionesDeListas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ListIterator;
import java.util.Scanner;

import ehu.eda.list.linkedImp.IterableDoubleLinkedList;

public class LinkedListApp {

	public static void retiraParesIncorrecto(IterableDoubleLinkedList<Integer> lista) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) % 2 == 0) {
				lista.remove(i);
			}
		}
	}

	public static void retiraPares(IterableDoubleLinkedList<Integer> lista) {
		int i = 0;
		while (i < lista.size()) {
			if (lista.get(i) % 2 == 0) {
				lista.remove(i);
			} else {
				i++;
			}
		}
	}

	public static void retiraParesConIterador(IterableDoubleLinkedList<Integer> lista) {
		ListIterator<Integer> iter = lista.listIterator();
		while (iter.hasNext()) {
			if (iter.next() % 2 == 0) {
				iter.remove();
			}
		}
	}

	public static void main(String[] args) {

		try {
			Scanner input = new Scanner(new File("src/aplicacionesDeListas/datosInt.txt"));
			int n = input.nextInt(); // número de elementos a considerar
			IterableDoubleLinkedList<Integer> miLista = new IterableDoubleLinkedList<Integer>();
			for (int i = 1; i <= n; i++) {
				miLista.addLast(input.nextInt());
			}
			input.close();

			// IMPRIME LOS ELEMENTOS DE LA LISTA usando get(i)
			for (int i = 0; i < miLista.size(); i++) {
				System.out.println(miLista.get(i));
			}

			/*
			 * AQUÍ HAY QUE INCLUIR CÓDIGO PARA RETIRAR LOS NÚMEROS PARES DE miLista.
			 * Experimentar con dos versiones: una que use directamente los métodos de la
			 * clase y otra que use un iterador.
			 */

			retiraParesIncorrecto(miLista);
			retiraPares(miLista);
			retiraParesConIterador(miLista);

			PrintWriter resultado = new PrintWriter(new File("src/aplicacionesDeListas/resultInt.txt"));
			ListIterator<Integer> scan = miLista.listIterator();
			while (scan.hasNext()) {
				resultado.println(scan.next());
			}
			resultado.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
