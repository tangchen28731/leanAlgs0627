package learn.base100Algs;

import edu.princeton.cs.algs4.Count;

/**
 * s=a+aa+aaa+aaaa+aa…a的值，其中a是一个数字。例如
 * 2+22+222+2222+22222(此时共有5个数相加)。*/
public class CountNum {
    public void cont(int a,int n){

        int res = 0;
        int nowA = 0;
        int count = n;
        while(count >0){
            nowA = a+nowA;
            res = res + nowA;
            a = a*10;
            count--;
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        CountNum countNum = new CountNum();
        countNum.cont( 2,5);
    }
}
