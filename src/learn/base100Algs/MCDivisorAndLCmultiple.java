package learn.base100Algs;
/**
 * 求其最大公约数和最小公倍数*/
public class MCDivisorAndLCmultiple {
    public void count(int m,int n){
        int divisor = 0;
        int multiple = 0;
        //求最小公倍数 还是要依靠最大公约数

        if(m<n){
            int temp = m;
            m = n;
            n = temp;
        }

        int num1 = m;
        int num2 = n;
        while(m%n != 0 ){
            int temp = m;
            m = n;
            n = temp%n;
        }

        System.out.println(n);

        System.out.println(num1 * num2 / n);
    }

    public static void main(String[] args) {
        MCDivisorAndLCmultiple mc = new MCDivisorAndLCmultiple();
        mc.count(15,27);
    }
}
