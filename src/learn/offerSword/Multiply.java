package learn.offerSword;
/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 * */
public class Multiply {
    //my
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        for(int i=0,j=A.length-1;i<len;i++,j--){
            arr1[i] = i == 0?1:A[i-1]*arr1[i-1];
            arr2[j] = j == len-1?1:A[j+1]*arr2[j+1];
        }
        for(int i=0;i<len;i++){
            B[i] = arr1[i]*arr2[i];
        }
        return B;
    }
}
