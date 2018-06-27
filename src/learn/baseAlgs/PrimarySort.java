package learn.baseAlgs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.File;
import java.util.Date;


public class PrimarySort {

    /**
     *  选择排序
     *  不断地选择剩余元素中的最小值。
     *  找到数组中最小元素与数组第一个元素交换位置，、
     *  再在剩下元素中找到最小的确定第二个元素......
     *  */
    public static void selectionSort(Comparable[] a) {
        for(int i = 0; i < a.length-1; i++){
            int minNum = i;
            for(int j = i+1; j < a.length; j++){
                if(less(a[j],a[minNum])){
                    minNum = j;
                }
            }
            exch(a,i,minNum);
        }
    }

    /**
     * 插入排序
     * 从左至右将每个元素通过相邻交换插入到左侧的有序数组中，
     * 类似整理扑克牌。
     * */
    public static void insertionSort(Comparable[] a){
        for (int i = 1; i < a.length; i++){
            int j = i;
            while(j>0 && less(a[j],a[j-1])){
                exch(a,j-1,j);
                j--;
            }
        }
    }

    /**
     * 希尔排序
     * 基于插入排序的排序算法，交换不相邻元素局部排序，
     * 最后再整体插入排序。
     * 思想是使数组中任意间隔为h的元素都是有序的
     * */
    public static void shellSort(Comparable[] a){
        int len = a.length;
        int h = 1;
        while(h < len/3){
            h = 3*h +1;
        }
        while(h >= 1){
            for(int i = h; i < len; i++){

            }
        }
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t =a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        //打印数组 单行
        for (int i = 0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        for(int i = 1; i < a.length; i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        File file = new File("C:/test/1.txt");
        In in = new In(file);
        String[] a = in.readAllStrings();
        long start = System.currentTimeMillis();
        String[] b = a.clone();
        selectionSort(b);
        show(b);
        long a1 = System.currentTimeMillis();
        System.out.println(a1-start);
        String[] c = a.clone();
        insertionSort(c);
        show(c);
        long a2 = System.currentTimeMillis();
        System.out.println(a2-a1);
    }

}
