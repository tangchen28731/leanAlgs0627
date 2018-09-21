package learn.bytedance;

import java.util.Scanner;

public class Question2 {
    private static int res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            res = 0;
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            count(a,b,c);
            System.out.println(res);
        }

    }

    public static void count(int a,int b,int c){
        if(a == 0 && b==0 && c==0){
            res++;
            return;
        }
        if(a!=0) count(a-1,b,c);
        if(b!=0) count(a,b-1,c);
        if(c!=0) count(a,b,c-1);

    }
}
