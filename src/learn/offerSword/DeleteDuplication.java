package learn.offerSword;

import edu.princeton.cs.algs4.Stack;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5*/
public class DeleteDuplication {
    //my 通过栈来解决问题
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null) return pHead;
        ListNode node = pHead;
        Stack<ListNode> stack = new Stack<>();
        while(node!=null){
            if(stack.isEmpty()){
                stack.push(node);
            }else{
                if(stack.peek().val == node.val){
                    while(node!= null && stack.peek().val == node.val) node = node.next;
                    stack.pop();
                    if(node!=null) stack.push(node);
                }else{
                    stack.push(node);
                }
            }
            if(node!=null) node = node.next;
        }
        ListNode temp = null;
        ListNode tnode = null;
        while(!stack.isEmpty()){
            temp = stack.pop();
            temp.next = tnode;
            tnode = temp;
        }
        return temp;
    }

    //另一种方法递归
    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
            return pHead;
        }
        if (pHead.val == pHead.next.val) { // 当前结点是重复结点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            return deleteDuplication2(pNode); // 从第一个与当前结点不同的结点开始递归
        } else { // 当前结点不是重复结点
            pHead.next = deleteDuplication2(pHead.next); // 保留当前结点，从下一个结点开始递归
            return pHead;
        }
    }
}
