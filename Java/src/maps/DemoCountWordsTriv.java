package maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ListIterator;
import java.util.Scanner;

import ehu.eda.list.linkedImp.IterableDoubleLinkedList;

/**
 * Una demo para WordCounter.
 * 
 * Se imprime la colección de palabras distintas contenidas en el archivo,
 * indicando el número de apariciones de cada una.
 * 
 */
public class DemoCountWordsTriv {
	static final String INPUT = "src/maps/datosStringNotRandom.txt";

	private static final Integer UNO = Integer.valueOf(1);

	private static class Par<Key, Value> {
		Key key;
		Value value;

		Par(Key key, Value value) {
			this.key = key;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File(INPUT));
			int n = input.nextInt(); // número de elementos a considerar

			IterableDoubleLinkedList<Par<String, Integer>> words = new IterableDoubleLinkedList();

			process(input, words);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void process(Scanner input,
			IterableDoubleLinkedList<Par<String, Integer>> words) {

		long t0 = System.currentTimeMillis();

		int totalWords = 0;
		String palabra;
		while (input.hasNext()) {
			palabra = input.next();
			totalWords++;
			ListIterator<Par<String, Integer>> it = words.listIterator();
			Par<String, Integer> par;
			boolean contada = false;
			while (it.hasNext() && !contada) {
				par = it.next();
				if (par.key.equals(palabra)) {
					par.value = par.value + 1;
					contada = true;
				}
			}
			if (!contada) {
				words.addLast(new Par<String, Integer>(palabra, UNO));
			}
		}
		long tf = System.currentTimeMillis();
		int wordCount = words.size();
		System.out.println("Palabras distintas: " + wordCount);
		System.out.println("Total palabras: " + totalWords);
		System.out.println(tf - t0 + " millis.");
		printWords(words);

	}

	static void printWords(IterableDoubleLinkedList<Par<String, Integer>> words) {
		try {
			PrintWriter output = new PrintWriter(new File(
					"src/maps/resultados.txt"));
			ListIterator<Par<String, Integer>> it = words.listIterator();
			Par<String, Integer> par;
			while (it.hasNext()) {
				par = it.next();
				output.println(par.key + " >> " + par.value);
			}
			output.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
