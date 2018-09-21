package learn.base100Algs;
/**
 * 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔
 *
 * 子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数
 *
 * 为多少？*/
public class RabbitThreeMonthBirth {
    public int count(int n){
        int g = 2;
        int f = 2;
        while(n>1){
            g = g+f;
            f = g-f;
            n--;
        }
        return f;
    }
}
