/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ehu.eda.list.linkedImp;

import java.util.NoSuchElementException;

/**
 * Una implementación simple de "listas de enteros", usando una lista ligada
 * (double-linked-list).
 * 
 * En esta implementación, las listas tienen capacidad limitada solo por la
 * memoria disponible.
 * 
 * El código está tomado de la clase LinkedList de a librería estándar, escrito
 * por Josh Bloch.
 * 
 * Esta clase evolucionará con otras operaciones.
 */
public class DoubleLinkedListOfInt {

	private Node first; // el primer nodo de la lista
	private Node last; // el último nodo de la lista
	int size = 0; // número de elementos en la lista

	public void addFirst(int e) {
		linkFirst(e);
	}

	public void addLast(int e) {
		linkLast(e);
	}

	public int getFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.item;
	}

	public int getLast() {
		if (last == null) {
			throw new NoSuchElementException();
		}
		return last.item;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int removeFirst() {
		final Node f = first;
		if (f == null) {
			throw new NoSuchElementException();
		}
		return unlinkFirst(f);
	}

	public int removeLast() {
		final Node l = last;
		if (l == null) {
			throw new NoSuchElementException();
		}
		return unlinkLast(l);
	}

	/**
	 * Links e as last element.
	 */
	private void linkLast(int e) {
		final Node l = last;
		final Node newNode = new Node(l, e, null);
		last = newNode;
		if (l == null) {
			first = newNode;
		} else {
			l.next = newNode;
		}
		size++;
	}

	/**
	 * Links e as first element.
	 */
	private void linkFirst(int e) {
		final Node f = first;
		final Node newNode = new Node(null, e, f);
		first = newNode;
		if (f == null) {
			last = newNode;
		} else {
			f.prev = newNode;
		}
		size++;
	}

	private int unlinkFirst(Node f) {
		assert f == first && f != null;

		final int element = f.item;
		final Node oldSecond = f.next;
		// f.item = null;
		f.next = null; // help GC
		first = oldSecond;
		if (oldSecond == null) {
			last = null;
		} else {
			oldSecond.prev = null;
		}
		size--;
		return element;
	}

	/**
	 * Unlinks non-null last node l.
	 */
	private int unlinkLast(Node l) {
		assert l == last && l != null;

		final int element = l.item;
		final Node oldLast = l.prev;
		// l.item = null;
		l.prev = null; // help GC
		last = oldLast;
		if (oldLast == null) {
			first = null;
		} else {
			oldLast.next = null;
		}
		size--;
		return element;
	}

	private static class Node {
		int item;
		Node next;
		Node prev;

		Node(Node prev, int element, Node next) {
			item = element;
			this.next = next;
			this.prev = prev;
		}
	}
}
