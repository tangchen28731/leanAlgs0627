package learn.offerSword;
/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 利用位运算 异或 或 与的操作
 * 常见的二进制操作有：
 *
 * */
public class Add {
    public int Add(int num1,int num2) {
        int res = num1;
        int n = num2;
        while(n!=0){
            int tem = res;
            res = tem ^ n;
            n = (tem & n) << 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Add add = new Add();
        System.out.println(add.Add(3,7));
    }
}
