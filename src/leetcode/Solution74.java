package leetcode;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        //找属于哪一行
        int loRow = 0;
        int hiRow = row - 1;
        int midRow;
        int targetRow = -1;
        while (loRow <= hiRow) {
            midRow = (loRow + hiRow) / 2;
            if (target >= matrix[midRow][0] && target <= matrix[midRow][col - 1]) {
                targetRow = midRow;
                break;
            } else {
                if (target > matrix[midRow][col - 1]) {
                    loRow = loRow + 1;
                } else {
                    hiRow = loRow - 1;
                }
            }
        }
        if (targetRow == -1) {
            return false;
        }
        //现在我们找到targetRow了
        int lo = 0;
        int hi = col - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (target == matrix[targetRow][mid]) {
                return true;
            } else {
                if (matrix[targetRow][mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {1,3}
        };
        System.out.println(new Solution74().searchMatrix(arrays,3));
    }
}
