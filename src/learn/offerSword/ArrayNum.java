package learn.offerSword;

import java.util.*;
/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 另一种做法回溯法 见下方*/
public class ArrayNum {
    //我设想的想法  考虑元素重复较多时能更快
    ArrayList<String> list;
    public ArrayList<String> permutation(String str) {
        list = new ArrayList<>();
        if(str.isEmpty()) return list;
        char[] arr = str.toCharArray();
        TreeMap<Character,Integer> map = new TreeMap<>();

        for(int i = 0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int[] narr = new int[map.size()];
        char[] carr = new char[map.size()];
        Iterator itr = map.entrySet().iterator();
        int i = 0;
        while(itr.hasNext()){
            Map.Entry ent=(Map.Entry)itr.next();
            carr[i] = (char)ent.getKey();
            narr[i] = (int)ent.getValue();
            i++;
        }
        count(carr,narr,"");
        return list;
    }

    public void count(char[] carr,int[] narr,String str){
        int sign = 0;
        for(int i = 0;i<carr.length;i++){
            if(narr[i] > 0){
                narr[i] -= 1;
                count(carr,narr,str + carr[i]);
                narr[i] += 1;
            }else{
                sign ++;
            }
        }
        if(sign == carr.length){
            list.add(str);
        }
    }

    public static void main(String[] args) {
        ArrayNum arrayNum = new ArrayNum();
        arrayNum.permutation("abc");
    }


    ArrayList<String> list2;
    public ArrayList<String> Permutation(String str) {
        list = new ArrayList<>();
        if(str.isEmpty()) return list;

        char[] carr = str.toCharArray();
        count(0, carr,list);
        Collections.sort(list);
        return list;
    }

    public void count(int i, char[] carr,ArrayList<String> list){
        if(i == carr.length - 1){
            String str = String.valueOf(carr);
            if(!list.contains(str)){
                list.add(str);
            }
            return;
        }
        for(int j = i;j<carr.length;j++){
            swap(carr,i,j);
            count(i+1,carr,list);
            swap(carr,j,i);
        }
    }

    public void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}
