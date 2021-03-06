package learn.baseAlgs;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Evaluate {
    /*Dijkstra 的双栈算术表达式求值算法
    * 解析括号、运算符和数字组成的表达式
    * */
    public static void main(String[] args){
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals("(")){

            }else if (s.equals("+")){
                ops.push(s);
            }else if (s.equals("-")){
                ops.push(s);
            }else if (s.equals("*")){
                ops.push(s);
            }else if (s.equals("/")){
                ops.push(s);
            }else if (s.equals("sqrt")){
                ops.push(s);
            }else if (s.equals(")")){
                //弹出计算符操作数 计算将结果压入栈
                String op = ops.pop();
                Double val = vals.pop();
                if(op.equals("+")){
                    vals.push(vals.pop() + val);
                }else if (op.equals("-")){
                    vals.push(vals.pop() - val);
                }else if (op.equals("*")){
                    vals.push(vals.pop() * val);
                }else if (op.equals("/")){
                    vals.push(vals.pop() / val);
                }else if (op.equals("sqrt")){
                    vals.push(Math.sqrt(val));
                }
            }else{
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());

    }
}
