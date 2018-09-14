package learn.offerSword;
/**
 * 一种是 只能跳1 或2 级
 * 一种是 能跳1~n级
 *
 * 变种
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * */
public class JumpFloor {
    public int JumpFloor(int target) {
        int f = 1;
        int g = 2;
        while(target>1){
            g = g+f;
            f = g-f;
            target--;
        }
        return f;
    }
//能跳1~n级
    public int JumpFloorII(int target) {
        return (int)Math.pow(2,target-1);
    }
}
