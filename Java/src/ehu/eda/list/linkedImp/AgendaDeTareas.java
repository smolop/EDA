package ehu.eda.list.linkedImp;

public class AgendaDeTareas {

	private OrdinaryNode headOrdinaryPointer = null;
	private PrioritaryNode headPrioritaryPointer = null;
	private OrdinaryNode lastOrdinaryPointer = null;
	private PrioritaryNode lastPrioritaryPointer = null;

	private Node head = null;
	private Node tail = null;

	private int cardinal = 0;

	public static class Node {
		Node prev;
		String task;
		Node next;

		Node(Node prev, String task, Node next) {
			this.prev = prev;
			this.task = task;
			this.next = next;
		}

		void clearTask() {
			this.task = null;
		}

	}

	public static class OrdinaryNode extends Node {
		OrdinaryNode nextOrdinary;

		OrdinaryNode(Node prev, String task, Node next, OrdinaryNode nextOrdinary) {
			super(prev, task, next);
			this.nextOrdinary = nextOrdinary;
		}
	}

	public static class PrioritaryNode extends Node {
		PrioritaryNode nextPrioritary;

		PrioritaryNode(Node prev, String task, Node next, PrioritaryNode nextPrioritary) {
			super(prev, task, next);
			this.nextPrioritary = nextPrioritary;
		}

	}

	public void addOrdinary(String task) {
		OrdinaryNode newtask = new OrdinaryNode(null, task, null, null);
		if(headOrdinaryPointer == null) {
		headOrdinaryPointer = newtask;
		lastOrdinaryPointer = newtask;
		}else {
			lastOrdinaryPointer.nextOrdinary = newtask;
			lastOrdinaryPointer =  newtask;
		}
		addNode(newtask);
	}

	public void addPrioritary(String task) {
		PrioritaryNode newtask = new PrioritaryNode(null, task, null, null);
		if (headPrioritaryPointer == null) {
			headPrioritaryPointer = newtask;
			lastPrioritaryPointer = newtask;
		}else {
			lastPrioritaryPointer.nextPrioritary = newtask;
			lastPrioritaryPointer = newtask;
		}
		addNode(newtask);
	}

	private void addNode(Node newtask) {
		if (tail == null) {
			head = newtask;
			tail = newtask;
		} else if (tail != null) {
			tail.next = newtask;
			newtask.prev = tail;
			tail = newtask;
		}
		increase();
	}

	public String rmvPrioritary() {
		String task = headPrioritaryPointer.task;
		Node toRemove = headPrioritaryPointer;
		headPrioritaryPointer = headPrioritaryPointer.nextPrioritary;
		rmv(toRemove);
		return task;
	}

	public void rmvNonPrioritary() {
		Node toRemove = headOrdinaryPointer;
		headOrdinaryPointer = headOrdinaryPointer.nextOrdinary;
		rmv(toRemove);
	}

	private void rmv(Node node) {
		assert node != null;
		final Node nextPointer = node.next;
		final Node prevPointer = node.prev;

		if (prevPointer == null)
			head = nextPointer;
		else {
			prevPointer.next = nextPointer;
			node.prev = null;
		}

		if (nextPointer == null)
			tail = prevPointer;
		else {
			nextPointer.prev = prevPointer;
			node.next = null;
		}

		node.clearTask();
		decrease();
	}

	public String rmv() {
		assert head != null;
		String task = head.task;
		if (head instanceof OrdinaryNode)
			rmvNonPrioritary();
		else if (head instanceof PrioritaryNode)
			rmvPrioritary();
		return task;
	}

	void printer() {
		Node scan = head;
		while (scan != null) {
			System.out.println(scan.task);
			scan = scan.next;
		}
	}

	int getCardinal() {
		return cardinal;
	}

	private int increase() {
		return ++cardinal;
	}

	private int decrease() {
		return --cardinal;
	}

	public static void main(String[] args) {

		int t = 10;
		AgendaDeTareas a = new AgendaDeTareas();

		for (int i = 0; i < t; i++) {
			a.addPrioritary(String.format("Prioritary - %s ", i));
			for (int j = 0; j < t / 2; j++) {
				a.addOrdinary(String.format("Ordinary - %s-%s", i, j));
			}
		}
//		System.out.println("Printing tasks queue");
//		a.printer();

//		System.out.println("Removing tasks queue");
//		String e = "-1";
//		while (a.getCardinal() > 0) {
//			e = a.rmv();
//			System.out.println(e);
//		}

		System.out.println("Removing task queue");
//		System.out.println(a.rmv());
//		System.out.println(a.rmv());
//		System.out.println(a.rmv());
		String e = "-1";
		int middle = a.getCardinal()/2;
		while (a.getCardinal() > middle) {
			e = a.rmv();
			System.out.println(e);
		}
		
		
		System.out.println("Printing tasks queue");
		a.printer();

	}

}
