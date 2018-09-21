package learn.base100Algs;

public class NumSqrt {
    public static void main(String[] args) {
        double k = 1.0;
        double n = 2;
        while(Math.abs(k*k-n)>1e-9){
            k = (k+n/k)/2;
            System.out.println(k);
        }

    }
}
