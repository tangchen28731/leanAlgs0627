package learn.offerSword;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * 一个更好的做法是 使用stack来存储最小值，如果新push值且比当前值大的话就插入当前的最小值，pop时stack pop() 并用peek()更新最小值
 * */
public class MinStack {
    private int length = 8;
    private int[] array = new int[length];
    private int ind = 0;
    private int min = Integer.MAX_VALUE;
    public void push(int node) {
        array[ind] = node;
        ind++;
        if(ind> length*2/3){
            int[] newArray = new int[length*2];
            for(int i = 0;i<ind;i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
        if(node<min){
            min = node;
        }
    }

    public int pop() {
        int val = array[ind];
        ind--;
        if(ind< length/2){
            int[] newArray = new int[length/2];
            for(int i = 0;i<ind;i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
        int tmin = Integer.MAX_VALUE;
        for(int i = 0;i<ind;i++){
            tmin = tmin>array[i]?array[i]:tmin;
        }
        min = tmin;
        return val;
    }

    public int top() {
        return array[ind-1];
    }

    public int min() {
        return min;
    }
}
