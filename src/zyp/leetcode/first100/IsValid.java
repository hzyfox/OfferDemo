package zyp.leetcode.first100;

import java.util.Stack;

/**
 * @author zyp
 */
public class IsValid {
    public static void main(String[] args) {
        IsValid i = new IsValid();
        i.isValid("");
    }
    public boolean isValid(String s) {
        if(s.length()==1){
            return false;
        }
       char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<str.length;i++){
            if(str[i]=='('||str[i]=='{'||str[i]=='['){
                stack.push(str[i]);
                continue;
            }
            if(str[i]==')'){
                if(!stack.isEmpty()&&stack.pop()=='('){
                    continue;
                }else {
                    return false;
                }
            }

            if(str[i]=='}'){
                if(!stack.isEmpty()&&stack.pop()=='{'){
                    continue;
                }else{
                    return false;
                }
            }
            if(str[i]==']'){
                if(!stack.isEmpty()&&stack.pop()=='['){
                    continue;
                }else {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return  false;
        }
        return true;
    }
}
