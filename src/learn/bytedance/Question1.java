package learn.bytedance;

import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int a = in.nextInt();
            int b = in.nextInt();
            int res = 0;
            for(int i = a;i<=b;i++){
                String s = i+"";
                int len = s.length();

                if(len>1){
                    int j = 0;
                    while(j<=(len-1-j) && s.charAt(j) == s.charAt(len-1-j)) j++;
                    if(j <= len-1-j) res++;
                }else {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
