package learn.tencent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class Tencent2018 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int k = 0;k<t;k++){
            /* LCM(2) = 2, LCM(4, 6) = 12, LCM(1, 2, 3, 4, 5, 6) = 60。
            牛牛给出一个正整数n, 让小Q计算出最小的大于n的正整数m,
            使其满足: LCM(n+1, n+2, ..., m) = LCM(1, 2, ..., m)。
               例如：牛牛给出的正整数n = 3, 那么m = 6,
               因为LCM(4, 5, 6) = LCM(1, 2, 3, 4, 5, 6) = 60,
               并且这个m是最小的大于n的正整数。 */
        }

    }



}
/*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] matrix = new int[n][n];
            for(int k = 0;k<m;k++){
                int i = in.nextInt()-1;
                int j = in.nextInt()-1;
                matrix[i][j] = 1;
            }
            HashMap<Integer,List<Integer>> xmap = new HashMap<>();
            HashMap<Integer,List<Integer>> ymap = new HashMap<>();
            for(int k = 0;k<n;k++){
                List<Integer> list1 = new ArrayList<>();
                xmap.put(k,list1);
                List<Integer> list2 = new ArrayList<>();
                ymap.put(k,list2);
            }
            for(int k = 0;k<n;k++){
                count(matrix,xmap,ymap,k,k,n);
            }
            int res = 0;
            for(int i = 0;i<n;i++){
                if(ymap.get(i).size()>xmap.get(i).size()){
                    res++;
                }
            }
            System.out.println(res);
        }

    }
    public static void count(int[][] matrix,HashMap<Integer,List<Integer>> xmap,HashMap<Integer,List<Integer>> ymap,int goal,int now,int n){
        for(int i=0;i<n;i++){
            if(matrix[now][i] == 1){
                List<Integer> list = xmap.get(goal);
                List<Integer> list2 = ymap.get(i);
                if(list.contains(i)){
                    continue;
                }else{
                    list.add(i);
                    list2.add(goal);
                    xmap.put(goal,list);
                    ymap.put(i,list2);
                    count(matrix,xmap,ymap,goal,i,n);
                }
            }
        }
    }*/


    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int k = 0;k<t;k++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int sign = 0;
            for(int i = 0;i<100;i++){
                if((i*a % b) == c){
                    System.out.println("YES");
                    sign = 1;
                    break;
                }
            }
            if(sign == 0){
                System.out.println("NO");
            }
        }

    }

    public static boolean isRight(int b,int c,int sum){
        return (sum%b) == c;
    }*/