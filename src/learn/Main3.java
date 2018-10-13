package learn;


import javax.annotation.processing.SupportedSourceVersion;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
/**
 * 题目描述：
 * 有一把魔法权杖，权杖上有n颗并排的法术石（编号为1到n）。每颗法术石具有一个能量值，权杖的法术强度等同于法术石的最小能量值。权杖可以强化，一次强化可以将两颗相邻的法术石融合为一颗，融合后的能量值为这两颗法术石能量值之和。现在有m次强化的机会，请问权杖能强化到的最大法术强度是多少？
 *
 * 输入
 * 第一行包含两个正整数n，m，表示n颗法术石，m次强化机会。
 *
 * 第二行为n个用空格隔开的正整数v1, v2, … ,vn，vi表示编号为i的法术石具有的能量值。
 *
 * 数据范围：1≤m<n≤100000，1≤vi≤100000
 *
 * 输出
 * 输出1个整数，表示权杖的最大的法术强度。
 *
 *
 * 样例输入
 * 6 3
 * 1 7 2 2 5 9
 * 样例输出
 * 8
 *
 * Hint
 * 样例说明：合并1、7得到 { 8 2 2 5 9 }，合并2、2得到 { 8 4 5 9 }，合并4、5得到 { 8 9 9 }，法术强度等于8。*/
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = in.nextInt();
            }
            if(m == arr.length){
                int res = 0;
                for(int i = 0;i<m;i++){
                    res+=arr[i];
                }
                System.out.println(res);
                continue;
            }

            for(int i = 0;i<m;i++){
                int min = Integer.MAX_VALUE;
                int minIndex = -1;
                for(int j = 0;j<n;j++){
                    if(arr[j]!=0 &&  arr[j] < min){
                        min = arr[j];
                        minIndex = j;
                    }
                }
                int lo = minIndex-1;
                int hi = minIndex+1;
                while(lo>=0 && arr[lo]==0) lo--;
                while(hi<arr.length && arr[hi]==0) hi++;
                int rIndex = lo;
                if((lo!=-1?arr[lo]:Integer.MAX_VALUE) > (hi!=arr.length?arr[hi]:Integer.MAX_VALUE)){
                    rIndex = hi;
                }
                arr[minIndex] += arr[rIndex];
                arr[rIndex] = 0;
            }

            int res = Integer.MAX_VALUE;
            for(int i = 0;i<n;i++){
                if(arr[i]!=0 && arr[i] < res){
                    res = arr[i];
                }
            }
            System.out.println(res);
        }
    }


}
