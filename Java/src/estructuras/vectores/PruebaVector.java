package estructuras.vectores;

import java.util.Scanner;

class PruebaVector {

    private Scanner input;
    private float[] vector1;
    private float[] vector2;
    private float[] sumatorioUnivocoVector;

    PruebaVector(){
        vector1 = new float[4];
        vector2 = new float[4];
        sumatorioUnivocoVector = new float[vector1.length];
        input = new Scanner(System.in);
    }

    private void cargarVector (float[] v){
        for (int i = 0; i < 4; i++){
            System.out.printf("\n Ingrese el elemento i-esimo | i = %d :\n",i);
            v[i] = input.nextFloat();
        }
    }

    private void sumatorioUnivoco(){
        System.out.printf("\n El resultado de la suma de ambos vectores es \n");
        for (int i = 0; i < vector1.length ; i++)
            System.out.printf("\n %.2f", sumatorioUnivocoVector[i] = vector1[i] + vector2[i]);
    }

    void cargarVectores (){
        System.out.printf("\n Cargar el primer vector: \n");
        cargarVector(vector1);

        System.out.printf("\n Cargar el segundo vector: \n");
        cargarVector(vector2);

        sumatorioUnivoco();
    }

    public static void main(String[] argv){

        PruebaVector exec = new PruebaVector();
        exec.cargarVectores();

    }

}
