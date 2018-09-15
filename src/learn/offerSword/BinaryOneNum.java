package learn.offerSword;
/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。*/
public class BinaryOneNum {
    //也可以右移来做 要注意 负数时右移补1
    // 把一个整数减去1，再和原整数做与运算，
    // 会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
    //--------------------最优解----------------------------
    public static int NumberOf1_3(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }

    public int NumberOf1_2(int n) {
        int a = n<0?n^Integer.MIN_VALUE:n;
        int oneNum = 0;
        while(a!=0){
            if(a%2==1){
                oneNum++;
            }
            a = a/2;
        }
        return n<0? oneNum+1 : oneNum;
    }
    public int NumberOf1(int n) {
        boolean sign = true;
        if(n<0){
            n=-n;
            sign = false;
        }
        int zs = 0;//用来标记是否结束计算辗转得到的0的长度
        int znum = 0;//辗转得到的0的长度 即补码的末尾的连续的1的个数
        int oneNum = 0;//计算辗转中1的数目
        while(n!=0){
            if(n%2 == 1){
                oneNum++;
                zs = 1;
            }else if(zs == 0){
                znum ++;
            }
            n = n/2;
        }
        //负数时加上符号位
        int res = !sign ? 32-oneNum:oneNum;
        if(!sign){
            if(znum>0){//补码的末尾是1 需要加1进位
                if(res == 32){
                    return 1;
                }
                return res - znum + 1;
            }else{//补码的末尾是0
                return res+1;
            }
        }
        return res;
    }
}
