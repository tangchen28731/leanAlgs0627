package learn.offerSword;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseLinked {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) return list;
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        if (list.size() > 0) Collections.reverse(list);
        return list;
    }

// 链表反转更合适提题意
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        ListNode pre=null;
        ListNode next=null;
        while(listNode!=null){
            next=listNode.next;
            listNode.next=pre;
            pre=listNode;
            listNode=next;
        }
        while(pre!=null){
            list.add(pre.val);
            pre=pre.next;
        }
        return list;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}