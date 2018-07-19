package learn.baseAlgs;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class UFT1 {
    private int count;
    private int[] id;
    private int[] sz;
    public UFT1(int n){
        count = n;
        id = new int[n];
        for(int i=0;i<n;i++){
            id[i]=i;
        }
        sz = new int[n];
        for(int i=0;i<n;i++){
            sz[i]=1;
        }
    }
    public int find(int p){
        List<Integer> list = new ArrayList<Integer>();
        while(p!=id[p]){
            list.add(p);
            p=id[p];
        }
        for (Integer num:list
             ) {
         id[num] = p;
        }
        return p;
    }
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }
    public void union(int p,int q){
        int i = find(p);
        int j = find(q);
        if(i==j) return;
        if(sz[i]<sz[j]){id[i] = j; sz[j] += sz[i];}
        else {id[j] = i; sz[i] += sz[j];}
        count--;
    }
    public int count(){
        return count;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();//触点数量
        UFT1 uf = new UFT1(n);
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            if(p == 100){break;}
            int q = StdIn.readInt();
            if(uf.connected(p,q)) continue;
            uf.union(p,q);
            StdOut.println(p+" "+q);
        }
        StdOut.println(uf.count()+"components");

    }
}
