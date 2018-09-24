package learn.offerSword;
/**
 如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
 在遍历数组时保存两个值：一是数组中一个数字，一是次数。遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；
 若次数为0，则保存下一个数字，
 并将次数置为1。遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可。

 还是分形叶思路

 采用用户“分形叶”思路（注意到目标数 超过数组长度的一半，对数组同时去掉两个不同的数字，
 到最后剩下的一个数就是该数字。如果剩下两个，那么这两个也是一样的，就是结果），在其基础上把最后剩下的一个数字或者两个回到原来数组中，
 将数组遍历一遍统计一下数
 * */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        int res = array[0];
        int sign = 1;
        for(int i = 1;i<array.length;i++){
            if(sign == 0){
                res = array[i];
                sign = 1;
            }else if(array[i] != array[i-1]){
                sign --;
            }else{
                sign ++;
            }

        }
        sign = 0;
        for(int i=0;i<array.length;++i)
        {
            if(array[i] == res) sign++;
        }

        return (sign > array.length/2) ? res : 0;
    }
}
