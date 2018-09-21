package learn.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int plen = in.nextInt();

            String strd = in.next();
            int locd = strd.lastIndexOf(",");
            int start = Integer.parseInt(strd.substring(0, locd));
            int dlen = Integer.parseInt(strd.substring(locd + 1, strd.length()));
            List<int[]> list = new ArrayList<>();

            while (true) {
                String str = in.next();
                if (!str.equals("end")) {
                    int[] arr = new int[2];
                    int loc = str.lastIndexOf(",");
                    arr[0] = Integer.parseInt(str.substring(0, loc));
                    arr[1] = Integer.parseInt(str.substring(loc + 1, str.length()));
                    list.add(arr);
                } else {
                    break;
                }
            }
            int sum = 0;
            int i = 0;
            while (sum < start) {
                sum += list.get(i)[1]-list.get(i)[0];
                i++;
            }
            int besum = sum - list.get(i)[1];
            i = i-1;

            int leftLen = start - besum - list.get(i)[0];
            int righLen = sum-(start+dlen);


            if(leftLen > righLen){
                list.get(i)[1] -=  dlen;
            }else{
                list.get(i)[0] +=  dlen;
                list.get(i)[1] -=  dlen;
            }


            for (int[] array : list) {
                System.out.println(array[0] + "," + array[1]);
            }
        }
    }
}