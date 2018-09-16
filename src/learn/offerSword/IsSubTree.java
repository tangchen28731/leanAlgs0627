package learn.offerSword;
/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）*/
public class IsSubTree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean ch = false;
        if(root1 == null || root2 == null) return false;
        if(root1.val == root2.val){
            ch =  equal(root1,root2);
        }
        return ch || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    public boolean equal(TreeNode node1,TreeNode node2){
        if(node1 == null && node2!=null) return false;
        if(node2 == null) return true;
        if(node1.val != node2.val){
            return false;
        }else{
            return equal(node1.left,node2.left) && equal(node1.right,node2.right);
        }
    }
}
