import java.util.Arrays;
import java.util.Comparator;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<1){
            return "";
        }
        int minLength = Arrays.stream(strs).min(Comparator.comparingInt(String::length)).orElse("").length();
        for (int i = 0; i < minLength; i++) {
            int finalI = i;
            if (!Arrays.stream(strs).allMatch((item) -> item.charAt(finalI) == strs[0].charAt(finalI))) {
                return strs[0].substring(0, i);
            }
        }
        return strs[0].substring(0, minLength);
    }

    public static void main(String[] args) {
        "1".substring(0,0);
    }
}
