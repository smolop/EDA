package aplicacionesDeColas;

import java.util.Iterator;

import ehu.eda.list.linkedImp.QueueOfT;

public class OficinaVirtual {
	QueueOfT<Integer> cola;
	int miPosicion;
	int miPrioridad;

	public OficinaVirtual(int[] solicitudes, int pos, int prior) {
		cola = new QueueOfT<Integer>();
		for (int i = 0; i < solicitudes.length; i++) {
			cola.enqueue(solicitudes[i]);
		}
		miPosicion = pos;
		miPrioridad = prior;
	}

	private boolean hayMasPrioritaria(int prior) {
		Iterator<Integer> scan = cola.queueIterator();
		while (scan.hasNext()) {
			if (scan.next() > prior) {
				return true;
			}
		}
		return false;
	}

	public int AtendidasAntesQue(int pos, int prior) {
		int contador = 0;
		int primera;
		while (hayMasPrioritaria(prior)) {
			primera = cola.dequeue();
			if (pos == 1) {
				pos = cola.size() + 1;
			} else {
				pos--;
			}
			if (hayMasPrioritaria(primera)) {
				cola.enqueue(primera);
			} else {
				contador++;
			}
		}
		while (pos > 1) {
			primera = cola.dequeue();
			pos--;
			if (hayMasPrioritaria(primera)) {
				cola.enqueue(primera);
			} else {
				contador++;
			}
		}
		return contador;
	}
}
