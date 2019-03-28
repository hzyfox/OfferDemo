package swordoffer;

import java.util.ArrayList;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int leftBound = 0;
        int rightBound = col - 1;
        int upperBound = 0;
        int bottomBound = row - 1;

        while (leftBound <= rightBound && upperBound <= bottomBound) {
            for (int i = leftBound; i <= rightBound; i++) {
                ans.add(matrix[upperBound][i]);
            }
            for (int i = upperBound + 1; i < bottomBound; i++) {
                ans.add(matrix[i][rightBound]);
            }
            for (int i = rightBound; i >= leftBound && bottomBound > upperBound; i--) {
                ans.add(matrix[bottomBound][i]);
            }
            for (int i = bottomBound - 1; i > upperBound && rightBound > leftBound; i--) {
                ans.add(matrix[i][leftBound]);
            }
            leftBound++;
            rightBound--;
            upperBound++;
            bottomBound--;
        }
        return ans;
    }
}
