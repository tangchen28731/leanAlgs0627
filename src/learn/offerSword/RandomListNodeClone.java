package learn.offerSword;

import java.util.HashMap;
/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 更好的方法：
 *
 * 方法二：next指针关联
 *     创建新链表的时候，用原结点的next指针指向对应新结点，
 *     新结点的next指针指向下一个原结点，以此类推，形成之字形关联。
 *     然后，就可以先更新新链表的random指针，再解除next关联，更新next指针。
 *     这种方法不需要map来辅助，不管查找next还是random指针都是O(1)的，效率很高。
 *
 * */

public class RandomListNodeClone {
    //我的方法
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode newHead = new RandomListNode(pHead.label);
        RandomListNode node = newHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (pHead != null) {

            if (pHead.next != null) {
                if (map.containsKey(pHead.next)){
                    node.next = map.get(pHead.next);
                }else{
                    node.next = new RandomListNode(pHead.next.label);
                    map.put(pHead.next, node.next);
                }
            }
            if (pHead.random != null) {
                if (map.containsKey(pHead.random)) {
                    node.random = map.get(pHead.random);
                } else {
                    node.random = new RandomListNode(pHead.random.label);
                    map.put(pHead.random, node.random);
                }
            }
            pHead = pHead.next;
            node = node.next;

        }
        return newHead;
    }
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}