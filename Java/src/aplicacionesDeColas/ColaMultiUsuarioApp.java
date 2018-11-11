package aplicacionesDeColas;

public class ColaMultiUsuarioApp {

	public static void main(String[] args) {
		int numUsuarios = 10;
		int numMensajes = 100;
		ColaMultiUsuario cola = new ColaMultiUsuario(numUsuarios);
		for (int i = 1; i <= numMensajes; i++) {
			cola.incluye("mensaje" + i);
		}
		System.out.println("Hay " + numMensajes + " en la cola");

		int k = 5; // identificador de un usuario
		if (cola.hayMensajesPara(k)) {
			System.out.println("Hay mensajes para usuario " + k);
		} else {
			System.out.println("NO hay mensajes para usuario " + k);
		}

		int numLeer = 3;
		for (int numMsg = 1; numMsg <= numLeer; numMsg++) {
			for (int i = 0; i < numUsuarios; i++) {
				cola.leer(i);
			}
		}
		System.out.println("Todos los usuarios han leído " + numLeer);

		for (int numMsg = numLeer + 1; numMsg <= numMensajes; numMsg++) {
			cola.leer(k);
		}
		System.out.println("El usuario " + k + " ha leído todos");

		if (cola.hayMensajesPara(k)) {
			System.out.println("Hay mensajes para usuario " + k);
		} else {
			System.out.println("NO hay mensajes para usuario " + k);
		}

		cola.purgar();
		System.out.println("Hay " + cola.size() + " mensajes en la cola");
	}

}
