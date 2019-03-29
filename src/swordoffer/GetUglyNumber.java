package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index < 7) {
            return index;
        }
        int[] ans = new int[index];
        ans[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 0; i < index; i++) {
            int min = Math.min(ans[t2] * 2, Math.min(ans[t3] * 3, ans[t5] * 5));
            if (min == ans[t2] * 2) {
                t2++;
            }
            if (min == ans[t3] * 3) {
                t3++;
            }
            if (min == ans[t5] * 5) {
                t5++;
            }

        }
        return ans[index - 1];
    }
}
