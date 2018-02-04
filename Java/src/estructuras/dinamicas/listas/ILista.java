package estructuras.dinamicas.listas;

import estructuras.dinamicas.listas.colas.Cola;

public interface ILista extends IList{

    void insertar(Integer obj);

    Object extraer();

    void exec();

}
