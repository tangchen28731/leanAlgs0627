package learn.offerSword;

import java.util.ArrayList;
import java.util.List;
/**
 *把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 首先从丑数的定义我们知道，一个丑数的因子只有2,3,5，那么丑数p = 2 ^ x * 3 ^ y * 5 ^ z，换句话说一个丑数一定由另一个丑数乘以2或者乘以3或者乘以5得到，那么我们从1开始乘以2,3,5，就得到2,3,5三个丑数，在从这三个丑数出发乘以2,3,5就得到4，6,10,6，9,15,10,15,25九个丑数，
 * 我们发现这种方法会得到重复的丑数，而且我们题目要求第N个丑数，
 * 这样的方法得到的丑数也是无序的。那么我们可以维护三个队列
 *
 * 实现思路：
 * 我们没有必要维护三个队列，只需要记录三个指针显示到达哪一步
 * */
public class GetUglyNumber {
    //优秀的方法
    public int GetUglyNumber_Solution(int index) {
        if(index<7) return index;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        List<Integer> list = new ArrayList<>();
        int newNum = 1;
        list.add(1);
        while(list.size()<index){
            newNum = Math.min(list.get(t2)*2,Math.min(list.get(t3)*3,list.get(t5)*5));
            if(newNum == list.get(t2)*2) t2++;
            if(newNum == list.get(t3)*3) t3++;
            if(newNum == list.get(t5)*5) t5++;
            list.add(newNum);
        }
        return newNum;
    }

    //效率太低
    public int getUglyNumber_Solution(int index) {
        int now = 1;
        int sign = 1;
        for(int i = 2;;i++){
            int val = i;
            while(val%2 == 0) val =val/2;
            while(val%3 == 0) val =val/3;
            while(val%5 == 0) val =val/5;
            if(val==1) sign ++;
            if(sign == index){
                return i;
            }
        }
    }

    public static void main(String[] args) {
        GetUglyNumber getUglyNumber = new GetUglyNumber();
        System.out.println(getUglyNumber.getUglyNumber_Solution(1000));
    }
}
