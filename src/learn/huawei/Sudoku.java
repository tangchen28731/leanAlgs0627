package learn.huawei;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Sudoku {
    private boolean[][] isCom;

    public void sudoku() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            Set<Integer>[][] set = new HashSet[9][9];
            Set<Integer> values = new HashSet<>();
            isCom = new boolean[9][9];
            for (int j = 1; j <= 9; j++) {
                values.add(j);
            }
            for (int j = 0; j < 9; j++) {
                Set<Integer>[] setc = new HashSet[9];
                for (int k = 0; k < 9; k++) {
                    Set<Integer> setn = new HashSet<>();
                    int val = in.nextInt();
                    if (val == 0) {
                        setn.addAll(values);
                    } else {
                        setn.add(val);
                    }
                    setc[k] = setn;
                }
                set[j] = setc;
            }
            int over = 0;
            while (true) {

                int sign = 0;
                for (int j = 0; j < 9; j++) {
                    for (int k = 0; k < 9; k++) {
                        if (set[j][k].size() == 1) {
                            sign++;
                            count(set, j, k);
                        }
                    }
                }

                over++;
                if (sign == 81 || over > 81) {

                    for (Set<Integer>[] farr : set) {
                        for (Set<Integer> value : farr) {
                            System.out.print(value + " ");
                        }
                        System.out.println();
                    }
                    break;
                }
            }

        }
    }

    public void count(Set<Integer>[][] set, int j, int k) {
        if (isCom[j][k]) return;
        for (int i = 0; i < 9; i++) {
            int jkvalue = set[j][k].iterator().next();
            if (i != j) {
                set[i][k].remove(jkvalue);
            }
            if (i != k) {
                set[j][i].remove(jkvalue);
            }

            for (int l = j / 3 * 3; l < 3 + j / 3 * 3; l++) {
                for (int m = k / 3 * 3; m < 3 + k / 3 * 3; m++) {
                    if (l != j && m != k) {
                        set[l][m].remove(jkvalue);
                    }
                }
            }
        }
        isCom[j][k] = true;

    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        sudoku.sudoku();
    }

}
