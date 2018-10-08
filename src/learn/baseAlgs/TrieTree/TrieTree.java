package learn.baseAlgs.TrieTree;


class TrieTreeNode {
    int nCount;	//记录该字符出现次数
    char ch; //记录该字符
    TrieTreeNode[] child;	// 记录子节点
    final int MAX_SIZE = 26;
    public TrieTreeNode() {
        nCount=1;
        child = new TrieTreeNode[MAX_SIZE];
    }
}

public class TrieTree {
    //字典树的插入和构建
    public void createTrie(TrieTreeNode node,String str){
        if (str == null || str.length() == 0) {
            return;
        }
        char[] letters = str.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int pos = letters[i] - 'a';	  // 用相对于a字母的值作为下标索引，也隐式地记录了该字母的值
            if (node.child[pos] == null) {
                node.child[pos] = new TrieTreeNode();
            }else {
                node.child[pos].nCount++;
            }
            node.ch = letters[i];
            node = node.child[pos];
        }
    }

    //字典树的查找
    public int findCount(TrieTreeNode node,String str){
        if (str == null || str.length() == 0) {
            return -1;
        }
        char[] letters = str.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int pos = letters[i] - 'a';
            if (node.child[pos] == null) {
                return 0;
            }else {
                node = node.child[pos];
            }
        }
        return node.nCount;
    }

}
