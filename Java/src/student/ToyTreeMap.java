package student;

public class ToyTreeMap<Key, Value> {

	private BinaryNode<Key, Value> root;
	private int size = 0;
	private final java.util.Comparator<? super Key> keyComparator;

	public ToyTreeMap(java.util.Comparator<? super Key> comparator) {
		super();
		this.root = null;
		this.keyComparator = comparator;
	}

	private static final boolean RED = false;
	private static final boolean BLACK = true;

	private static class BinaryNode<Key, Value> {
		private Key key;
		private Value value;
		private BinaryNode<Key, Value> left;
		private BinaryNode<Key, Value> right;
		private BinaryNode<Key, Value> parent;
		boolean color = BLACK;

		@SuppressWarnings("unused")
		BinaryNode(BinaryNode<Key, Value> left, BinaryNode<Key, Value> right, Key key, Value value) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
		}

		// Por defecto, left, right = null!!!
		BinaryNode(Key key, Value value) {
			this.key = key;
			this.value = value;
		}

		// Por defecto, left, right = null!!!
		@SuppressWarnings("unused")
		BinaryNode(Value value) {
			this.value = value;
		}

		public BinaryNode(Key key, Value value, BinaryNode<Key, Value> parent) {
			this.key = key;
			this.value = value;
			this.parent = parent;
		}

		Key getKey() {
			return key;
		}

		Value getValue() {
			return value;
		}

		// **
		public Value setValue(Value value) {
			Value val = this.value;
			this.value = value;
			return val;
		}
	}
	
	
	public static class Tuple<Key> {
		Key key1;
		Key key2;
		
		Tuple(Key key1, Key key2){
			this.key1 = key1;
			this.key2 = key2;
		}
	}

	public Value put(Key key, Value value) {
		return putAux(key, value);
	}

	public Value get(Key key) {
		return getAux(key);
	}

	public int size() {
		return size;
	}

	public void clear() {
		root = null;
		size = 0;
	}

	public void printLexicographically() {
		printInOrden(root);
	}
	
	public Tuple<Key> findMinMax(){
		return new Tuple<Key>(findMin().getKey(), findMax().getKey());
	}

	public boolean isBST() {
		return isBST(root);
	}

	// ------------------PRIVATE ZONE-----------------------//

	private Value putAux(Key key, Value value) {
		BinaryNode<Key, Value> parent;
		BinaryNode<Key, Value> r = root;
		int comp;
		if (value == null)
			throw new java.lang.IllegalArgumentException();
		if (r == null) {
			keyComparator.compare(key, key);
			root = new BinaryNode<Key, Value>(key, value);
			size = 1;
			return null;
		}
		if (key != null) {
			do {
				parent = r;
				comp = keyComparator.compare(key, r.key);
				r = (comp < 0 ? r.left : (comp > 0 ? r.right : r));
				if (parent == r)
					return r.setValue(value);
			} while (r != null);
			BinaryNode<Key, Value> leaf = new BinaryNode<Key, Value>(key, value, parent);
			if (comp < 0)
				parent.left = leaf;
			else
				parent.right = leaf;
			balanceTree(leaf);
			size++;
		} else if (key == null)
			throw new java.lang.NullPointerException();
		return null;
	}

	private Value getAux(Key key) {
		if (key == null)
			throw new java.lang.NullPointerException();
		BinaryNode<Key, Value> parent;
		BinaryNode<Key, Value> r = root;
		int comp;
		do {
			parent = r;
			comp = keyComparator.compare(key, r.key);
			r = (comp < 0 ? r.left : (comp > 0 ? r.right : r));
			if (parent == r)
				return r.getValue();

		} while (r != null);
		return null;
	}

	private void printInOrden(BinaryNode<Key, Value> node) {
		if (node != null) {
			printInOrden(node.left);
			System.out.printf("Key: %s Value: %s  \n", node.getKey(), node.getValue());
			printInOrden(node.right);
		}
	}

	//Se hace uso de esta funcioon para realizar las pruebas pertinenes, sin que se degenere el aarbol.
	private void balanceTree(BinaryNode<Key, Value> node1) {
		node1.color = RED;

		while (node1 != null && node1 != root && node1.parent.color == RED) {
			if (parentOf(node1) == leftOf(parentOf(parentOf(node1)))) {
				BinaryNode<Key, Value> node2 = rightOf(parentOf(parentOf(node1)));
				if (colorOf(node2) == RED) {
					setColor(parentOf(node1), BLACK);
					setColor(node2, BLACK);
					setColor(parentOf(parentOf(node1)), RED);
					node1 = parentOf(parentOf(node1));
				} else {
					if (node1 == rightOf(parentOf(node1))) {
						node1 = parentOf(node1);
						rotateLeft(node1);
					}
					setColor(parentOf(node1), BLACK);
					setColor(parentOf(parentOf(node1)), RED);
					rotateRight(parentOf(parentOf(node1)));
				}
			} else {
				BinaryNode<Key, Value> y = leftOf(parentOf(parentOf(node1)));
				if (colorOf(y) == RED) {
					setColor(parentOf(node1), BLACK);
					setColor(y, BLACK);
					setColor(parentOf(parentOf(node1)), RED);
					node1 = parentOf(parentOf(node1));
				} else {
					if (node1 == leftOf(parentOf(node1))) {
						node1 = parentOf(node1);
						rotateRight(node1);
					}
					setColor(parentOf(node1), BLACK);
					setColor(parentOf(parentOf(node1)), RED);
					rotateLeft(parentOf(parentOf(node1)));
				}
			}
		}
		root.color = BLACK;
	}

	private void rotateRight(BinaryNode<Key, Value> node) {
		 if (node != null) {
			 	BinaryNode<Key, Value> l = node.left;
	            node.left = l.right;
	            if (l.right != null) l.right.parent = node;
	            l.parent = node.parent;
	            if (node.parent == null)
	                root = l;
	            else if (node.parent.right == node)
	                node.parent.right = l;
	            else node.parent.left = l;
	            l.right = node;
	            node.parent = l;
	        }
	}

	private void rotateLeft(BinaryNode<Key, Value> node) {
		if (node != null) {
			BinaryNode<Key, Value> current = node.right;
			node.right = current.left;
			if (current.left != null)
				current.left.parent = node;
			current.parent = node.parent;
			if (node.parent == null)
				root = current;
			else if (node.parent.left == node)
				node.parent.left = current;
			else
				node.parent.right = current;
			current.left = node;
			node.parent = current;
		}
	}

	private static <Key, Value> void setColor(BinaryNode<Key, Value> node, boolean color) {
		if (node != null)
			node.color = color;
	}

	private static <Key, Value> boolean colorOf(BinaryNode<Key, Value> node) {
		return node == null ? BLACK : node.color;
	}

	private BinaryNode<Key, Value> rightOf(BinaryNode<Key, Value> node) {
		return node == null ? null : node.right;
	}

	private static <Key, Value> BinaryNode<Key, Value> leftOf(BinaryNode<Key, Value> node) {
		return node == null ? null : node.left;
	}

	private static <Key, Value> BinaryNode<Key, Value> parentOf(BinaryNode<Key, Value> node) {
		return node == null ? null : node.parent;
	}
	
	private BinaryNode<Key, Value> findMin() {
		return findMin(root);
	}
	
	private BinaryNode<Key, Value> findMin(BinaryNode<Key, Value> node) {
		return node == null ? node : (node.left == null ? node : findMin(node.left));
	}
	
	private BinaryNode<Key, Value> findMax() {
		return findMax(root);
	}
	
	private BinaryNode<Key, Value> findMax(BinaryNode<Key, Value> node) {
		return node == null ? node : (node.right == null ? node : findMax(node.right));
	}
	
	private boolean isBST(BinaryNode<Key, Value> node) {
		if(node == null)
			return true;
		if(keyComparator.compare(findMin(node).key, node.key) <=0 && keyComparator.compare(findMax(node).key,  node.key) >= 0)
			return isBST(node.left) && isBST(node.right);
		return false;
	}

	//---------------------- EXECUTE ZONE --------------------------//
	
	public static void main(String[] args) {
		java.util.Comparator<Integer> cmp = new student.IntegerComparator();
		ToyTreeMap<Integer, String> tm = new ToyTreeMap<Integer, String>(cmp);
		execAll(tm);
	}

	private static void execAll(ToyTreeMap<Integer, String> tm) {
		runPut(tm);
		runPrinter(tm);
		runGet(tm);
		runFindMinMax(tm);
		runIsBST(tm);
	}

	private static void runIsBST(ToyTreeMap<Integer, String> tm) {
		System.out.println("FUNCIOON: isBST()");
		System.out.printf("¿El arbol dado corresponde a un BST? R:// %s", tm.isBST());
	}

	private static void runFindMinMax(ToyTreeMap<Integer, String> tm) {
		System.out.println("FUNCIOON: findMinMax()");
		Tuple<Integer> t = tm.findMinMax();
		System.out.printf("La clave menor es %d y la mayor es %d", t.key1, t.key2);
	}

	private static void runPrinter(ToyTreeMap<Integer, String> tm) {
		runLexPrinter(tm);
		runSize(tm);
		runGetRoot(tm);
	}
	private static void runGet(ToyTreeMap<Integer, String> tm) {
		System.out.println("FUNCIOON: get(key)");
		for (int i = 1; i < 10; i++)
			System.out.println(tm.get(i));
	}

	private static void runLexPrinter(ToyTreeMap<Integer, String> tm) {
		System.out.println("FUNCIOON: printLexicographically()");
		tm.printLexicographically();
	}

	private static void runPut(ToyTreeMap<Integer, String> tm) {
		System.out.println("FUNCIOON: put(key)");
		for (int i = 1; i < 10; i++) {
			System.out.println(tm.put(i, String.valueOf(i)));
			for (int j = 1; i % 2 == 0 && j < 4; j++)
				System.out.println(tm.put(i, i + "." + j));
		}
	}
	
	private static void runGetRoot(ToyTreeMap<Integer, String> tm) {
		System.out.println("La raiz es: " + tm.root.getValue());
	}

	private static void runSize(ToyTreeMap<Integer, String> tm) {
		System.out.println("El arbol tiene nodos eqivalentes a una cantidad : " + tm.size);
	}
}
