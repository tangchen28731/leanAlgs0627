package learn.offerSword;
/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。*/
public class TwoDimensionalArraySearch {
    public boolean Find(int target, int [][] array) {
        boolean res;
        if(array.length == 0 || array[0].length == 0){
            return false;
        }
        res = search(target,array,0,0);
        return res;
    }
    public boolean search(int target,int[][] array,int i,int j){
        if(i>=array.length || j>=array.length){
            return false;
        }
        if(array[i][j] == target){
            return true;
        }else if(array[i][j] > target){
            return false;
        }else{
            return search(target,array,i+1,j) || search(target,array,i,j+1);
        }
    }

    /**
     * 另一个思路：
     * 链接：https://www.nowcoder.com/questionTerminal/abc3fe2ce8e146608e868a70efebf62e
     * 来源：牛客网
     *
     * 思路：首先我们选择从左下角开始搜寻，(为什么不从左上角开始搜寻，
     * 左上角向右和向下都是递增，那么对于一个点，对于向右和向下会产生一个岔路；
     * 如果我们选择从左下脚开始搜寻的话，如果大于就向右，如果小于就向下)。
     */
}
