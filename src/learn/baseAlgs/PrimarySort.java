package learn.baseAlgs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
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
        int h = 1;//h为该次插入排序的元素间隔
        while(h<len/3) h=h*3+1;
        while (h>=1) {
            for(int i = h; i < len; i++){
                int j = i;
                while(j>=h && less(a[j],a[j-h])){
                    exch(a,j,j-h);
                    j = j-h;
                }
            }
            h = h/3;
        }
    }

    /**
     * 归并排序 - 自顶向下
     * 将数组（递归）分成两半分别排序再归并
    * */
    private static Comparable[] aux;
    public static void mergeUpDownSort(Comparable[] a){
        int len = a.length;
        aux = new Comparable[len];
        mergeUpDownSort(a, 0, len-1);
    }
    private static void mergeUpDownSort(Comparable[] a, int lo, int hi){
        if(hi<=lo) return;
        int mid = lo + (hi - lo)/2;
        mergeUpDownSort(a, lo, mid);
        mergeUpDownSort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }
    /* 归并排序中用于归并的方法 先复制到辅助数组再归并 */
    private static void merge(Comparable[] a, int lo, int mid, int hi){
       for(int k = lo; k < a.length; k++){
           aux[k] = a[k];
       }
       int i = lo;
       int j = mid+1;
       for(int k = lo; k < a.length; k++){
           if(i>mid) a[k] = aux[j++];
           else if(j>hi) a[k] = aux[i++];
           else if(less(aux[i],aux[j])) a[k] = aux[i++];
           else a[k] = aux[j++];
       }
    }
    /**
     * 归并排序 - 自底向上
     * 先归并微型数组再成对归并
     * */
    private static Comparable[] aux2;
    public static void mergeDownUpSort(Comparable[] a){
        int len = a.length;
        aux2 = new Comparable[len];
        for(int sz = 1; sz < len; sz= sz+sz){
            for(int lo = 0; lo < len-sz; lo +=sz+sz){
                mergeDU(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, len-1));
            }
        }
    }
    /* 归并排序中用于归并的方法 先复制到辅助数组再归并 */
    private static void mergeDU(Comparable[] a, int lo, int mid, int hi){
        for(int k = lo; k < a.length; k++){
            aux2[k] = a[k];
        }
        int i = lo;
        int j = mid+1;
        for(int k = lo; k < a.length; k++){
            if(i>mid) a[k] = aux2[j++];
            else if(j>hi) a[k] = aux2[i++];
            else if(less(aux2[i],aux2[j])) a[k] = aux2[i++];
            else a[k] = aux2[j++];
        }
    }
    /**
     * 改进的归并排序
     * 1.长度短的数组直接使用插入排序(例如长度小于15时)
     * 2.测试数组有序来跳过无用归并
     * 3.节省元素复制到辅助数组的时间
     * */
    public static void mergeSortOptimize(Comparable[] a){
        int len = a.length;
        Comparable[] b = a.clone();
        mergeSortOptimize(a, b,0, len-1);
    }
    public static void mergeSortOptimize(Comparable[] a,Comparable[] b,int lo,int hi){
        if(lo>=hi) return;
        int mid = lo + (hi-lo)/2;
        if(hi-lo<=15){
            //长度短的数组直接使用插入排序(例如长度小于15时)
            insertionSort(a);
            return;
        }
        mergeSortOptimize(b,a,lo,mid);
        mergeSortOptimize(b,a,mid+1,hi);
        if(less(a[mid],a[mid+1])){
            //测试数组有序来跳过无用归并
            mergeSO(a,b,lo,mid,hi);
        }
    }
    private static void mergeSO(Comparable[] a, Comparable[] b,int lo, int mid, int hi){
        int i = lo;
        int j = mid+1;
        for(int k = lo; k < a.length; k++){
            if(i>mid) a[k] = b[j++];
            else if(j>hi) a[k] = b[i++];
            else if(less(b[i],b[j])) a[k] = b[i++];
            else a[k] = b[j++];
        }
    }

    /**
     * 快速排序
     * 按大小切分数组，每次切分排定一个元素
     * */
    public static void quickSort(Comparable[] a){
        StdRandom.shuffle(a);
        quickSort(a,0,a.length-1);
    }
    public static void quickSort(Comparable[] a, int lo, int hi){
        if(hi<=lo){
            return;
        }
        int j = partition(a,lo,hi);
        quickSort(a,lo,j-1);
        quickSort(a,j+1,hi);
    }

    /*快速排序的切分*/
    private static int partition(Comparable[] a, int lo, int hi){
        int key = lo;
        int i = lo;
        int j = hi+1;
        while (true){
            while(less(a[++i],a[key])) if(i==hi) break;
            while(less(a[key],a[--j])) if(j==lo) break;
            if(i>=j) break;
            exch(a, i, j);
        }
        exch(a,j,lo);
        return j;
    }
/*    public static void quickSort(Comparable[] a, int lo, int hi){
        if(lo>=hi){
            return;
        }
        int key = lo;
        int i = lo;
        int j = hi;
        while (i<j){
            while(i<a.length&&(less(a[i],a[key]) || a[i]==a[key])){
                i++;
            }
            while(less(a[key],a[j])){
                j--;
            }
            if(i<j) {
                exch(a, i, j);
            }
        }
        int mid = Math.min(i,j);
        exch(a,key,mid);
        quickSort(a,lo,mid-1);
        quickSort(a,mid+1,hi);
    }*/

    /**
     * 改进的快速排序
     * 1.长度短的数组直接使用插入排序
     * 2.三取样
     * 3.针对大量重复数组*/


    /**
     * 堆排序
     * */


    /**
     * 排序的基础方法
     * */
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
        quickSort(c);
        show(c);
        long a2 = System.currentTimeMillis();
        System.out.println(a2-a1);
    }

}
