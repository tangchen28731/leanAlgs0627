package learn.offerSword;
/**
 * 统计一个数字在排序数组中出现的次数。*/
public class GetNumberOfK {
    public static void main(String[] args) {
        GetNumberOfK getNumberOfK = new GetNumberOfK();
        int[] arr = {3,3,3,3,4,5};
        System.out.println(getNumberOfK.GetNumberOfK2(arr,3));
    }
    public int GetNumberOfK2(int [] array , int k) {
        if(array == null || array.length == 0) return 0;
        int ind = findBinary(array,0,array.length-1,k);
        if(ind == -1) return 0;
        int i = ind;
        int j = ind;
        while(i>=0 && array[i] == k) i--;
        while(j<array.length && array[j] == k) j++;
        return j-i-1;
    }

    public int findBinary(int[] array,int i,int j,int k){


        while(i<=j){
            int mid = (i+j)/2 ;
            if(array[mid] == k) return mid;
            else if(array[mid] > k) j = mid-1;
            else i = mid+1;
        }
        return -1;
    }

    public int GetNumberOfK3(int [] array , int k) {
        int res = 0;
        for(int i = 0; i<array.length;i++){
            if(array[i] == k){
                res++;
            }else{
                if(res!=0){
                    break;
                }
            }
        }
        return res;
    }
}
