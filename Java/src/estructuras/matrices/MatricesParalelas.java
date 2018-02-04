package estructuras.matrices;

public class MatricesParalelas {

    private String [] employes;
    private float [][] salaries;

    MatricesParalelas(){
        employes = new String[]{"employe_0", "employe_1", "employe_2"};
        salaries = new float[][] {{4500, 8500, 9500}, {4501, 8501, 9501}, {4502, 8502, 9502}};
    }

    void printEmployesSalaries(){
        for (int i = 0; i < employes.length; i++) {
            System.out.printf("\n> Employe name: %s \n", employes[i]);
            float add = 0;
            for (float s: salaries[i]) {
                System.out.printf("\n   Employe salarie: %.2f \n", s);
                add +=s;
            }
            System.out.printf("\n  Employe total salaries: %.2f \n", add);
        }
    }

    public static void main(String [] argv){
        MatricesParalelas m = new MatricesParalelas();
        m.printEmployesSalaries();
    }

}
