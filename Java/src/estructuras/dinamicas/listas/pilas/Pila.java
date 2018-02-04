package estructuras.dinamicas.listas.pilas;

import estructuras.dinamicas.listas.ILista;
import estructuras.dinamicas.listas.Nodo;

import java.util.Scanner;

public class Pila implements ILista{

    private Nodo raiz;
    private int contadorNodos;

    Pila(){
        raiz = null;
        contadorNodos = 0;
    }

    @Override
    public boolean esVacio(Nodo nodo) {
        return nodo == null;
    }

    @Override
    public boolean tieneSiguiente(Nodo nodo) {
        return nodo.siguiente != null;
    }

    @Override
    public int getCantidadNodos() {
        return contadorNodos;
    }

    @Override
    public void insertar(Integer o) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.info = o;
        if(esVacio(raiz)){
            raiz = nuevoNodo;
        }else{
            nuevoNodo.siguiente = raiz;
            raiz = nuevoNodo;
        }
        contadorNodos++;
        System.out.println("Insertado el elemento: " + nuevoNodo.info + " " + raiz.info +
                " Cantidad Nodos : " + contadorNodos);
    }

    @Override
    public Object extraer() {
        Nodo nodo = raiz;
        if(esVacio(raiz))
            return null;
        else
            raiz = raiz.siguiente;
        contadorNodos--;
        System.out.println("Extraido el elemento: " + nodo.info + " " + " Cantidad Nodos : " + contadorNodos);
        return nodo.info;
    }

    @Override
    public void imprimirTodo() {
        Nodo nodoActual = new Nodo();
        nodoActual.siguiente = raiz;
        if(esVacio(raiz))
            System.out.printf("\n No hay elementos a imprimirTodo, pila vacia. ");
        else
            while (tieneSiguiente(nodoActual)) {
                System.out.println("Nodo->Info: " + nodoActual.siguiente.info);
                nodoActual = nodoActual.siguiente;
            }
    }



    @Override
    public void exec() {
        Scanner input = new Scanner(System.in);
        Pila p = new Pila();
        p.insertar(1);
        p.insertar(2);
        p.insertar(3);
        p.insertar(5);
        p.insertar(7);
        p.insertar(11);
        p.imprimirTodo();
        String r;
        do {
            System.out.print("\nQuiere extraer el primer elemento de la pila y/N:");
            r = new Scanner(System.in).next();
            if (r.equals("y")) {
                p.extraer();
                p.imprimirTodo();
            }
        }while (!r.equals("N"));
        System.out.printf("\nProceso finalizado.");
    }

    public static void main(String [] argv){
        Pila p = new Pila();
        p.exec();
    }


}
