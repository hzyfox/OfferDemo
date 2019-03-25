package leetcode;

import java.util.LinkedList;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution73 {

    public void setZeroes0(int[][] matrix) {
        int zeroColFlag = 0;
        int row = matrix.length;
        int col = matrix.length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0 && matrix[i][j] == 0) {
                    zeroColFlag = 1;
                } else {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }

            }
        }

        for (int i = 1; i < col; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < row; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 1) {
                for (int j = 1; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for(int i = 1; i< col; i++){
                matrix[0][i] = 0;
            }
        }
        if(zeroColFlag == 1){
            for(int i=0; i< row; i++){
                matrix[i][0] = 0;
            }
        }

    }

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] zeroRowArrays = new int[row];
        int[] zeroColArrays = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    zeroRowArrays[i] = 1;
                    zeroColArrays[j] = 1;
                }
            }
        }


        for (int i = 0; i < zeroRowArrays.length; i++) {
            if (zeroRowArrays[i] == 1) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < zeroColArrays.length; i++) {
            if (zeroColArrays[i] == 1) {
                for (int j = 0; j < row; j++) {
                    matrix[j][i] = 0;
                }
            }
        }


    }
}
