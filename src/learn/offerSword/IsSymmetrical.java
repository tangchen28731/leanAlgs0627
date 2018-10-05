package learn.offerSword;

import java.util.ArrayList;
import java.util.List;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。*/
public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        return isRight(pRoot.left,pRoot.right);
    }

    boolean isRight(TreeNode left,TreeNode right){

        if(left == null && right == null) return true;
        if(left == null | right == null) return false;
        return left.val == right.val && isRight(left.right,right.left) && isRight(right.right,left.left);

    }

}
