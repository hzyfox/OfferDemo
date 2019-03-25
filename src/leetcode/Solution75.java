package leetcode;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution75 {
    //基本思想: 将所有0交换到数组的前面，增加填充0的下标 ，将所有1交换到数组的后面减少填充2的下标。
    public void sortColors(int[] nums) {
        int zeroPos = 0;
        int twoPos = nums.length - 1;
        for (int i = 0; i <= twoPos; i++) {
            if (nums[i] == 0 && i != zeroPos) {
                nums[i] = nums[zeroPos];
                nums[zeroPos] = 0;
                zeroPos++;
                i--;
            } else {
                if (nums[i] == 2 && i != twoPos) {
                    nums[i] = nums[twoPos];
                    nums[twoPos] = 2;
                    twoPos--;
                    i--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 2, 2, 2, 0, 2, 1, 1};
        new Solution75().sortColors(array);
        System.out.println(array);
    }
}
