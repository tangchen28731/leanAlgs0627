package learn.offerSword;

import java.util.ArrayList;
import java.util.List;
/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。*/
public class PrintBinaryTree {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        List<TreeNode> colList = new ArrayList<>();
        ArrayList<Integer> resList = new ArrayList<>();
        if(root == null) return resList;
        colList.add(root);
        while(colList.size()!=0){
            colList = traverse(colList,resList);
        }
        return resList;
    }
    public List<TreeNode> traverse(List<TreeNode> colList,ArrayList<Integer> resList){
        List<TreeNode> list = new ArrayList<>();
        for(TreeNode node:colList){
            resList.add(node.val);
            if(node.left!=null){
                list.add(node.left);
            }
            if(node.right!=null){
                list.add(node.right);
            }
        }
        return list;
    }
}
