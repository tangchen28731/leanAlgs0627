package learn.offerSword;

import java.util.HashMap;
/**
* 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.*/
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if(str.isEmpty()) return -1;
        int loc = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),-1);
            }else{
                map.put(str.charAt(i),i);
            }
        }
        int min = str.length();
        for(Integer i :map.values()){
            if(i != -1){
                min = Math.min(i,min);
            }
        }
        return min == str.length()? -1:min;
    }
}

/**
 *
 * 链接：https://www.nowcoder.com/questionTerminal/1c82e8cf713b4bbeb2a5b31cf5b0417c
 * 来源：牛客网
 *因为map是以红黑树实现的，map后，不能以map的迭代器遍历，必需用str[i]来遍历。你的方法很好
 * class Solution {
 * public:
 *     int FirstNotRepeatingChar(string str) {
 *         map<char, int> mp;
 *         for(int i = 0; i < str.size(); ++i)
 *             mp[str[i]]++;
 *         for(int i = 0; i < str.size(); ++i){
 *             if(mp[str[i]]==1)
 *                 return i;
 *         }
 *         return -1;
 *     }
 * };*/
