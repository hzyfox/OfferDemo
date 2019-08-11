package NiuKeLeetCode;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class KMP {
    public int[] caclF(String s) {
        int[] f = new int[s.length()];
        f[0] = -1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = f[i - 1]; ; j = f[j]) {
                if (s.charAt(j + 1) == s.charAt(i)) {
                    f[i] = j + 1;
                } else {
                    if (j == -1) {
                        break;
                    }
                }
            }
        }
        return f;
    }

    public int kmp(String s, String p) {
        int sIndex = 0;
        int pIndex = 0;
        int[] f = caclF(p);
        while (sIndex < s.length() && pIndex < p.length()) {
            if (s.charAt(sIndex) == p.charAt(pIndex)) {
                sIndex++;
                pIndex++;
            } else {
                if (pIndex == 0) {
                    sIndex++;
                } else {
                    sIndex = f[pIndex - 1] + 1;
                }
            }
        }
        if (pIndex == p.length()) {
            return sIndex - p.length();
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String s = "1234567";
        String p = "34";
        KMP kmp = new KMP();
        System.out.println(kmp.kmp(s, p));
    }
}
