package learn.offerSword;

public class Fibonacci {
    public int Fibonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }


    //更好的方法：


    public int Fibonacci2(int n) {
        int f = 0, g = 1;
        while(n>0) {
            g += f;
            f = g - f;
            n--;
        }
        return f;
    }
}
