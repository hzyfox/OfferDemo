/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        int theLast = nums.length - 1;
        int index = nums.length - 2;
        while (index >= 0) {
            //不能到达大于theLast的地方 就不可能到达终点
            //能到达theLast 就能到达终点， 步步缩小范围。
            if ((index + nums[index]) >= theLast) {
                theLast = index;
            }
            index--;
        }
        if (theLast == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] test = {2, 3, 1, 1, 4};
        System.out.println(new Solution55().canJump(test));
    }
}
