package estructuras.dinamicas.arboles.binarios;

import java.util.ArrayList;

public class ArbolBinarioOrdenado implements IBTS {

    private Nodo raiz;

    ArbolBinarioOrdenado(){
        raiz = null;
    }

    @Override
    public void insertar(int x) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.item = x;
        if(raiz == null)
            raiz = nuevoNodo;
        else{
            Nodo nodoActual = new Nodo();
            nodoActual = raiz;
            Nodo nodoPadre = new Nodo();
            while (nodoActual != null){
                nodoPadre = nodoActual;
                if(x < nodoActual.item)
                    nodoActual = nodoActual.izq;
                else
                    nodoActual = nodoActual.der;
            }
            if(x < nodoPadre.item)
                nodoPadre.izq = nuevoNodo;
            else
                nodoPadre.der = nuevoNodo;
            System.out.println("Padre: "+nodoPadre.item + " Hijo-" +
                    (x< nodoPadre.item ? "izq -> " + nodoPadre.izq.item : "der -> " + nodoPadre.der.item) );
        }

    }

    @Override
    public void imprimirpre() {
        Nodo nodo = new Nodo();
        nodo = raiz;
        System.out.println(raiz.item);
        if(raiz.izq != null)
            imprimirpre(nodo.izq);
        if(raiz.der != null)
            imprimirpre(nodo.der);
    }

    private void imprimirpre(Nodo nodo) {
        System.out.println(nodo.item);
        if(nodo.izq != null)
            imprimirpre(nodo.izq);
        if(nodo.der != null)
            imprimirpre(nodo.der);
    }

    @Override
    public void imprimirin() {
        Nodo nodo = new Nodo();
        nodo = raiz;
        if(raiz.izq != null)
            imprimirin(nodo.izq);
        System.out.println(raiz.item);
        if(raiz.der != null)
            imprimirin(nodo.der);
    }

    private void imprimirin(Nodo nodo) {
        if(nodo.izq != null)
            imprimirin(nodo.izq);
        System.out.println(nodo.item);
        if(nodo.der != null)
            imprimirin(nodo.der);
    }

    @Override
    public void imprimirpost() {
        Nodo nodo = new Nodo();
        nodo = raiz;
        if(raiz.izq != null)
            imprimirpost(nodo.izq);
        if(raiz.der != null)
            imprimirpost(nodo.der);
        System.out.println(raiz.item);
    }

    private void imprimirpost(Nodo nodo) {
        if(nodo.izq != null)
            imprimirpost(nodo.izq);
        if(nodo.der != null)
            imprimirpost(nodo.der);
        System.out.println(nodo.item);
    }

    public void recorridoEnAnchura(){
        Nodo nodo = new Nodo();
        Nodo nuevoNodo = new Nodo();
        nodo = raiz;


        if(raiz != null) {
            ArrayList<Nodo> cola = new ArrayList<>();
            cola.add(nodo);

            while (!cola.isEmpty()){
                Nodo actual = cola.remove(0);
                System.out.println("El elemento recorrido es: " + actual.item);

                if(actual.izq != null)
                    cola.add(actual.izq);
                if(actual.der != null)
                    cola.add(actual.der);

            }

        }
    }

    public static void main(String[] argv){

        IBTS bst = new ArbolBinarioOrdenado();

        for (int i = 5; i > 0; i--) {
            bst.insertar((int) Math.pow(2,i-1));
        }
        for (int i = 5; i < 10; i++) {
            bst.insertar((int) Math.pow(2,i-1));
        }
        for (int i = 5; i > 0; i--) {
            bst.insertar((int) Math.pow(2,i-1) + 1);
        }
        for (int i = 5; i > 0; i--) {
            bst.insertar((int) Math.pow(2,i-1) - 1);
        }

        System.out.println("Pre-Orden");
        bst.imprimirpre();
        System.out.println("In-Orden");
        bst.imprimirin();
        System.out.println("Pos-Orden");
        bst.imprimirpost();
        System.out.println("Anchura");
        bst.recorridoEnAnchura();

    }

}
