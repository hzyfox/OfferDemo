package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str.trim().equals("")) {
            return str;
        }
        if (str == null || str.length() == 0) {
            return str;
        }
        String[] strs = str.split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            builder.append(strs[i]);
            if (i > 0) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    public String ReverseSentence0(String str) {
        char[] array = str.toCharArray();
        int blank = -1;
        reverse(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                reverse(array, blank + 1, i - 1);
                blank = i;
            }
        }
        reverse(array, blank + 1, array.length - 1);
        return String.valueOf(array);
    }

    public void reverse(char[] chars, int low, int high) {
        while (low < high) {
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseSentence().ReverseSentence("a"));
    }
}
