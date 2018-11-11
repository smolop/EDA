package ehu.eda.list.linkedImp;

public class StackOfT<T> implements IStackOfT<T> {

	private Node<T> first;
	private int n;

	/**
	 * O(1)
	 */
	@Override
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * O(1)
	 */
	@Override
	public T peek() {
		return first.item;
	}

	/**
	 * O(1) 
	 * Decimos que es de orden constante porque se hacen tres operaciones elementales
	 */
	@Override
	public T pop() {
		T item = first.item;
		first = first.next;
		n--;
		return item;
	}

	/**
	 * O(1)
	 * Decimos que es de orden constante porque se hacen cuatro operaciones elementales
	 */
	@Override
	public void push(T item) {
		Node<T> oldFirst = first;
		first = new Node<T>();
		first.item = item;
		first.next = oldFirst;
		n++;
	}

	/**
	 * O(1)
	 */
	@Override
	public int size() {
		return n;
	}

	private static class Node<T> {
		T item;
		Node<T> next;
	}
}
