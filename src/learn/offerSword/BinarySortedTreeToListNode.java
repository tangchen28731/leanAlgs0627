package learn.offerSword;

import java.util.ArrayList;
import java.util.List;
/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 这里可以不用 list 在递归函数中传递 pre前一个节点 即可 ，在原来的add地方 进行指向赋值*/
public class BinarySortedTreeToListNode {
    List<TreeNode> list;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        list = new ArrayList<>();
        inOrderTraversal(pRootOfTree);
        TreeNode last = null;
        for(TreeNode node : list){
            if(last!=null) last.right = node;
            node.left = last;
            last = node;
        }
        return list.iterator().next();
    }

    public void inOrderTraversal(TreeNode node){
        if(node == null) return;
        inOrderTraversal(node.left);
        list.add(node);
        inOrderTraversal(node.right);
    }
}
