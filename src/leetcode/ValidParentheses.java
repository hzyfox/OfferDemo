package leetcode;

import java.util.Stack;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() == 0){
            return true;
        }
        Stack<Character> container = new Stack<>();
        container.push(s.charAt((0)));
        for(int i = 1; i<s.length(); i++){
            switch (s.charAt(i)) {
                case '{':
                    container.push('{');
                    break;
                case '(':
                    container.push('(');
                    break;
                case '[':
                    container.push('[');
                    break;
                case ')':
                    if(!container.isEmpty() || container.peek() != '('){
                        return false;
                    }else {
                        container.pop();
                    }
                    break;
                case '}':
                    if(!container.isEmpty() || container.peek() != '{'){
                        return false;
                    }else {
                        container.pop();
                    }
                    break;
                case ']':
                    if(!container.isEmpty() || container.peek() != '['){
                        return false;
                    }else {
                        container.pop();
                    }
                    break;
                default: return false;
            }
        }
        return container.isEmpty();
    }
}
