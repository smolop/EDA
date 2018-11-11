package aplicacionesDePilas;

import java.util.Scanner;

public class BracketsApp {

	public static void main(String[] args) {
		String input;
		while (true) {
			System.out.print("Enter string containing delimiters: ");
			System.out.flush();
			input = getString(); // read a string from keyboard
			if (input.equals("")) {
				break;
			}
			// make a BracketChecker
			BracketCheckerPrim theChecker = new BracketCheckerPrim(input);
			theChecker.check(); // check brackets
		} // end while
	} // end main()

	// --------------------------------------------------------------

	public static String getString() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		return s;
	}
	// --------------------------------------------------------------
} // end class BracketsApp
