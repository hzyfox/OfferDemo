package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new LinkedList<>();
        }
        List<Integer> store = new LinkedList<>();
        spiral(matrix, 0, matrix.length - 1, 0, matrix[0].length-1, store);
        return store;
    }

    public void spiral(int[][] matrix, int startRow, int endRow, int startCol, int endCol, List<Integer> store) {
        if (startRow > endRow || startCol > endCol) {
            return;
        }
        //首行
        for (int col = startCol; col <= endCol; col++) {
            store.add(matrix[startRow][col]);
        }
        //最后一列 去除首尾两个数字
        for (int row = startRow + 1; row <= endRow - 1; row++) {
            store.add(matrix[row][endCol]);
        }
        //最后一行
        for (int col = endCol; endRow > startRow && col >= startCol; col--) {
            store.add(matrix[endRow][col]);
        }

        //最前面一列 去除首尾两个数字
        for (int row = endRow - 1; endCol > startCol && row >= startRow + 1; row--) {
            store.add(matrix[row][startCol]);
        }
        spiral(matrix, startRow + 1, endRow - 1, startCol + 1, endCol - 1, store);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        System.out.println(new Solution54().spiralOrder(matrix));
    }
}
