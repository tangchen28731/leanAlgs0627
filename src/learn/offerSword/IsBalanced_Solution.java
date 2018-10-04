package learn.offerSword;
/**
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * */
public class IsBalanced_Solution {
    private int sign = 0;
    public boolean IsBalanced_Solution(TreeNode root) {
        countHei(root);
        return sign == 0;
    }

    public int countHei(TreeNode node){
        if(node == null) return 0;
        int left = countHei(node.left);
        int right = countHei(node.right);
        int max = left>right?left:right;
        int min = left<=right?left:right;
        if(max - min > 1)  sign = 1;
        return max+1;
    }

    /*更好的做法 剪枝了*/
        public boolean IsBalanced_Solution2(TreeNode root) {
            return getDepth(root) != -1;
        }

        private int getDepth(TreeNode root) {
            if (root == null) return 0;
            int left = getDepth(root.left);
            if (left == -1) return -1;
            int right = getDepth(root.right);
            if (right == -1) return -1;
            return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
        }

}
