package learn.offerSword;

import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber {
    public String printMinNumber(int [] numbers) {

        Integer[] numi = new Integer[numbers.length];
        for(int i=0;i<numbers.length;i++){
            numi[i] = numbers[i];
        }
        Arrays.sort(numi, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int len1 = o1.toString().length();
                int len2 = o2.toString().length();
                if(len1 == len2) return o1-o2;
                int max = Math.max(len1,len2);
                int min = Math.min(len1,len2);
                int d = 1;
                int i = max-min;
                while(i>0){
                    d *=10;
                    i--;
                }

                if(len1>len2){
                    if(o1/d != o2) return o1/d - o2;
                    return compare(o1%d,o2);
                }else {
                    if(o1 != o2/d) return o1 - o2/d;
                    return compare(o1,o2%d);
                }
            }
        });
        StringBuilder str = new StringBuilder();
        for(Integer i:numi) {
            str.append(i);
        }
        return str.toString();
    }

    //一个巧妙的办法
/*  Collections.sort(list, new Comparator<Integer>(){

        public int compare(Integer str1,Integer str2){
            String s1=str1+""+str2;
            String s2=str2+""+str1;
            return s1.compareTo(s2);
        }
    });*/
}

