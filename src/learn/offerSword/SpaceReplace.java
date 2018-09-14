package learn.offerSword;

import java.util.ArrayList;
import java.util.Collections;

public class SpaceReplace {
    public String replaceSpace(StringBuffer str) {
        String text = str.toString();
        char[] array = text.toCharArray();
        String res = "";
        for(int i=0;i<array.length;i++){
            if(array[i] == ' '){
                res = res + "%20";
            }else{
                res = res + array[i];
            }
        }
        return res;
    }
}
