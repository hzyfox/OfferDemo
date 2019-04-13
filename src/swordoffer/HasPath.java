package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0 || str == null || str.length == 0) {
            return false;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (walk(matrix, rows, cols, i, j, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean walk(char[] matrix, int rows, int cols, int startRow, int startCol, char[] str, int index) {
        if (index == str.length) {
            return true;
        }
        if (startRow < 0 || startRow >= rows || startCol < 0 || startCol >= cols||matrix[startRow * cols + startCol] != str[index] ) {
            return false;
        } else {
            char tmp = matrix[startRow * cols + startCol];
            matrix[startRow * cols + startCol] = '#';
            if (walk(matrix, rows, cols, startRow + 1, startCol, str, index + 1)) {
                return true;
            }
            if (walk(matrix, rows, cols, startRow - 1, startCol, str, index + 1)) {
                return true;
            }
            if (walk(matrix, rows, cols, startRow, startCol + 1, str, index + 1)) {
                return true;
            }
            if (walk(matrix, rows, cols, startRow, startCol - 1, str, index + 1)) {
                return true;
            }
            matrix[startRow * cols + startCol] = tmp;
            return false;
        }
    }

    public static void main(String[] args) {
        char[] matrix = "ABCESFCSADEE".toCharArray();
        char[] str = "SEE".toCharArray();
        System.out.println(new HasPath().hasPath(matrix, 3, 4, str));
    }

}
