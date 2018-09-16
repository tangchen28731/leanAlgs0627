package learn.offerSword;
/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。*/
public class BinarySearchTreePOTraversal {
    public boolean VerifySquenceOfBST(int [] sequence) {

        return sequence.length>0 && verify(sequence,0,sequence.length-1);
    }
    public boolean verify(int[] arr,int i,int j){
        int p = -1;
        int k = i;
        if(k >= j) return true;
        while(k<j){
            int tem = k;
            if(p==-1 && arr[k]<arr[j]){
                k++;
            }else if(arr[k]>arr[j]){
                if(k==0 || arr[k-1]<arr[j]){
                    p = k;
                }
                k++;
            }
            if(tem == k){
                return false;
            }
        }
        if(p == -1){
            p = j;
        }
        return verify(arr,i,p-1) && verify(arr,p,j-1);
    }
}
