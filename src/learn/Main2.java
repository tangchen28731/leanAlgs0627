package learn;

import java.util.Scanner;
/**
 * 小A有两个幸运数字字符a和b。他认为一个数很美当且仅当这个数字只包含数字字符a和b，且这个数字每位数字之和也只包含数字字符a和b。
 *
 * 例如：幸运数字字符为1和2，那么11就很美，其每位数字之和为2，11和2都只含有数字字符1和2。但是12、21、111都不美，虽然它们本身都只含有数字字符1和2，但它们每位数字之和都为3，而3不是幸运数字字符。
 *
 * 现在小A想知道对于所有的k位数字，有多少个美丽的数字？*/
public class Main2 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();

        }
    }
}
