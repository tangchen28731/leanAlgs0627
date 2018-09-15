package learn.offerSword;
/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。*/
public class MergeListNode {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode node = new ListNode(0);
        ListNode res = node;
        if(list1==null && list2==null) return null;
        while(list1!=null && list2!=null){
            if(list1.val > list2.val){
                node.next = list2;
                list2 = list2.next;
            }else{
                node.next = list1;
                list1 = list1.next;
            }
            node = node.next;
        }
        if(list2==null){
            node.next = list1;
            list1 = list1.next;
        }else{
            node.next = list2;
            list2 = list2.next;
        }
        return res.next;
    }
}
