package learn.offerSword;
/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。*/
public class KthNode {
    private TreeNode val;
    private int sign;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        sign = k;
        trav(pRoot);
        return val;
    }

    public void trav(TreeNode node){
        if(node == null) return;
        trav(node.left);
        sign --;
        if(sign == 0){
            val = node;
            return;
        }
        trav(node.right);
    }
}
/*
* 链接：https://www.nowcoder.com/questionTerminal/ef068f602dde4d28aab2b210e859150a
来源：牛客网

public class Solution {
   int index = 0; //计数器
    TreeNode KthNode(TreeNode root, int k)
    {
        if(root != null){ //中序遍历寻找第k个
            TreeNode node = KthNode(root.left,k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return root;
            node = KthNode(root.right,k);
            if(node != null)
                return node;
        }
        return null;
    }
}*/