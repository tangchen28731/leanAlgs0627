package learn.offerSword;

public class DoublePow {
    //需要改一下 不用拆成int 直接double算就好了
    public double Power(double base, int exponent) {
        if(base == 0 && exponent == 0) return 1;
        String str = base+"";
        String[] arr = str.split("\\.");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int sign = 0;
        if (exponent<0){
            exponent = -exponent;
            sign = 1;
        }
        str = sqrt(n,exponent)+"."+sqrt(m,exponent);
        return sign == 1 ?1/Double.parseDouble(str):Double.parseDouble(str);

    }
    private int sqrt(int m,int n){
        if(n==0&&m!=0) return 1;
        if(m==0) return 0;
        int i = 1;
        int ex = n;
        while(ex!=0){
            if((ex&1) == 1){
                i = i*m;
            }
            m = m*m;
            ex>>=1;
        }
        return i;
    }


    public static double Power2(double base, int n) {
        double res = 1,curr = base;
        int exponent;
        if(n>0){
            exponent = n;
        }else if(n<0){
            if(base==0)
                throw new RuntimeException("分母不能为0");
            exponent = -n;
        }else{// n==0
            return 1;// 0的0次方
        }
        while(exponent!=0){
            if((exponent&1)==1)
                res*=curr;
            curr*=curr;// 翻倍
            exponent>>=1;// 右移一位
        }
        return n>=0?res:(1/res);
    }

    public static void main(String[] args) {
        System.out.println(Power2(2,5));
    }

}
