/**
 *
 *  * clockwise rotate
 *  * first reverse up to down, then swap the symmetry
 *  * 1 2 3     7 8 9     7 4 1
 *  * 4 5 6  => 4 5 6  => 8 5 2
 *  * 7 8 9     1 2 3     9 6 3
 *
 *
 *  * anticlockwise rotate
 *  * first reverse left to right, then swap the symmetry
 *  * 1 2 3     3 2 1     3 6 9
 *  * 4 5 6  => 6 5 4  => 2 5 8
 *  * 7 8 9     9 8 7     1 4 7
 *
 *
 */
public class Solution48 {

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            reverseTopDown(matrix, i, matrix.length - 1 - i);
        }
        for(int i = 0; i< matrix.length; i++){
            for(int j = i+1; j< matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reverseTopDown(int[][] matrix, int top, int down) {
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[top][i];
            matrix[top][i] = matrix[down][i];
            matrix[down][i] = temp;
        }
    }
}
