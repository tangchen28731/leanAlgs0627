package learn.offerSword;
/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 给的示例里面 -.123也算对了*/
public class IsNumeric {
    public boolean isNumeric(char[] str) {
        int psign = 0;
        int esign = 0;
        int i = 0;
        if(str[i] == '-' || str[i] == '+'){
            i++;
        }
        int st = i;
        char lastchar = ' ';
        for(;i<str.length;i++){
            if( str[i]>='0' && str[i] <= '9'){

            }else if((str[i] == 'e'|| str[i] =='E') && (i!=st && i!= str.length-1)){
                if(esign == 0 && lastchar !='.'){
                    psign = 1;
                    esign++;
                    if(i<str.length-1){
                        if(str[i+1] == '+' || str[i+1] == '-'){
                            i++;
                            if(i == str.length-1) return false;
                        }
                    }
                }else{
                    return false;
                }
            }else if(str[i] == '.' && (/*i!= st &&*/ i!= str.length-1)){
                if(psign == 0 && (lastchar !='e' && lastchar !='E')){
                    psign++;
                }else{
                    return false;
                }
            }else{
                return false;
            }
            lastchar = str[i];
        }
        return true;
    }
}
