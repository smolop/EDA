package estructuras.dinamicas.listas;

public interface IList {

    boolean esVacio(Nodo nodo);

    boolean tieneSiguiente(Nodo nodo);

    int getCantidadNodos();

    void imprimirTodo();

}
