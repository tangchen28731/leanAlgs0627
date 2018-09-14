package learn.offerSword;

import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class RebuildBinaryTree {
    private HashMap<Integer, Integer> map;

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return iter(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode iter(int[] pre, int[] in, int lo, int hi, int lo2, int hi2) {
        if (lo > hi || lo2 > hi2) {
            return null;
        }
        int goal = pre[lo];
        int rtNode = -1;
        rtNode = map.get(goal);
        //for(int i = lo2;i<=hi2;i++){
        //    if(goal == in[i]){
        //        rtNode = i;
        //        break;
        //    }
        //}//这里可以放入map 不用每次循环
        TreeNode root = new TreeNode(goal);
        root.left = iter(pre, in, lo + 1, lo + rtNode - lo2, lo2, rtNode - 1);
        root.right = iter(pre, in, lo + rtNode - lo2 + 1, hi, rtNode + 1, hi2);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
