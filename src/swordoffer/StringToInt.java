package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class StringToInt {
    public int StrToInt(String str) {
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
        if (startIdx == str.length()) {
            return 0;
        }
        if (str.charAt(startIdx) == '-') {
            negativeSign = true;
            startIdx++;
        } else if (str.charAt(startIdx) == '+') {
            startIdx++;
        }
        int result = 0;
        for (int i = startIdx; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (negativeSign) {
                    if (result > negativeBound || (result == negativeBound && ((str.charAt(i) - '0') > 8))) {
                        return 0;
                    }
                } else {
                    if (result > positiveBound || (result == positiveBound) && ((str.charAt(i) - '0') > 7)) {
                        return 0;
                    }
                }
                result = result * 10 + (str.charAt(i) - '0');
            } else {
                return 0;
            }
        }
        return negativeSign ? -result : result;
    }
}
