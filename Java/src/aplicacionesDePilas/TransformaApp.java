package aplicacionesDePilas;

import java.util.Random;

import ehu.eda.list.arrayImp.StackOfT;

public class TransformaApp {

	/*
	 * Devuelve otra pila, con los números pares de p situados en el mismo lugar que
	 * estaban en p y, sin embargo, los números impares ocuparán los mismos lugares
	 * pero estarán en orden inverso al que estaban en p. Ejemplo: Si p=[2, 4, 3, 5,
	 * 6, 7, 9] (siendo 9 la cima), se devolverá la pila [2, 4, 9, 7, 6, 5, 3]
	 */
	private static StackOfT<Integer> Transforma(StackOfT<Integer> p) {
		// HACER
		StackOfT<Integer> aux = new StackOfT<Integer>(p.size());
		Integer[] index = new Integer[p.size()];
		Integer[] org = new Integer[p.size()];
		int n = 0;
		int idx = 0;
		while(!p.isEmpty())
		{
			org[n] = p.pop();
			n++;
		}
		
		for (int i = 0; i < org.length; i++) 
		{
			Integer elem = org[i];
			if( elem % 2 != 0) 
			{
				aux.push(elem);	
				index[idx] = i;
				idx++;
			}
		}
		
		for(int j = 0; index.length > 0 && j < idx ; j++) 
		{
			int pos = index[j];
			org[pos] = aux.pop();
		}
		
		for(Integer e : org)
			p.push(e);
		
		return p;
	}

	/*
	 * Escribe los elementos de la pila p desde el fondo a la cima
	 */
	private static void Imprime(StackOfT<Integer> p) {
		// HACER
		while(!p.isEmpty())
			System.out.println(p.pop());
	}

	public static void main(String[] args) {
		final int num = 20;
		StackOfT<Integer> laPila = new StackOfT<Integer>(num);
		Random random = new Random();
		int r;
		for (int i = 1; i <= num; i++) {
			r = random.nextInt(num + 1);
			laPila.push(r);
			System.out.print(r + " "
					+ "");
		}
		System.out.println();
		StackOfT<Integer> laOtraPila = Transforma(laPila);
		Imprime(laOtraPila);
	}

}
