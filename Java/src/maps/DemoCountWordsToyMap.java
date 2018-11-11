package maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Una demo para WordCounter.
 */
public class DemoCountWordsToyMap {

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File(
					"src/maps/datosStringRandom.txt"));
			int n = input.nextInt(); // número de elementos a considerar

			WordCounter map = new WordCounter(nextPrimo(n / 2));
			processInput(input, map);
			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static int nextPrimo(int num) {
		int i = num;
		while (!primo(i)) {
			i++;
		}
		return i;
	}

	private static boolean primo(int p) {
		if (p == 1) {
			return false;
		} else {
			for (int i = 2; i < p; i++) {
				if (p % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

	static void processInput(Scanner input, WordCounter map) {
		long t0 = System.currentTimeMillis();

		int totalWords = 0;
		while (input.hasNext()) {
			map.count(input.next());
			totalWords = totalWords + 1;
		}

		long tf = System.currentTimeMillis();

		int wordCount = map.size();
		System.out.println("Palabras distintas: " + wordCount);
		System.out.println("Total palabras: " + totalWords);
		System.out.println(tf - t0 + " milisegundos.");
	}
}