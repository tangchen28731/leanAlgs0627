package learn.testAlgs;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * 灰度预测模型
 */
public class GrayModel {
    private double a0, a1, a2;
    private int size;
    private double error;

    public GrayModel() {
    }

    public void build(double[] x0) {
        size = x0.length;
        double[] x1 = new double[size];
        x1[0] = x0[0];
        for (int i = 1; i < size; i++) {
            x1[i] = x0[i] + x1[i - 1];
        }
        double[][] b = new double[size - 1][2];
        double[][] bt = new double[2][size - 1];
        double[][] y = new double[size - 1][1];
        for (int i = 0; i < b.length; i++) {
            b[i][0] = -(x1[i] + x1[i + 1]) / 2;
            b[i][1] = 1;
            bt[0][i] = b[i][0];
            bt[1][i] = 1;
            y[i][0] = x0[i + 1];
        }
        double[][] t = new double[2][2];
        multiply(bt, b, t);
        t = inverse(t);
        double[][] t1 = new double[2][size - 1];
        multiply(t, bt, t1);
        double[][] t2 = new double[2][1];
        multiply(t1, y, t2);
        a0 = t2[0][0];
        double u = t2[1][0];
        a2 = u / a0;
        a1 = x0[0] - a2;
        a0 = -a0;

        error = 0;
        for (int i = 0; i < x0.length; i++) {
            double d = (x0[i] - getX0(i));
            error += d * d;
        }
        error /= x0.length;
    }

    /**
     * 误差
     *
     * @return
     */
    public double getError() {
        return error;
    }

    double getX1(int k) {
        return a1 * Math.exp(a0 * k) + a2;
    }

    double getX0(int k) {
// return a0 * a1 * Math.exp(a0 * k);
        if (k == 0)
            return a1 * Math.exp(a0 * k) + a2;
        else
            return a1 * (Math.exp(a0 * k) - Math.exp(a0 * (k - 1)));
    }

    /**
     * 预测后续的值
     *
     * @param index
     * @return
     */
    public double nextValue(int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException();
        return getX0(size + index);
    }

    /**
     * 预测下一个值
     *
     * @return
     */
    public double nextValue() {
        return nextValue(0);
    }

    static double[][] inverse(double[][] t) {
        double[][] a = new double[2][2];
        double det = t[0][0] * t[1][1] - t[0][1] * t[1][0];
        a[0][0] = t[1][1] / det;
        a[0][1] = -t[1][0] / det;
        a[1][0] = -t[0][1] / det;
        a[1][1] = t[0][0] / det;
        return a;
    }

    static void multiply(double[][] left, double[][] right, double[][] dest) {
        int n1 = left.length;
        int m1 = left[0].length;
        int m2 = right[0].length;
        for (int k = 0; k < n1; k++) {
            for (int s = 0; s < m2; s++) {
                dest[k][s] = 0;
                for (int i = 0; i < m1; i++) {
                    dest[k][s] += left[k][i] * right[i][s];
                }
            }
        }
    }

    public static void main(String[] args) {
        GrayModel gs = new GrayModel();
        //自201701 始 的 每月（accidentHappendTime） 事故数
        // 从数据库获取的数据都是从去年1月开始至今的每月数据
        double[] y = {
                1155.0,863.0,688.0,1059.0,1029.0,881.0,
                993.0,1143.0,1054.0,1647.0,879.0,920.0,
                1038.0,1715.0,1057.0,1252.0,1068.0,1168.0,
                805.0};

        LocalDate today = LocalDate.now();
        int month = 7;

        //所需要显示的12个月的预测值
        Integer[] preResult = new Integer[12];
        //所需要显示的6个月的真实值
        Integer[] realResult = new Integer[6];

        int l = 0;
        for(int k = month; k< month+6 ;k++){
            realResult[l++] = (int)y[5+k];
        }

        //到现在为止的7个月的 每月的预测值
        for(int j=0;j<7;j++){
            double[] yj = new double[5+month];
            for(int k = 0; k< yj.length ;k++){
                yj[k] = y[k];
            }
            gs.build(yj);
            preResult[j] = (int)gs.nextValue(0);
            month++;
        }
        gs.build(y);

        // 未来五个月 的每月预测值
        for (int i = 0; i < 5; i++) {
            preResult[7+i] = (int)gs.nextValue(i);
        }

        //预测12个月的值
        System.out.println(Arrays.toString(preResult));
        //真实6个月的值
        System.out.println(Arrays.toString(realResult));

        //存入数据库预测值表中，字段有：  time(格式例如201807)、 preValue、 realValue
        //每个月 1号计算一次运行本代码 更新该表

    }
}
