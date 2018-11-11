package aplicacionesDeColas;

public class ColaMultiUsuario {

	private final int N; // número de usuarios
	private Node[] usuario; // referencias a la posición de cada usuario

	private Node first; // el primer nodo de la cola
	private Node last; // es el último nodo de la cola
	private int numMensajes; // número de mensajes en la cola

	private static class Node {
		String mensaje;
		int numLecturas;
		Node next;
	}

	public ColaMultiUsuario(int numUsuarios) {
		N = numUsuarios;
		first = last = null;
		numMensajes = 0;
		usuario = new Node[N];
		for (int i = 0; i < N; i++) {
			usuario[i] = first;
		}
	}

	public void incluye(String msg) {
		Node newNode = new Node();
		newNode.mensaje = msg;
		newNode.numLecturas = 0;
		if (first == null) {
			first = newNode;
			for (int i = 0; i < N; i++) {
				usuario[i] = first;
			}
		} else {
			last.next = newNode;
			for (int i = 0; i < N; i++) {
				if (usuario[i] == null) {
					usuario[i] = newNode;
				}
			}
		}
		last = newNode;
		numMensajes++;
	}

	public boolean hayMensajesPara(int numUsuario) {
		return usuario[numUsuario] != null;
	}

	public void purgar() {
		int numPurgados = 0;
		while (first != null && first.numLecturas == N) {
			first = first.next;
			numPurgados++;
		}
		numMensajes = numMensajes - numPurgados;
	}

	public String leer(int numUsuario) {
		String msg = usuario[numUsuario].mensaje;
		usuario[numUsuario].numLecturas++;
		usuario[numUsuario] = usuario[numUsuario].next;
		return msg;
	}

	public int size() {
		return numMensajes;
	}
}
