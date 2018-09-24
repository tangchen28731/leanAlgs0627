package learn.offerSword;
/**
 *
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * 隐藏含义 是有公共尾部自从第一个公共节点后*
 * 所以可以先去除长链表的前面不等长的部分  后面依次比较
 *
 * 或者一个更好的方法 利用尾部 相同 两个链表想连接 a+b 与 b+a 逐个比较 那么最后的一部分一定会是相同的尾部 且 长度相同了
 * */
//cool
public class FindFirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode tn1 = pHead1;
        ListNode tn2 = pHead2;
        while(tn1!=tn2){
            tn1 = tn1 == null? pHead2:tn1.next;
            tn2 = tn2 == null? pHead1:tn2.next;
        }
        return tn1;

    }
}
