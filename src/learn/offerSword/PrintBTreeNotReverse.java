package learn.offerSword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。*/
public class PrintBTreeNotReverse {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null) return res;
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(pRoot);
        while(!list.isEmpty()){
            ArrayList<Integer> sr = new ArrayList<>();
            ArrayList<TreeNode> tlist = new ArrayList<>();
            for(TreeNode node : list){
                sr.add(node.val);
                if(node.left != null) tlist.add(node.left);
                if(node.right != null) tlist.add(node.right);
            }
            list = tlist;
            res.add(sr);
        }
        return res;
    }


    //使用linkedlist
    ArrayList<ArrayList<Integer> > Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return result;
        }
        Queue<TreeNode> layer = new LinkedList<TreeNode>();
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        layer.add(pRoot);
        int start = 0, end = 1;
        while(!layer.isEmpty()){
            TreeNode cur = layer.remove();
            layerList.add(cur.val);
            start++;
            if(cur.left!=null){
                layer.add(cur.left);
            }
            if(cur.right!=null){
                layer.add(cur.right);
            }
            if(start == end){
                end = layer.size();
                start = 0;
                result.add(layerList);
                layerList = new ArrayList<Integer>();
            }
        }
        return result;
    }
}
