package learn.offerSword;
/*
* 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
* 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？*/
public class MovingCount {
    boolean[][] sign;
    int val = 0;
    public int movingCount(int threshold, int rows, int cols)
    {
        sign = new boolean[rows][cols];
        tmove(threshold, rows, cols, 0, 0);
        return val;
    }

    public void tmove(int threshold, int rows, int cols,int i,int j){

        if(i<0 || i>=rows || j<0 || j>=cols) return;

        if(sign[i][j]) return;
        System.out.println(i+"-"+j);
        int sum = 0;
        int c = 0;
        int ti = i;
        while(ti!=0){
            c = ti%10;
            ti = ti/10;
            sum+=c;
        }
        int tj = j;
        while(tj!=0){
            c = tj%10;
            tj = tj/10;
            sum+=c;
        }
        sign[i][j] = true;
        if(sum <= threshold){
            val++;
            /*tmove(threshold, rows, cols, i-1, j);
            tmove(threshold, rows, cols, i, j-1);*/
            tmove(threshold, rows, cols, i, j+1);
            tmove(threshold, rows, cols, i+1,j);
        }


    }

    public static void main(String[] args) {
        MovingCount mc = new MovingCount();
        System.out.println(mc.movingCount(10,3,3));

    }
}
/*
* 链接：https://www.nowcoder.com/questionTerminal/6e5207314b5241fb83f2329e89fdecc8
来源：牛客网

public class Solution {

    public int movingCount(int threshold, int rows, int cols) {
        int flag[][] = new int[rows][cols]; //记录是否已经走过
        return helper(0, 0, rows, cols, flag, threshold);
    }

    private int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j)  > threshold || flag[i][j] == 1) return 0;
        flag[i][j] = 1;
        return helper(i - 1, j, rows, cols, flag, threshold)
            + helper(i + 1, j, rows, cols, flag, threshold)
            + helper(i, j - 1, rows, cols, flag, threshold)
            + helper(i, j + 1, rows, cols, flag, threshold)
            + 1;
    }

    private int numSum(int i) {
        int sum = 0;
        do{
            sum += i%10;
        }while((i = i/10) > 0);
        return sum;
    }
}*/