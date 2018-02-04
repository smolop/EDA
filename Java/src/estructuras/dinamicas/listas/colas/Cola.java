package estructuras.dinamicas.listas.colas;

import estructuras.dinamicas.listas.ILista;
import estructuras.dinamicas.listas.Nodo;

import java.util.Scanner;

public class Cola implements ILista {

    private Nodo raiz, cola;
    private int cantidadNodos;

    Cola(){
        cola = raiz = null;
        cantidadNodos = 0;
    }

    @Override
    public boolean esVacio(Nodo nodo) {
        return nodo == null;
    }

    @Override
    public boolean tieneSiguiente(Nodo nodo) {
        return !esVacio(nodo.siguiente);
    }

    @Override
    public int getCantidadNodos() {
        return cantidadNodos;
    }

    @Override
    public void insertar(Integer obj) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.info = obj;
        if (esVacio(raiz)){
            raiz = nuevoNodo;
            cola = raiz;
        }
        else {
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
        }
        cantidadNodos++;
    }

    @Override
    public Object extraer() {
        Nodo nodo = new Nodo();
        nodo = raiz;
        if(esVacio(cola))
            return null;
        else
            raiz = raiz.siguiente;
        cantidadNodos--;
        return  nodo;
    }

    @Override
    public void imprimirTodo() {
        Nodo nodo = new Nodo();
        nodo.siguiente = raiz;
        if (esVacio(raiz))
            System.out.println("NO hay elementos para imprimirTodo, Lista vacia. ");
        else {
            while (tieneSiguiente(nodo = nodo.siguiente))
                System.out.println("Nodo->Info : " + nodo.info + " n nodos | n : " + cantidadNodos);
            System.out.println("Nodo->Info : " + nodo.info + " n nodos | n : " + cantidadNodos);
        }
    }

    @Override
    public void exec() {
        Cola c = new Cola();
        c.insertar(1);
        c.insertar(2);
        c.insertar(3);
        c.insertar(5);
        c.insertar(7);
        c.insertar(11);
        c.imprimirTodo();
        String r;
        if (!esVacio(c.raiz))
            do {
                System.out.print("\nQuiere extraer el primer elemento de la cola y/N:");
                r = new Scanner(System.in).next();
                if (r.equals("y") && !esVacio(c.raiz)) {
                    c.extraer();
                    c.imprimirTodo();
                }
            }while (!r.equals("N"));
        System.out.printf("\nProceso finalizado.");
    }

    public static void main(String [] argv){
        Cola c = new Cola();
        c.exec();
    }

}
