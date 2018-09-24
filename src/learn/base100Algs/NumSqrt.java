package learn.base100Algs;

public class NumSqrt {
    public static void main(String[] args) {

        double n = 18;
        double k = n/2;
        while(Math.abs(k*k-n)>1e-9){
            k = (k+n/k)/2;
            System.out.println(k);
        }

    }
}
