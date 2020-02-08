package zyp.swordoffer;

import java.util.ArrayList;

/**
 * @author zyp
 */
public class printMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int collor = matrix[0].length;
        int row = matrix.length;
        int circle = (Math.min(collor, row) + 1) / 2 - 1;
        int m = collor,n=row;
        for (int flag=0;flag <= circle;flag++,m--,n--) {
            for (int j=flag,i=flag; j < m; j++) {
                arrayList.add(matrix[i][j]);
                System.out.println(matrix[i][j]);
            }
            for (int j=collor-flag-1,i=flag+1; i < n; i++) {
                arrayList.add(matrix[i][j]);
                System.out.println(matrix[i][j]);

            }
            for (int i=row-flag-1,j=collor-flag-2;j>=flag&&i!=flag;j--) {

                arrayList.add(matrix[i][j]);
                System.out.println(matrix[i][j]);

            }
            for (int i=row-flag-2,j=flag; i >= flag + 1&&j!=collor-flag-1; i--) {
                arrayList.add(matrix[i][j]);
                System.out.println(matrix[i][j]);
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[][] a = {{1},{2},{3},{4},{5}};
        printMatrix p = new printMatrix();
        p.printMatrix(a);
    }
}
