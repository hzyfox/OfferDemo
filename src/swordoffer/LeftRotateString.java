package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class LeftRotateString {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) {
            return str;
        }
        n = n % str.length();
        String right = str.substring(0, n);
        String left = str.substring(n);
        return left + right;
    }

    public String LeftRotateString0(String str, int n) {
        //YX = (X^T Y^T)^T T代表转置
        if (str == null || str.length() == 0) {
            return str;
        }
        n = n % str.length();
        if (n == 0) {
            return str;
        }

        char[] buffer = str.toCharArray();

        for (int i = 0, j = n-1; i < j; i++, j--) {
            char tmp = buffer[i];
            buffer[i] = buffer[j];
            buffer[j] = tmp;
        }
        //再对剩下的进行翻转
        for (int i = n, j = str.length() - 1; i < j; i++, j--) {
            char tmp = buffer[i];
            buffer[i] = buffer[j];
            buffer[j] = tmp;
        }
        //先整个字符串进行翻转
        for (int i = 0, j = buffer.length - 1; i < j; i++, j--) {
            char tmp = buffer[i];
            buffer[i] = buffer[j];
            buffer[j] = tmp;
        }
        return String.valueOf(buffer);
    }
}
