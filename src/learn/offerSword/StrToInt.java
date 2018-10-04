package learn.offerSword;
/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。*/
public class StrToInt {
    public int StrToInt(String str) {
        if (str.isEmpty()) return 0;
        int max = Integer.MAX_VALUE;
        char[] arr = str.toCharArray();
        boolean pos = true;//正
        boolean sign = true;
        int len = arr.length;
        int res = 0;
        int i = 0;
        if (arr[0] == '-') {
            pos = false;
            len--;
            i++;
        } else if (arr[0] == '+') {
            len--;
            i++;
        }
        if(i>=arr.length) return 0;
        while (arr[i] == '0') {
            i++;
            len--;
            if(i >= arr.length) return 0;
        }
        int zero = (int)Math.pow(10, len - 1);
        for (; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                int val = arr[i] - '0';
                if (len > 10) {
                    return 0;
                } else if (sign && len == 10) {
                    if (val > max / zero) {
                        if (pos) return 0;
                        else if (zero == 1 && val == 8 && !pos) return Integer.MIN_VALUE;
                        else return 0;
                    } else if (val == max / zero) {
                        res += val * zero;
                    } else {
                        res += val * zero;
                        sign = false;
                    }
                    max = max % zero;
                    zero = zero / 10;
                }else{
                    res += val * zero;
                    zero = zero / 10;
                }
            } else {
                return 0;
            }
        }
        return pos ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(new StrToInt().StrToInt("+0"));
    }
}
