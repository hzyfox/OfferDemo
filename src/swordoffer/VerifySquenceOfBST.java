package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence.length == 0){
            return false;
        }
        return canDivide(sequence, 0, sequence.length - 1);
    }

    public boolean canDivide(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int target = sequence[end];
        int i = start;
        while (i < end) {
            if (sequence[i] < target) {
                i++;
            } else {
                break;
            }
        }
        int ans = i;
        while (i < end) {
            if (sequence[i] < target) {
                return false;
            }
            i++;
        }
        return canDivide(sequence, start, ans - 1) && canDivide(sequence, ans, end-1);
    }

    public static void main(String[] args) {
        int[] array = {9,7,8};
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(array));
    }
}
