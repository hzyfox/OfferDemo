package leetcode;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class MidOfTwoArray {
    public static double findMidle(int[] leftArray, int[] rightArray) {
        int leftMiddle = (leftArray.length + rightArray.length + 1) / 2;
        int rightMiddle = (leftArray.length + rightArray.length + 2) / 2;
        return (findMiddleHelper(leftArray, 0, rightArray, 0, leftMiddle) + findMiddleHelper(leftArray, 0, rightArray, 0, rightMiddle)) / 2.0;
    }



    public static int findMiddleHelper(int[] leftArray, int leftStart, int[] rightArray, int rightStart, int middle) {
        //左数组为空
        if (leftStart > leftArray.length - 1) {
            return rightArray[rightStart + middle - 1];
        }
        //右数组为空
        if (rightStart > rightArray.length - 1) {
            return leftArray[leftStart + middle - 1];
        }
        if (middle == 1) {
            return Math.min(leftArray[leftStart], rightArray[rightStart]);
        }
        int leftMid = Integer.MAX_VALUE;
        int rightMid = Integer.MAX_VALUE;
        if (leftStart + middle / 2 - 1 < leftArray.length) {
            leftMid = leftArray[leftStart + middle / 2 - 1];
        }
        if (rightStart + middle / 2 - 1 < rightArray.length) {
            rightMid = rightArray[rightStart + middle / 2 - 1];
        }
        if (leftMid < rightMid) {
            return findMiddleHelper(leftArray, leftStart + middle / 2, rightArray, rightStart, middle - middle / 2);
        } else {
            return findMiddleHelper(leftArray, leftStart, rightArray, rightStart + middle / 2, middle - middle / 2);
        }
    }

    public static void main(String[] args) {
        int[] leftArray = {1};
        int[] rightArray = {2, 3, 4, 5, 6};
        System.out.println(findMidle(leftArray, rightArray));
    }
}
