package exam;

import java.awt.Window;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
* PUEDES INCORPORAR/USAR CUALQUIERA DE LAS CLASES VISTAS EN CLASE
*/

public class JuegoTramposo {

	private int size = 0;
	private Jugador[] jugadores;

	public JuegoTramposo(int size) {
		this.size = size;
		jugadores = new Jugador[size];
	}

	public Jugador[] getJugadores() {
		return jugadores;
	}

	// Las instancias de esta clase representan pagos de un jugador a otro.
	private class Payment {
		public final Integer payer;
		public final int amount;
		public final Integer winner;

		public Payment(Integer payer, Integer winner, int amount) {
			this.payer = payer;
			this.winner = winner;
			this.amount = amount;
		}

		@Override
		public String toString() {
			return "Payment [payer=" + payer + ", " + "amount=" + amount + ", " + "winner=" + winner + "]";
		}
	}

	Payment createPyament(int payer, int winner, int amount) {
		Payment payment = new Payment(payer, amount, winner);
		System.out.println("CREATE PAYMENT: " + payment.toString());
		return payment;
	}

	// Para apartado (a)
	private void rutinaComun(Payment pay) {
		// HACER
		if (jugadores[pay.payer] == null)
			jugadores[pay.payer] = new Jugador(pay.payer);
		if (jugadores[pay.winner] == null)
			jugadores[pay.winner] = new Jugador(pay.winner);

		Jugador payer = jugadores[pay.payer];
		Jugador creditor = jugadores[pay.winner];
		int quantity = pay.amount;
		// System.out.println("FROM: " + payer.getId() + " TO: " + creditor.getId() + "
		// QUANTITY OF: " + quantity);
		payer.pay(creditor, quantity);

	}

	// Para apartado (b)
	private void rutinaDelTramposo(Payment pay) {
		// HACER
		if (jugadores[pay.payer] == null)
			jugadores[pay.payer] = new Jugador(pay.payer);
		if (jugadores[pay.winner] == null)
			jugadores[pay.winner] = new Jugador(pay.winner);

		Jugador payer = jugadores[pay.payer];
		Jugador creditor = jugadores[pay.winner];
		int quantity = pay.amount;
		// System.out.println("FROM: " + payer.getId() + " TO: " + creditor.getId() + "
		// QUANTITY OF: " + quantity);
		if (pay.payer == 0)
			payer.payB(creditor, quantity);
		else
			payer.pay(creditor, quantity);
	}

	void printResultAtMoment() {
		for (Jugador jugador : getJugadores())
			if (jugador != null)
				System.out.println("ID : " + jugador.getId() + " - cantidad total de billetes: " + jugador.getAmount()
						+ " - billetes legales = " + jugador.getValid() + " billetes falsos = "
						+ jugador.getInvalids());

	}

	void totalPlayed() {
		int total = 0;
		for (Jugador jugador : getJugadores())
			if (jugador != null)
				total += jugador.getAmount();
		System.out.println("TOTAL PLAYED:  " + total + " UM");
	}

	public static int countLines(String path) {
		int lines = 0;
		try {
			Scanner input = new Scanner(new File(path));
			for (lines = 0; input.hasNextLine(); lines++)
				input.nextLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lines;
	}

	public static void main(String[] args) {

		try {
			String path = "src/exam/datosPartida1.txt";
			Scanner input = new Scanner(new File(path));

			int tam = input.nextInt();
			JuegoTramposo jt = new JuegoTramposo(tam);

			int rounds = countLines(path) - 1;
			System.out.println("FILE THERE ARE LINES EQUAL TO: " + (rounds + 1));

			for (int i = 0; i < rounds; i++) {
				int payer = input.nextInt();
				int winner = input.nextInt();
				int amount = input.nextInt();
				// System.out.println("FROM: " + payer+ " - TO: " + winner + " QUANTITY OF: " +
				// amount);
//				jt.rutinaComun(jt.createPyament(payer, winner, amount));
				jt.rutinaDelTramposo(jt.createPyament(payer, winner, amount));
				if (i == 3)
					jt.printResultAtMoment();
			}

			// HACER
			jt.printResultAtMoment();
			jt.totalPlayed();

			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
