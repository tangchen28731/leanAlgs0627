package learn.offerSword;
/**
 * 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。*/
public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int div = 1;
        int res = 0;
        while(div <= n){
            int a = n/div;//loc为a的最后一位
            int b = n%div;//剩余的位
            int loc = a%10;//当前位 第一次是个位
            if(loc >=2){
                res += (a/10 + 1)*div;
            }else if(loc == 1){
                res += (a/10)*div + b + 1;
            }else{
                res += a/10*div;
            }
            div *= 10;
        }
        return res;
    }
}
