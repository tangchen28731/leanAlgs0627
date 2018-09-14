package learn.offerSword;

public class ReverseListNode {
    public ListNode ReverseList(ListNode head) {
        ListNode newNode = new ListNode(0);
        ListNode lastNode = null;
        ListNode saveNextNode = null;
        while(head!=null){
            newNode.next = head;
            saveNextNode = head.next;
            head.next = lastNode;
            lastNode = head;
            head = saveNextNode;
        }
        return newNode.next;
    }

    //这个无需额外空间
    public ListNode ReverseList2(ListNode head) {
        if(head==null)
            return null;
        ListNode current=head;
        ListNode tmp=null;
        ListNode pre=null;
        while(current!=null){
            tmp=current.next;
            current.next=pre;
            pre=current;
            current=tmp;

        }
        return pre;
    }


}
