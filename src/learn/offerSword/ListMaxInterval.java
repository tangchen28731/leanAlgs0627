package learn.offerSword;
/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)*/
public class ListMaxInterval {

    //my
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<array.length;i++){
            int sum = 0;
            for(int j = i;j<array.length;j++){
                sum += array[j];
                max = sum > max? sum:max;
            }
        }
        return max;
    }
    // good  对于一个数A，若是A的左边累计数非负，那么加上A能使得值不小于A，认为累计值对
    //          整体和是有贡献的。如果前几项累计值负数，则认为有害于总和，total记录当前值。
    public int FindGreatestSumOfSubArray2(int[] array) {
        int max = Integer.MIN_VALUE;
        int cursum = 0;
        for(int i = 0;i<array.length;i++){
            if(cursum <= 0){//此时 当前数不会给之前的序列带来贡献
                cursum = array[i];
            }else{
                cursum += array[i];
            }
            if( cursum > max){
                max = cursum;
            }
        }
        return max;
    }

    // dp


    public  int FindGreatestSumOfSubArray3(int[] array) {
        int res = array[0]; //记录当前所有子数组的和的最大值
        int max=array[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max=Math.max(max+array[i], array[i]);
            res=Math.max(max, res);
        }
        return res;
    }
}
