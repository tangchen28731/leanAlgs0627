package learn.base100Algs;
/**
 * 打印出所有的“水仙花数”，所谓“水仙花数”是指一个三位数，其各位
 * 数字立方和等于该数本身。例如：153是一个“水仙花数”，因为153=1的三次方
 * ＋5的三次方＋3的三次方
 * 利用for循环控制100-999个数，每个数分解出个位，十位，百位。*/
public class Print000 {
    public void print(){
        for(int i =100;i<1000;i++){
            int l = i/100;
            int m = i%100/10;
            int n = i%10;
            if(i == l*l*l + m*m*m + n*n*n){
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Print000 print000 = new Print000();
        print000.print();
    }
}
