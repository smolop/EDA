package aplicacionesDePilas;

import ehu.eda.list.arrayImp.StackOfT;

public class BracketCheckerGen {
	private String input; // input string
	// --------------------------------------------------------------

	public BracketCheckerGen(String in) // constructor
	{
		input = in;
	}

	// --------------------------------------------------------------
	public void check() {
		int stackSize = input.length(); // get max stack size
		StackOfT<Character> theStack = new StackOfT<Character>(stackSize); // make stack

		for (int j = 0; j < input.length(); j++) // get chars in turn
		{
			char ch = input.charAt(j); // get char
			switch (ch) {
			case '{': // opening symbols
			case '[':
			case '(':
				theStack.push(ch); // push them
				break;

			case '}': // closing symbols
			case ']':
			case ')':
				if (!theStack.isEmpty()) // if stack not empty,
				{
					char chx = theStack.pop(); // pop and check
					if (ch == '}' && chx != '{' || ch == ']' && chx != '[' || ch == ')' && chx != '(') {
						System.out.println("Error: " + ch + " at " + j);
					}
				} else {
					System.out.println("Error: " + ch + " at " + j);
				}
				break;
			default: // no action on other characters
				break;
			} // end switch
		} // end for
			// at this point, all characters have been processed
		if (!theStack.isEmpty()) {
			System.out.println("Error: missing right delimiter");
		}
	} // end check()
		// --------------------------------------------------------------
} // end class BracketCheckerGen
