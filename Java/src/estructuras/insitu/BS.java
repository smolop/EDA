package estructuras.insitu;

public class BS {

    int[] v;

    BS(int[] v){
        this.v = v;
    }

    public int bs(int x){
        int n = v.length - 1;
        int inf = 0;
        int sup = n;
        while(inf <= sup){
            int centro = (sup+inf)/2;
            if(v[centro] == x)
                return  centro;
            if(x < v[centro])
                sup = centro - 1;
            if(x > v[centro])
                inf = centro + 1;
        }
        return -1;
    }

    public static void main(String[] argv){
        System.out.println("Start...");
        int[] v = {0,1,5,7,8,9,10,11,12};
        BS bs = new BS(v);
        int r = bs.bs(7);
        System.out.println("La posición del elemento dado es: " + r);
        System.out.println("Finished...");
    }

}
