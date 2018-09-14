package learn.offerSword;
/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * */
public class LinkedRecK {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode fhead = head;
        ListNode node = null;
        if(k == 0) return null;
        int i = 0;
        while(head!=null){
            i++;
            if(i>k){
                node = node.next;
            }else if(i==k){
                node = fhead;
            }
            head = head.next;
        }
        return node;
    }
}
