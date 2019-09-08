package leetcode;


import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class ReplacePlace {
    public String replaceSpace(StringBuffer str) {
        String regex = "\\s";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        Arrays.sort(new String[2], new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return matcher.replaceAll("%20");


    }
}
