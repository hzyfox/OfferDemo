/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().myAtoi("  -0012a42"));
    }

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int startIdx = 0;
        boolean negativeSign = false;
        int negativeBound = -(Integer.MIN_VALUE / 10);
        int positiveBound = Integer.MAX_VALUE / 10;
        while (startIdx < str.length()) {
            if (str.charAt(startIdx) != ' ') {
                break;
            }
            startIdx++;
        }
        if(startIdx == str.length()){
            return 0;
        }
        if (str.charAt(startIdx) == '-') {
            negativeSign = true;
            startIdx++;
        }else if(str.charAt(startIdx) == '+'){
            startIdx++;
        }
        int result = 0;
        for (int i = startIdx; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (negativeSign) {
                    if (result > negativeBound || (result == negativeBound && ((str.charAt(i) - '0') > 8))) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if (result > positiveBound || (result == positiveBound) && ((str.charAt(i) - '0') > 7)) {
                        return Integer.MAX_VALUE;
                    }
                }
                result = result * 10 + (str.charAt(i) - '0');
            } else {
                return negativeSign ? -result : result;
            }
        }
        return negativeSign ? -result : result;
    }
}

