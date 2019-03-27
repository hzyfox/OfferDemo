package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (j < str.length()) {
                if (str.charAt(j) == ' ') {
                    break;
                }
                j++;
            }
            int k = j + 1;
            while (k < str.length()) {
                if (str.charAt(k) != ' ') {
                    break;
                }
                k++;
            }
            StringBuilder builder = new StringBuilder();
            for (int m = j; m < k; m++) {
                builder.append("%20");
            }
            if (j >= str.length()) {
                break;
            } else {
                str.replace(j, k, builder.toString());
            }

            i = k + (k - j) * 3;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("");
        System.out.println(new ReplaceSpace().replaceSpace(buffer));
    }
}
