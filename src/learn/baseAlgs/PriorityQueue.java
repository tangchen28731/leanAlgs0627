package learn.baseAlgs;

/**
 * 优先队列： 数据结构 支持以下两种操作 删除最大元素及 插入元素
 * 实现方式： 基于二叉堆
 * */
public class PriorityQueue<Key extends Comparable<Key>>{


    private Key[] pq;
    private int N = 0;

    public PriorityQueue(int maxN) {
        pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    /* 堆有序化 上浮*/
    private void swim(int k){
        while(k>1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }

    /* 堆有序化 下沉*/
    private void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            if(j<N && less(j,j+1)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k = j;
        }
    }

    /*数组 基本操作*/
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
