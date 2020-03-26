package zyp.swordoffer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zyp
 */
public class IsNumeric {
    public static void main(String[] args) {
        IsNumeric is = new IsNumeric();
        String str = "1.79769313486232E+308";
        is.isNumeric2(str.toCharArray());
    }
    //法一：正则表达式法
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        String pattern = "(\\+|\\-)?\\d*(\\.\\d+)?((e|E)(\\+|\\-)?\\d+)?";
//        string.matches(pattern);
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(string);
        System.out.println(string.matches(pattern));
        return m.matches();
    }

    int index = 0;
    //法二：模拟正则表达式的过程
    public  boolean isNumeric2(char[] str){
        if(str.length==0){
            return  false;
        }
        if(str[index]=='+'||str[index]=='-'){
            index++;
        }
        boolean flag = unsighedInt(str);
        if(index<str.length&&str[index]=='.'){
            index++;
            flag = unsighedInt(str)||flag;
        }
        if(index<str.length&&(str[index]=='e'||str[index]=='E')){
            if((index+1)<str.length){
                if(str[index+1]=='+'||str[index+1]=='-'){
                    index+=2;
                    flag= flag&&unsighedInt(str);
                }else{
                    index++;
                    flag= flag&&unsighedInt(str);
                }
            }else{
                flag = false;
            }
        }
        System.out.println(flag&&str.length==index);
        return flag&&str.length==index;
    }

    public boolean unsighedInt(char[] str){
        int start = index;
        while(index<str.length&&str[index]<='9'&&str[index]>='0'){
            index++;
        }
        return start<index;
    }
}
