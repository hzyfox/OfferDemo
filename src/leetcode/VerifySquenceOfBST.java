package leetcode;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return sequence.length == 1 || ju(sequence, 0, sequence.length - 1);
    }

    public boolean ju(int[] a, int star, int root) {
        if (star >= root) {
            return true;
        }
        int i = root;
        while (i > star && a[i - 1] > a[root]) {
            i--;
        }
        for (int j = star; j < i - 1; j++) {
            if (a[j] > a[root]) {
                return false;
            }
        }
        return ju(a, star, i - 1) && ju(a, i, root - 1);
    }
}


