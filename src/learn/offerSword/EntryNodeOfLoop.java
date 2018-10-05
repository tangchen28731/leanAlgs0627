package learn.offerSword;

public class EntryNodeOfLoop {
    /**
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。*/
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode snode = pHead;
        ListNode qnode = pHead;

        while(qnode!=null){
            qnode = qnode.next;
            if(qnode!=null) qnode = qnode.next;
            else return null;
            snode = snode.next;
            if(snode == qnode) break;
        }
        if(qnode == null) return null;
        qnode = pHead;
        while(qnode!=snode){
            snode = snode.next;
            qnode = qnode.next;
        }
        return qnode;
    }
}
