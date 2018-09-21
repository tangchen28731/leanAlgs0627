package learn.huawei;


import java.util.*;
public class Question3 {
    private static Set<Integer> set;
    private static HashMap<Integer,List<Integer>> map;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            in.nextLine();
            map = new HashMap<>();
            for(int i = 0;i<n;i++){
                String str = in.nextLine();
                String[] sarr = str.split(" ");
                int key = Integer.parseInt(sarr[0]);
                List<Integer> list = new ArrayList<>();
                for(int j = sarr.length-1;j>0;j--){
                    list.add(Integer.parseInt(sarr[j]));
                }
                /*if(sarr.length == 1){
                    list.add(key);
                }*/

                map.put(key,list);
            }

            set = new TreeSet<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            set.add(0);
            if(map.containsKey(0)){
                count(0,map.get(0));
            }

            HashMap<Integer,Integer> resMap = new HashMap<>();
            for(Integer val:set){
                int num = 0;
                for(Integer val2:set) {
                    for (Integer ind : map.get(val2)) {

                        if (ind.intValue() == val.intValue()) {
                            num++;
                        }

                    }
                }
                resMap.put(val,num);
            }
            for(Integer val:set){
                System.out.println(val+" "+resMap.get(val));
            }
        }
    }

    public static void count(int val,List<Integer> list){
        for(Integer i:list){
            set.add(i);
            if( i == val ){

            }else{
                count(i,map.get(i));
            }
        }
    }
}