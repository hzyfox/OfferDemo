/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int hi, lo;
        lo = searchLowerBound(nums, target);
        if (lo >= nums.length || nums[lo] != target) {
            return new int[]{-1, -1};
        }
        hi = searchLowerBound(nums, target + 1);
        result[0] = lo;
        result[1] = hi;
        return result;
    }

    public int searchLowerBound(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] test = {1};
        new Solution34().searchRange(test, 1);
    }
}
