package learn.offerSword;

public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null || array.length<2) return;
        int num = 0;
        for(int i:array){
            num = num^i;
        }
        //求数字二进制最后一位1对应的数字
        int  n = num - (num&(num-1));
        for(int i:array){
            if((i&n) == 0){
                num1[0] ^= i;
            }else{
                num2[0] ^= i;
            }
        }

    }
}
