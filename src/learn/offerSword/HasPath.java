package learn.offerSword;
/**
* 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
* 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。*/
public class HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(str.length == 0 || matrix.length == 0) return false;
        for(int i = 0;i<matrix.length;i++){
            if(matrix[i] == str[0]){
                //调用查询函数
                if(str.length == 1) return true;
                boolean res = find(matrix,rows,cols,str,i,1);
                if(res) return true;
            }
        }
        return false;
    }

    boolean find(char[] matrix,int rows,int cols,char[] str,int i,int j){
        if(j>=str.length) return true;
        char nc = matrix[i];
        matrix[i] = ' ';
        char tarc = str[j];
        boolean res = false;
        //这里可以优化 把判断部分放到迭代的开始处就可以利用||逻辑的短路特性了
        if(i+cols < matrix.length && tarc == matrix[i+cols]) res = res || find(matrix,rows,cols,str,i+cols,j+1);
        if(i-cols >= 0 && tarc == matrix[i-cols]) res = res || find(matrix,rows,cols,str,i-cols,j+1);
        if(i+1 < matrix.length && tarc == matrix[i+1]) res = res || find(matrix,rows,cols,str,i+1,j+1);
        if(i-1 >= 0 && tarc == matrix[i-1]) res = res || find(matrix,rows,cols,str,i-1,j+1);
        matrix[i] = nc;
        return res;
    }
}
/*
* 链接：https://www.nowcoder.com/questionTerminal/c61c6999eecb4b8f88a98f66b273a3cc
来源：牛客网


用一个状态数组保存之前访问过的字符，然后再分别按上，下，左，右递归

public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int flag[] = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
            return false;
        if(k == str.length - 1) return true;
        flag[index] = 1;
        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
            return true;
        }
        flag[index] = 0;
        return false;
    }
}*/