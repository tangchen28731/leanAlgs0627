package learn.offerSword;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
* 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
* 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)*/
public class BinaryTreeSumTarget {
    private ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        Stack<Integer> stack = new Stack<>();
        res = new ArrayList<>();
        traverse(stack,root,target,0);
        return res;
    }

    public void traverse(Stack<Integer> stack,TreeNode root,int target,int sum){
        if(root == null) return;
        stack.push(root.val);
        sum = sum+root.val;
        if(root.left==null && root.right==null ){
            if(sum == target){
                Iterator<Integer> ite = stack.iterator();
                ArrayList<Integer> list = new ArrayList<>();
                while(ite.hasNext()){
                    list.add(ite.next());
                }
                res.add(list);
            }
        }else{
            traverse(stack,root.left,target,sum);
            traverse(stack,root.right,target,sum);
        }
        stack.pop();
    }
}
/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */