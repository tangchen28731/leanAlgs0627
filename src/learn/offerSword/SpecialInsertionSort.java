package learn.offerSword;
/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。*/
public class SpecialInsertionSort {
    public void reOrderArray(int [] array) {
        int[] a = array;
        for(int i = 0;i<array.length;i++){
            int j = i;
            while(j>0&&compare(a[j-1],a[j])){
                int temp = a[j-1];
                a[j-1] = a[j];
                a[j] = temp;
                j--;
            }

        }
    }
    public boolean compare(int n,int m){
        boolean even1= n%2 == 0;
        boolean even2= m%2 == 0;
        if (even1 && !even2) return true;
        else return false;
    }
}
