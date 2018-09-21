package learn.base100Algs;
/**
 * 一个数如果恰好等于它的因子之和，这个数就称为“完数”。例如6=1＋2
 * ＋3.编程找出1000以内的所有完数。*/
public class CompleteNum {
    public static void main(String[] args) {
        int n = 1000;
        while(n>0){
            int val = n;
            for(int i = 1;i<n;i++){
                if(n%i == 0){
                    val -= i;
                }
            }
            if(val==0){
                System.out.print(n+" ");
            }
            n--;
        }
    }
}
