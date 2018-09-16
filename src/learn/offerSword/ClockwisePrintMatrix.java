package learn.offerSword;

import java.util.ArrayList;
/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.*/
public class ClockwisePrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix == null || matrix[0] == null) return list;
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        while(left<=right && top<=bottom){
            for(int i = left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            for(int i = top+1;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            for(int i = right-1;i>=left&&top<bottom;i--){
                list.add(matrix[bottom][i]);
            }
            for(int i = bottom-1;i>top&&left<right;i--){
                list.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }

    /**
     * 可以模拟魔方逆时针旋转的方法，一直做取出第一行的操作*/
}
