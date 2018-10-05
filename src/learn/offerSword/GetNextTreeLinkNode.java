package learn.offerSword;
/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。*/


class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class GetNextTreeLinkNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        //如果右节点不为空就找右节点
        if(pNode.right != null){
            return zxget(pNode.right);
        }else{
            //右节点为空时向上寻找
            TreeLinkNode fnode = pNode.next;
            if(fnode == null){
                return null;
            }else{
                //父节点不为空时
                //如果当前节点是父节点的左节点直接返回父节点
                if(fnode.left == pNode){
                    return fnode;
                }else{
                    //当前节点是父节点的右节点，则向上找到第当前节点是左孩子节点的节点，该节点的父节点即为结果
                    TreeLinkNode nnode = pNode;
                    while(fnode!=null && fnode.left != nnode){
                        nnode = fnode;
                        fnode = fnode.next;
                    }
                    //若遍历到头都不存在 则返回空
                    if(fnode == null) return null;
                    return fnode;
                }
            }
        }
    }

    public TreeLinkNode zxget(TreeLinkNode node){
        if(node.left!=null) return zxget(node.left);
        return node;
    }
}
