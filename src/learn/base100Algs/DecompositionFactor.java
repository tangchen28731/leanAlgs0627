package learn.base100Algs;
/**
 * 程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完
 * 成：
 * (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
 * (2)如果n<>k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正
 * 整数你n,重复执行第一步。
 * (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。*/
public class DecompositionFactor {

    public void count(int n){
        int val = n;
        for(int i = 2;i<=n;i++){//
            while(i!=val){//如果这个质数恰等于n，则说明分解质因数的过程已经结束
                if(val%i == 0){
                    System.out.print(i+" ");
                }else break;
                val = val/i;
            }
        }
        System.out.print(val);
    }

    public static void main(String[] args) {
        DecompositionFactor decompositionFactor = new DecompositionFactor();
        decompositionFactor.count(100);
    }
}
