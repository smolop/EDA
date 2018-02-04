package estructuras.vectores;

import java.util.Scanner;

public class OrdenarVectoresParalelos {

    private String[] paises;
    private int[] cantidadHabitantes;
    private int[] key;
    private Scanner input;

    OrdenarVectoresParalelos(int cantidadPaises){
        paises = new String[cantidadPaises];
        cantidadHabitantes = new int[cantidadPaises];
        key = new int[cantidadPaises];
        input = new Scanner(System.in);
    }


    private void ingresarPaises(){
        System.out.printf("\nIngrese el nombre de los paises: \n");
        for(int i = 0; i < paises.length; i++) {
            System.out.printf("\n Ingrese el elemento i-esimo | i = %d: ", i);
            paises[i] = input.next();
            key [i] = i;
        }
    }

    private void ingresarHabitantes() {
        System.out.printf("\nIngrese la cantidad de habitantes de los paises");
        for (int i = 0; i < cantidadHabitantes.length; i++) {
            System.out.printf("\nIngrese los habitantes del elemento i-esimo | i = %d referente a %s: ", i, paises[i]);
            cantidadHabitantes[i] = input.nextInt();
        }
    }

    void imprimirEnOrdenPais(){
        ordenacionDicotomica();
        for (int e = 0; e < key.length; e++)
            System.out.printf("\n Pais: %s, Habitantes: %d ",paises[key[e]], cantidadHabitantes[key[e]]);
    }

    private void ordenacionDicotomica(){
        String [] origen = new String[paises.length];
        for (int i = 0; i < paises.length; i++)
            origen[i] = paises[i];
        ordenacionDicotomica(paises, key, 0, paises.length - 1);
        for (int i = 0; i < paises.length; i++)
            paises[i] = origen[i];
    }


    private void ordenacionDicotomica(String[] v, int[] key, int start, int end){
        if(start < end) {
            int middle = (end + start) / 2;
            ordenacionDicotomica(v, key, start, middle);
            ordenacionDicotomica(v, key, middle + 1, end);
            merge(v, key, start, middle, end);
        }
    }

    static void merge(String[] v, int[] key, int start, int middle, int end){
        int s, m, s2;
        String [] vAux = new String[v.length]; //array auxiliar
        int[] keyAux = new int[key.length];
        for (s=start; s<=end; s++) { //copia ambas mitades en el array auxiliar
            vAux[s] = v[s];
            keyAux[s] = key[s];
        }
        s=start; m=middle+1; s2=start;
        while (s<=middle && m<=end) { //copia el siguiente elemento más grande
            if (vAux[s].compareTo(vAux[m]) <= 0) {
                key[s2] = keyAux[s];
                v[s2++] = vAux[s++];
            } else {
                key[s2] = keyAux[m];
                v[s2++] = vAux[m++];
            }
        }
        while (s<=middle) { //copia los elementos que quedan de la
            key[s2] = keyAux[s];
            v[s2++] = vAux[s++]; //primera mitad (si los hay)
        }
    }

    public static void main(String[] argv){
        OrdenarVectoresParalelos v = new OrdenarVectoresParalelos(5);
        v.ingresarPaises();
        v.ingresarHabitantes();
        v.imprimirEnOrdenPais();
    }

}
