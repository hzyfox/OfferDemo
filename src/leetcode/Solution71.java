package leetcode;

import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution71 {
    final Pattern singleDot = Pattern.compile("\\.(?=/)|\\.$");
    final Pattern doubleDots = Pattern.compile("\\.\\.(?=/)|\\.\\.$");
    final Pattern dirName = Pattern.compile("\\.*[^/]+\\.*|\\.\\.\\.+[^/]*");
    final Pattern backSlashes = Pattern.compile("/+");
    LinkedList<String> dirs = new LinkedList<String>() {
        @Override
        public String toString() {
            StringBuilder path = new StringBuilder();
            path.append("/");
            for (String s : this) {
                path.append(s);
                path.append("/");
            }
            if (this.size() > 0) {
                path.deleteCharAt(path.length() - 1);
            }
            return path.toString();
        }
    };

    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return path;
        }
        while (path.length() > 0) {
            Matcher backSlashMatcher = backSlashes.matcher(path);
            if (backSlashMatcher.find() && backSlashMatcher.start() == 0) {
                path = path.substring(backSlashMatcher.end());
                continue;
            }
            Matcher singleDotMatcher = singleDot.matcher(path);
            if (singleDotMatcher.find() && singleDotMatcher.start() == 0) {
                path = path.substring(singleDotMatcher.end());
                continue;
            }
            Matcher doubleDotsMatcher = doubleDots.matcher(path);
            if (doubleDotsMatcher.find() && doubleDotsMatcher.start() == 0) {
                if (!dirs.isEmpty()) {
                    dirs.pollLast();
                }
                path = path.substring(doubleDotsMatcher.end());
                continue;
            }
            Matcher dirNameMatcher = dirName.matcher(path);
            if (dirNameMatcher.find() && dirNameMatcher.start() == 0) {
                dirs.offer(path.substring(dirNameMatcher.start(), dirNameMatcher.end()));
                path = path.substring(dirNameMatcher.end());
            }

        }
        return dirs.toString();
    }

    public String simplifyPath0(String path) {
        if (path.length() <= 1) {
            return "/";
        }
        Stack<String> store = new Stack<String>() {
            @Override
            public synchronized String toString() {
                StringBuilder path = new StringBuilder();
                path.append("/");
                for (String s : this) {
                    path.append(s);
                    path.append("/");
                }
                if (!this.isEmpty()) {
                    path.deleteCharAt(path.length() - 1);
                }
                return path.toString();
            }
        };

        while (path.length() != 0) {
            //  清除/
            if (path.startsWith("/")) {
                int cnt = 1;
                while (cnt < path.length() && path.charAt(cnt) == '/') {
                    cnt++;
                }
                path = path.substring(cnt);
                continue;
            }

            // 清除 .
            if (path.startsWith("./") || (path.startsWith(".") && path.length() == 1)) {
                int cnt = 1;
                while (cnt < path.length() && path.charAt(cnt) == '/') {
                    cnt++;
                }
                path = path.substring(cnt);
                continue;
            }

            // 清除..

            if (path.startsWith("../") || path.startsWith("..") && path.length() == 2) {
                int cnt = 2;
                while (cnt < path.length() && path.charAt(cnt) == '/') {
                    cnt++;
                }
                path = path.substring(cnt);
                if (!store.isEmpty()) {
                    store.pop();
                }
                continue;
            }

            //获取目录名称
            int cnt = 0;
            while (cnt < path.length() && path.charAt(cnt) != '/') {
                cnt++;
            }
            String dir = path.substring(0, cnt);
            store.push(dir);
            while (cnt < path.length() && path.charAt(cnt) == '/') {
                cnt++;
            }
            path = path.substring(cnt);
        }
        return store.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution71().simplifyPath0("/../"));
    }
}
