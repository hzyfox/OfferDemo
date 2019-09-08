package interview;

/**
 * KMP算法
 */
public class KMP {
    private int[] next(String a) {
        char[] arr = a.toCharArray();
        int[] next = new int[arr.length];
        next[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = next[i - 1]; ; j = next[j]) {
                if (arr[j + 1] == arr[i]) {
                    next[i] = j + 1;
                    break;
                } else {
                    if (j == -1) {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < next.length; i++) {
            next[i] += 1;
        }
        return next;
    }

    public int kmp(String s, String p) {
        int[] next = next(p);
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j - 1];
                }
            }
        }
        return j == p.length() ? i - p.length() : -1;
    }

    public static void main(String[] args) {
        String s = "1234567";
        String p = "34";
        KMP kmp = new KMP();
        System.out.println(kmp.kmp(s, p));
    }
}
