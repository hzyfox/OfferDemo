/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            if (l == r && nums[l] == target) {
                ans = l;
                break;
            }
            int mid = (l + r) / 2;

            //左边有序 <= 否则会mid+1 out of bound
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && nums[mid] >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else {
                //右边有序
                if (nums[mid + 1] <= target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,1,2};
        System.out.println(new Solution33().search(a,3));
    }
}
