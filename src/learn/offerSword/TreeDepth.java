package learn.offerSword;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。*/
public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int dlen = 0;
        while(list.size()!=0){
            List<TreeNode> list2 = new ArrayList<>();
            Iterator<TreeNode> ite = list.iterator();
            while(ite.hasNext()){
                TreeNode node = ite.next();
                if(node.left!=null) list2.add(node.left);
                if(node.right!=null) list2.add(node.right);
            }
            dlen++;
            list = list2;
        }
        return dlen;
    }
}
