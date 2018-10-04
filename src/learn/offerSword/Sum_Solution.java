package learn.offerSword;
/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 利用 利用逻辑与的短路特性 或者 利用异常机制 或者利用二维数组计算元素长度 即为乘积 或者利用如结尾的方法    */
public class Sum_Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean sign =  (n>0) && ((sum += Sum_Solution(n-1)) > 0);
        return sum;
    }
}

/*
 * 链接：https://www.nowcoder.com/questionTerminal/7a0da8fc483247ff8800059e12d7caf1
 * 来源：牛客网
 *
 * 原理是把a拆成2的幂的和，a = 2^e0 + 2^e1 + 2^e2....
 * 那么 a * b = (2^e0 + 2^e1 + 2^e2+...) * b = b * 2^e0 + b * 2^e1 + b * 2^e2 + ...
 * = (b << e0) + (b << e1) + ....
 * //奇数返回0xffffffff，否则0
 * #define f(x) ((((x) & 1) << 31) >> 31)
 * class Solution {
 * public:
 *     int Sum_Solution(int n) {
 *         int a = n, b = n + 1, s = 0;
 *         //复制32次。。
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         s += b & f(a); a >>= 1; b <<= 1;
 *         return s >> 1;
 *     }
 * };*/