package learn.offerSword;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Match {
    boolean[][] res;//用二位数组避免相交的重复计算
    int[][] sign;

    public boolean match(char[] str, char[] pattern) {
        res = new boolean[str.length + 1][pattern.length + 1];
        sign = new int[str.length + 1][pattern.length + 1];
        return count(str, pattern, 0, 0);

    }

    public boolean count(char[] str, char[] pattern, int i, int j) {

        if (sign[i][j] == 1) {
            return res[i][j];
        }
        boolean ans;
        if (j == pattern.length) {
            return i == str.length;
        }
        //标记 文本是否匹配结束 与 首字符是否相等
        boolean firstMatch = i < str.length && (str[i] == pattern[j] || pattern[j] == '.');
        //是否模式字符串对应的下一个字符是‘*’,是的话有两种情况
        if (j + 1 < pattern.length && pattern[j + 1] == '*') {
            ans = count(str, pattern, i, j + 2) || (firstMatch && count(str, pattern, i + 1, j));
        } else {
            ans = firstMatch && count(str, pattern, i + 1, j + 1);
        }

        sign[i][j] = 1;
        res[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Match match = new Match();
        char[] arr1 = {};
        char[] arr2 = {'.', '*'};
        System.out.println(match.match(arr1, arr2));
    }
}
