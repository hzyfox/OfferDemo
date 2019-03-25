package leetcode;

import java.util.ArrayList;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> arrayList;
        if (matrix.length == 0 || matrix[0].length == 0) {
            arrayList = new ArrayList<Integer>();
            return arrayList;
        }
        arrayList = new ArrayList<Integer>(matrix.length * matrix[0].length);
        printM(0, matrix.length - 1, 0, matrix[0].length - 1, matrix, arrayList);
        return arrayList;
    }

    public void printM(int startRowIndex, int endRowIndex, int startColumnIndex,
                       int endColumnIndex, int[][] matrix, ArrayList<Integer> arrayList) {
        if (startRowIndex > endRowIndex) {
            return;
        }
        if (startColumnIndex > endColumnIndex) {
            return;
        }
        for (int i = startColumnIndex; i <= endColumnIndex; i++) {
            arrayList.add(matrix[startRowIndex][i]);
        }
        for (int i = startRowIndex + 1; i <= endRowIndex; i++) {
            arrayList.add(matrix[i][endColumnIndex]);
        }
        if(startRowIndex + 1 <= endRowIndex) {
            for (int i = endColumnIndex - 1; i >= startColumnIndex; i--) {
                arrayList.add(matrix[endRowIndex][i]);
            }
        }
        if(endColumnIndex - 1 >= startRowIndex) {
            for (int i = endRowIndex - 1; i >= startRowIndex + 1; i--) {
                arrayList.add(matrix[i][startColumnIndex]);
            }
        }
        printM(startRowIndex + 1, endRowIndex - 1,
                startColumnIndex + 1, endColumnIndex - 1, matrix, arrayList);
    }

    public static void main(String[] args) {
        int[][]matrix = new int[][]{{1},{2},{3},{4},{5}};
        ArrayList<Integer> arrayList = new PrintMatrix().printMatrix(matrix);
        System.out.println(arrayList.size());

    }
}
