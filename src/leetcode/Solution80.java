package leetcode;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int dummy = -1;
        int prev = nums[0];
        int cnt = 1;
        boolean firstDummy = true;
        int firstDummyPos = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                cnt++;
                if (cnt > 2) {
                    if (firstDummy) {
                        firstDummyPos = i;
                        firstDummy = false;
                    }
                    nums[i] = dummy;
                }
            } else {
                cnt = 1;
                prev = nums[i];
            }
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != dummy) {
                ans++;
            }
        }
        if (!firstDummy) {
            for (int i = firstDummyPos + 1; i < nums.length; i++) {
                if (nums[i] != dummy) {
                    nums[firstDummyPos++] = nums[i];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] array = {1, 2};
        System.out.println(new Solution80().removeDuplicates(array));
    }
}
