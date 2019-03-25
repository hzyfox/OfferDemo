package leetcode;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        // 首先寻找可能的行范围
        int loRow = 0;
        int hiRow = row - 1;
        while (loRow <= hiRow) {
            if (matrix[loRow][col - 1] < target) {
                loRow++;
            } else {
                while (hiRow >= loRow) {
                    if (matrix[hiRow][0] > target) {
                        hiRow--;
                    } else {
                        break;
                    }
                }
                break;
            }
        }
        if (loRow > hiRow) {
            return false;
        }
        for (int i = loRow; i <= hiRow; i++) {
            int lo0 = 0;
            int hi0 = col - 1;
            int mid0;
            while (lo0 <= hi0) {
                mid0 = (lo0 + hi0) / 2;
                if (matrix[i][mid0] == target) {
                    return true;
                } else {
                    if (matrix[i][mid0] < target) {
                        lo0 = mid0 + 1;
                    } else {
                        hi0 = mid0 - 1;
                    }
                }
            }
        }
        return false;
    }
}
