package estructuras.grafos;

import java.util.ArrayList;

public class Grafo implements IGrafo {

    public int[][] g1 =
            {
                    {2, 1, 0, 1, 0},

                    {1, 2, 1, 0, 0},

                    {0, 1, 2, 1, 0},

                    {1, 0, 1, 2, 1},

                    {0, 0, 0, 1, 2}};
    public int[][] grafo = g1;

    private int n = grafo.length;
    private boolean[] visitadoEnProfundidad = new boolean[grafo.length];
    private boolean[] visitadoEnAnchura = new boolean[grafo.length];

    public int[][] getGrafo() {
        return grafo;
    }

    @Override
    public ArrayList recorrerEnAnchura(int nodo) {
        ArrayList<Integer> recorridos = new ArrayList<>();
        ArrayList<Integer> cola = new ArrayList<>();

        visitadoEnAnchura[nodo] = true;
        recorridos.add(nodo);
        cola.add(nodo);

        while (!cola.isEmpty()){
            int j = cola.remove(0);

            for (int i = 0; i < grafo.length ; i++)
                if (grafo[j][i] == 1 && !visitadoEnAnchura[i]){
                    visitadoEnAnchura[i] = true;
                    recorridos.add(i);
                    cola.add(i);
                }

        }

        return recorridos;
    }

    @Override
    public ArrayList recorrerEnProfundidad(int nodo) {
        ArrayList<Integer> recorridos = new ArrayList();
        ArrayList<Integer> cola = new ArrayList();

        visitadoEnProfundidad[nodo] = true;
        recorridos.add(nodo);
        cola.add(nodo);

        while (!cola.isEmpty()){
            int v = cola.remove(0);
            for (int v2 = 0; v2 < grafo.length; v2++) {
                if(grafo[v][v2] == 1 && !visitadoEnProfundidad[v2]){
                    cola.add(v2);
                    recorridos.addAll(recorrerEnProfundidad(v2));
                    visitadoEnProfundidad[v2] = true;
                }
            }
        }
        return recorridos;
    }

    public static void main(String [] argv){
        IGrafo g = new Grafo();
        ArrayList<Integer> anchura , profundidad;
        anchura = g.recorrerEnAnchura(0);
        profundidad = g.recorrerEnProfundidad(0);

        System.out.println("RECORRIDO EN ANCHURA: ");
        for (int e: anchura)
            System.out.println("Elemento: " + e);

        System.out.println("RECORRIDO EN PROFUNDIDAD: ");
        for (int e: profundidad)
            System.out.println("Elemento: " + e);

    }
}
