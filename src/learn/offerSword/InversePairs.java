package learn.offerSword;
/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 更好的做法 O(n) 利用 归并的思想*/


public class InversePairs {
    //归并的解法  我写的
    public static void main(String[] args) {
        InversePairs inversePairs = new InversePairs();
        int[] arr = {1,2,3,4,5,6,7,0,2,3};
        System.out.println(inversePairs.InversePairs(arr));
    }

    private long res;
    public int InversePairs(int [] array) {
        if(array.length == 0) return 0;
        res = 0;
        pari(array,0,array.length-1);
        return (int)(res%1000000007);
    }

    public void pari(int[] arr, int i,int j){
        if(i == j) return;
        int mid = (i+j)/2;
        pari(arr,i,mid);
        pari(arr,mid+1,j);
        merge(arr,i,mid,j);
    }

    public void merge(int[] arr,int i,int mid,int j){
        int li = i;
        int ll = mid;
        int ri = mid+1;
        int rl = j;
        int[] temarr = new int[j-i+1];
        int ti = j-i;
        while(li<=ll || ri <= rl){
            if(li > ll && ri <= rl){
                temarr[ti--] = arr[rl--];
            }
            else if(li <= ll && ri > rl){
                temarr[ti--] = arr[ll--];
            }
            else if(arr[ll] >= arr[rl]){
                temarr[ti--] = arr[ll--];
            }
            else{
                res += rl-ri+1;
                temarr[ti--] = arr[rl--];
            }
        }
        int ci = i;
        for(int k = 0;k<j-i+1;k++){
            arr[ci] = temarr[k];
            ci++;
        }
    }

    //只有50%不超时
    public int inversePairs(int [] array) {
        long res = 0;
        for(int i = 1;i<array.length;i++){
            int j = i;
            while(j>0 && array[j] < array[j-1]){
                exch(array,j,j-1);
                j--;
            }
            res += i-j;
        }
        return (int)(res%1000000007);
    }

    public void exch(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
