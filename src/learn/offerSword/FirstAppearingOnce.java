package learn.offerSword;

import java.util.ArrayList;
import java.util.List;

public class FirstAppearingOnce  {
    /**
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
     * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。*/
    //Insert one char from stringstream
    private int[] arr = new int[256];
    private String s = "";
    public void Insert(char ch)
    {
        s += ch;
        arr[(int)ch] += 1;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(int i=0;i<s.length();i++){
            char z = s.charAt(i);
            if(arr[(int)z] == 1){
                return z;
            }
        }
        return '#';
    }
}
