package learn.meiLiLianHe;

import java.util.Scanner;

public class Manin3Meili {
    private static int res ;
    /**
     * 有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。请设计一个算法，
     * 计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处多个case
            int a = in.nextInt();
            int b = in.nextInt();
            count(0,0,a+1,b+1);
            System.out.println(res);
        }
    }


    public static void count(int i,int j,int a,int b){
        if(i+1<a){
            count(i+1,j,a,b);
        }
        if(j+1<b){
            count(i,j+1,a,b);
        }
        if(i+1>=a && j+1>=b){
            res++;
        }
    }
}

