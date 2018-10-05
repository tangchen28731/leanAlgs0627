package learn.offerSword;

import java.util.ArrayList;
import java.util.List;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树*/
public class TreeSerialize {
    String Serialize(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        List<String> sr = new ArrayList<>();
        sr.add("0");
        String str = "";
        if(root == null) return str;
        list.add(root);
        while(!list.isEmpty()){
            ArrayList<TreeNode> tlist = new ArrayList<>();
            for(TreeNode node : list){
                if(node == null) sr.add("0");
                else sr.add(node.val+"");
                if(node != null && node.left != null) tlist.add(node.left);
                else tlist.add(null);
                if(node != null && node.right != null) tlist.add(node.right);
                else tlist.add(null);
            }
            int i = 0;
            for(TreeNode tnode:tlist){
                if(tnode == null) i++;
            }
            if(i == tlist.size()) break;
            list = tlist;
        }
        str = String.join(",", sr);
        return str;
    }


    TreeNode Deserialize(String str) {
        if(str.isEmpty()) return null;
        String[] arr = str.split(",");
        TreeNode res = tra(arr,1);
        return res;
    }
    public TreeNode tra(String[] arr,int i){
        if(i<arr.length && !arr[i].equals("0")){
            TreeNode node = new TreeNode(Integer.parseInt(arr[i]));
            node.left = tra(arr,2*i);
            node.right = tra(arr,2*i+1);
            return node;
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        TreeSerialize treeSerialize = new TreeSerialize();
        TreeNode res = treeSerialize.Deserialize("0,1,2,3,4,5,6,7,8,0,0,0,0,0,0,0");
        System.out.println(treeSerialize.Serialize(res));
    }

    //使用先序遍历的方法


    public int index = -1;
    String Serialize2(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize2(root.left));
        sb.append(Serialize2(root.right));
        return sb.toString();
    }
    TreeNode Deserialize2(String str) {
        index++;
        int len = str.length();
        if(index >= len){
            return null;
        }
        String[] strr = str.split(",");
        TreeNode node = null;
        if(!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize2(str);
            node.right = Deserialize2(str);
        }

        return node;
    }
}
