package learn.offerSword;

import java.util.ArrayList;
/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 2 sum 问题*/
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array.length == 0) return list;
        int lo = 0;
        int hi = array.length-1;

        while(lo<hi){
            if(array[lo] + array[hi] > sum){
                hi--;
            }else if(array[lo] + array[hi] < sum){
                lo++;
            }else{
                list.add(array[lo]);
                list.add(array[hi]);
                break;
            }
        }
        return list;
    }
}
