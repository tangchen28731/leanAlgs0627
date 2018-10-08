package learn;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * 已知从山脚到山顶共有 m 个台阶，一次可爬 a ~ b 个台阶，由于年久失修，
 * 部分台阶已坏无法站立，已知坏的台阶共有 n 个并给出所在位置，问共有多少种登山方案
 * （如果无法登上山顶返回0，结果大于 10^9 + 7 则返回除以 (10^9 + 7) 后的余数）？
 * 台阶总数 m，一次最少可爬台阶数 a，一次最大可爬台阶数 b，坏掉的台阶数量n，如果n不等于0，之后n行为坏掉台阶的编号，编号从 1 开始
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int m = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int[] arr;
            if (n == 0) {
                arr = new int[1];
                arr[0] = 0;
            } else {
                arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
            }


            int[] narr = new int[m + 1];
            narr[0] = 0;
            int k = 0;
            for (int j = a; j <= b; j++) {
                if (k < arr.length && arr[k] == j) {
                    k++;
                } else {
                    for (int z = j; z >= a; z--) {
                        narr[j] += narr[j - z];
                    }
                    narr[j] += 1;
                }
            }

            for (int i = b + 1; i < narr.length; i++) {
                if (k < arr.length && arr[k] == i) {
                    k++;
                } else {
                    for (int z = b; z >= a; z--) {
                        narr[i] += narr[i - z];
                    }
                }
            }

            for (int i = 0; i < narr.length; i++) {
                System.out.print(narr[i] + " ");
            }
            System.out.println(narr[m]);
        }
    }
}
/*
 * 玩家小豆是一位魔兽世界玩家，里面每件装备有装备等级的概念，装备等级越高游戏角色越厉害，现在小豆手中有n个金币，但身上最多穿m件装备，每件装备的对应的价格x金币，对应的装备等级是y。现在小豆想要用手中的金币买到装备等级最大的装备组合。问小豆能买到最大的装备等级。
 * */

/*
* Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int m = in.nextInt();
            TreeMap<Double,Integer> map = new TreeMap<>();
            for(int i = 0;i<m;i++){
                int fkey = in.nextInt();
                int val = in.nextInt();
                double key = (double) val/fkey;
                val = fkey;
                map.put(key,val);
            }

        }*/
