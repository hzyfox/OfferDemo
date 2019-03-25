package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class ReplacePlace {
    public String replaceSpace(StringBuffer str) {
        String regex = "\\s+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll("%20");
    }
}
