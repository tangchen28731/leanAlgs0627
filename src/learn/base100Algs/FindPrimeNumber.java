package learn.base100Algs;
/**
 * 在网上看到很多找质数的算法，都是检查从2到n-1的数能否被n整除，能就不是质数，
 * 反之就是素数，这样做当然是正确的，但是浪费了一些没有必要的检查，
 * 其实只要检查从2到sqrt（n）之间的数就可以了，
 *
 * 因为如果一个数有因子的话，那么它必定有一个因子不大于该数的平方根。！！！！
 *
 *
 * 由于一个合数总是可以分解成若干个质数的乘积，那么如果把质数（最初只知道2是质数）的倍数都去掉，
 * 那么剩下的就是质数了。
 * 例如要查找100以内的质数，首先2是质数，把2的倍数去掉；
 * 此时3没有被去掉，可认为是质数，所以把3的倍数去掉；再到5，再到7，7之后呢，
 * 因为8，9，10刚才都被去掉了，而100以内的任意合数肯定都有一个因子小于10（100的开方），
 * 所以，去掉，2，3，5，7的倍数后剩下的都是质数了。*/
public class FindPrimeNumber {
    public static void main(String[] args) {
        int n = 100;
        boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++)  isPrime[i] = true;
        for(int i = 2;i<=Math.sqrt(n);i++){
            if(isPrime[i]){
                for(int j = i;j*i<=n;j++) isPrime[i*j] = false;
            }
        }
        for(int i = 0;i<=n;i++){
            if(isPrime[i]){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
}
