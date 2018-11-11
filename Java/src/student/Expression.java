package student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Stack;

import ehu.eda.list.linkedImp.AgendaDeTareas.Node;

/**
 * 
 * @author smolop
 *
 */

/*
 * Las instancias de Expression son expresiones aritmeeticas con los operadores
 * +, -, *, /.
 */
public class Expression {
	// Las expresiones se representan mediante aarboles binarios.
	private BinaryNode root;

	// root es siempre null.

	public Expression(BinaryNode node) {
		root = node;
	}

	/*
	 * Incluir aquii los meetodos implementados.
	 */

	public int altura() {
		return altura(root);
	}

	// Devuelve el número de hojas del árbol correspondiente a esta expresión.
	int contarHojas() {
		return contarHojas(root);
	}

//	Devuelve el número de nodos internos del árbol correspondiente a esta expresión.
	public int contarInternos() {
		return contarInternos(root);
	}

	public void preOrden() {
		System.out.println("|| PreOrden: ||");
		preOrden(root, 0);
	}

	public void inOrden() {
		System.out.println("|| InOrden: ||");
		inOrden(root, 0);
	}

	public void postOrden() {
		System.out.println("|| PostOrden:||");
		postOrden(root, 0);
	}

	// Devuelve el resultado de evaluar esta Expresion.
	public double eval() {
		if (root == null)
			return 0;
		return eval(root);
	}

	/**
	 * Imprime una representación textual del árbol correspondiente a esta
	 * expresión. Cada elemento aparece en una línea. El elemento raíz en la
	 * primera columna, sus dos hijos en la columna 8, sus nietos en la 16, y así
	 * sucesivamente.
	 */
	public void prettyPrint() {
		prettyPrint(root, 0);
	}

	// Devuelve true si esta expresión es una subexpresión de other.
	public boolean isPartOf(Expression other) {
		return isPartOf(root, other);
	}

	// In-Situ "Class"
	public void printByLevel() {
		LinkedList<BinaryNode> list = new LinkedList<BinaryNode>();
		LinkedList<BinaryNode> hijos = new LinkedList<BinaryNode>();
		list.add(root);
		while (!list.isEmpty())
			for (BinaryNode n : list) {
				System.out.println(n.element);
				if (n.left != null)
					hijos.add(n.left);
				if (n.right != null)
					hijos.add(n.right);
			}
		list.clear();
		LinkedList<BinaryNode> viejaLista = list;
		list = hijos;
		hijos = viejaLista;
	}

	// ---------------------||Printers||-------------------------//

	public void printAltura() {
		System.out.println("La altura del aarbol es: " + this.altura());
	}

	public void printContarHojas() {
		System.out.println("El aarbol contiene: " + this.contarHojas() + " hojas. ");
	}

	public void printContarInternos() {
		System.out.println("El aarbol contiene " + this.contarInternos() + " nodos internos");
	}

	public void printEval() {
		System.out.println("El valor de  evaluar la expresion es: " + this.eval());
	}

	public void printIsPartOf(Expression other) {
		System.out.println(
				"La expresioon dada : " + (isPartOf(other) ? " SI " : " NO ") + " es parte de esta expresioon.");
	}

	public void execAll() {
		printAltura();
		// preOrden();
		inOrden();
		// postOrden();
		printContarHojas();
		printContarInternos();
		printEval();
		prettyPrint();
	}

	// ---------------------||PRIVATE ZONE||--------------------------//
	/*
	 * In-Situ "Class" Incluir aquii los metodos implementados
	 */
	private int altura(BinaryNode root) {
		if (root == null)
			return 0;
		int h1 = altura(root.left);
		int h2 = altura(root.right);
		return (h1 > h1 ? h1 : h2) + 1;
	}

	private int contarHojas(BinaryNode node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		return contarHojas(node.left) + contarHojas(node.right);
	}

	private int contarInternos(BinaryNode node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 0;
		return contarInternos(node.left) + contarInternos(node.right) + (node == root ? 0 : 1);
	}

	/*
	 * In-Situ "Class" Enumera los nodos del aarbol con raiz r, e
	 */
	private void preOrden(BinaryNode node, int level) {
		if (node == null)
			return;
		System.out.println(drawStem(level) + node.element);
		preOrden(node.left, level + 1);
		preOrden(node.right, level + 1);
	}

	private void inOrden(BinaryNode node, int level) {
		if (node == null)
			return;
		inOrden(node.left, level + 1);
		System.out.println(drawStem(level) + node.element);
		inOrden(node.right, level + 1);
	}

	private void postOrden(BinaryNode node, int level) {
		if (node == null)
			return;
		inOrden(node.left, level + 1);
		inOrden(node.right, level + 1);
		System.out.println(drawStem(level) + node.element);
	}

	private double eval(BinaryNode node) {
		if (node.left == null && node.right == null)
			return (Integer) node.element;
		double result = 0;
		double val1 = eval(node.left);
		double val2 = eval(node.right);

		if (isOpItem((Character) node.element))
			switch ((Character) node.element) {
			case '+':
				result = val1 + val2;
				break;
			case '-':
				result = val1 - val2;
				break;
			case '*':
				result = val1 * val2;
				break;
			case '/':
				result = val1 / val2;
				break;
			default:
				break;
			}
		return result;
	}

	private static boolean isOpItem(Character c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	private void prettyPrint(BinaryNode node, int lvl) {
		if (node == null)
			return;
		prettyPrint(node.left, lvl + 1);
		System.out.println(tabByLvl(lvl) + node.element);
		prettyPrint(node.right, lvl + 1);
	}

	private boolean isPartOf(BinaryNode node, Expression other) {
		if (node == null)
			return false;
		if (node.element == other.root.element)
			if (isPartOf(node, other.root))
				return true;
		if (isPartOf(node.left, other))
			return true;
		if (isPartOf(node.right, other))
			return true;
		return false;
	}

	private boolean isPartOf(BinaryNode selfNode, BinaryNode otherNode) {
		if (otherNode == null)
			return true;
		if (selfNode.element == otherNode.element)
			return (isPartOf(selfNode.left, otherNode.left) && isPartOf(selfNode.right, otherNode.right));
		return false;
	}

	private String drawStem(int level) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < level; i++)
			s.append(" ");
		s.append("|");
		for (int i = 0; i < level; i++)
			s.append("-");
		return s.toString();
	}

	private String tabByLvl(int level) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < level; i++)
			s.append("\t");
		return s.toString();
	}

	// TODO

	/*
	 * meetodos factoriia: anhadir otros que se consideren razonables.
	 */

	public static Expression mkBinary(char operador, Expression a, Expression b) {
		return new Expression(new BinaryNode(a.root, Character.valueOf(operador), b.root));
	}

	public static Expression mkSimple(int v) {
		return new Expression(new BinaryNode(Integer.valueOf(v)));
	}

	private static class BinaryNode {
		Object element;
		private BinaryNode left;
		private BinaryNode right;

		BinaryNode(BinaryNode left, Object element, BinaryNode right) {
			this.left = left;
			this.element = element;
			this.right = right;
		}

		BinaryNode(Object element) {
			this.element = element;// Por defecto, left, right = null!!!
		}

		Object getElement() {
			return element;
		}

	}

	// Devuelve una Expresion cuya representación textual en notación post-fija es
	// text.
	// @Precondición: text es el texto de la representación post-fija de una
	// expresión.
	public static Expression valueOf(String text) {
		System.out.println("Start: valueOF " + text);
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (Character.isWhitespace(c))
				while (i < text.length() && Character.isWhitespace(c)) {
					i++;
					c = text.charAt(i);
				}
			if (isOpItem(c)) {
				BinaryNode Left = stack.pop();
				BinaryNode Right = stack.pop();
				stack.push(new BinaryNode(Left, c, Right));
				System.out.println("Es un operador: " + c);
			} else {
				StringBuilder s = new StringBuilder();
				while (i < text.length() && !Character.isWhitespace(c)) {
					s.append(c);
					i++;
					c = text.charAt(i);
				}
				if (s.length() > 0) {
					System.out.println("No es un operador: |" + Integer.valueOf(s.toString()) + "|");
					stack.add(new BinaryNode(null, Integer.valueOf(s.toString()), null));
				}
			}
		}
		Expression newExpr = new Expression(stack.pop());
		System.out.println("STACK SIZE: " + stack.size());
		return newExpr;
	}

	// --------------------||EXECUTE ZONE||----------------------//

	public static void main(String[] args) {
		runSimpleExpresion(5);
		runBinaryExpression('+', 4, 5);
		runComplexExpression();
		runComplexExpression2();
		runCustomExpression("53 47 +");
		runCustomExpression("53 47 + 3 *");
		runCustomExpression("53 47 + 3 3 * *");
		
	}

	private static void runCustomExpression(String string) {
		System.out.println("New Custom Expression : " + string);
		Expression E = valueOf(string);
		E.execAll();
	}

	private static void runComplexExpression() {
		System.out.println("New Complex Expression :" + "5*4 + 8*7");
		Expression e1 = Expression.mkBinary('*', mkSimple(5), mkSimple(4));
		Expression e2 = Expression.mkBinary('*', mkSimple(8), mkSimple(7));
		Expression E = Expression.mkBinary('+', e1, e2);
		E.execAll();
		System.out.println();
	}

	private static void runComplexExpression2() {
		System.out.println("New Complex Expression :" + "5*4 + 8*7 + 3*10 + 9*8");
		Expression e11 = Expression.mkBinary('-', mkSimple(5), mkSimple(4));
		Expression e12 = Expression.mkBinary('*', mkSimple(8), mkSimple(7));
		Expression E1 = Expression.mkBinary('+', e11, e12);
		Expression e21 = Expression.mkBinary('/', mkSimple(3), mkSimple(10));
		Expression e22 = Expression.mkBinary('*', mkSimple(9), mkSimple(8));
		Expression E2 = Expression.mkBinary('+', e21, e22);
		Expression E = Expression.mkBinary('+', E1, E2);
		Expression e31 = Expression.mkBinary('-', mkSimple(5), mkSimple(11));
		E.execAll();
		assertEquals(true, E.isPartOf(e11));
		assertEquals(true, E.isPartOf(e21));
		assertEquals(true, E.isPartOf(E));
		assertEquals(false, E.isPartOf(e31));
		E.printIsPartOf(e11);
		E.printIsPartOf(e21);
		E.printIsPartOf(E);
		E.printIsPartOf(e31);
		System.out.println();
	}

	private static void runBinaryExpression(char op, int val1, int val2) {
		System.out.println("New Binary Expression :" + val1 + op + val2);
		Expression e = Expression.mkBinary(op, mkSimple(val1), mkSimple(val2));
		e.execAll();
		System.out.println();
	}

	private static void runSimpleExpresion(int val) {
		System.out.println("New Simple Expression :" + val);
		Expression e = Expression.mkSimple(val);
		e.execAll();
		System.out.println();
	}

}
