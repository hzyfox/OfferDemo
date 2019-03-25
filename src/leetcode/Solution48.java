package leetcode;

/**
 * * clockwise rotate
 * * first reverse up to down, then swap the symmetry
 * * 1 2 3     7 8 9     7 4 1
 * * 4 5 6  => 4 5 6  => 8 5 2
 * * 7 8 9     1 2 3     9 6 3
 * <p>
 * <p>
 * * anticlockwise rotate
 * * first reverse left to right, then swap the symmetry
 * * 1 2 3     3 2 1     3 6 9
 * * 4 5 6  => 6 5 4  => 2 5 8
 * * 7 8 9     9 8 7     1 4 7
 */
public class Solution48 {

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            reverseTopDown(matrix, i, matrix.length - 1 - i);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
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

    /**
     * 1   2   3   4   5
     * 6   7   8   9  10
     * 11  12  13  14 15
     * 16  17  18  19 20
     * 21  22  23  24 25
     * <p>
     * 我们发现
     * 第j列经过九十度顺时针翻转 会到第j行
     * 第i行经过九十度顺时针翻转 会到第n-i-1列（从0开始计数）
     * 于是（i，j ) => (j, n-1-i)
     * <p>
     * 我们发现
     * 第j列经过逆时针90翻转 会到(n-1-j)行
     * 第i行经过逆时针90翻转 会到i列
     * 于是(i,j) => (n-1-j,i)
     * <p>
     * <p>
     * 为了Inplace，我们需要对整个矩阵分区，每个分区经过一次90旋转就会转到下一个分区，一共转四次转回最开始的位置
     * top_left 分区位置: 左上: (0,0) 右上(0,(n+1)/2) 左下 (n/2,0) 右下(n/2, (n+1)/2)
     * top_right 分区位置 左上: (0, (n+1)/2+1) 右上: (0,n-1) 左下((n+1)/2,(n+1)/2+1) 右下((n+1)/2,n-1) //top right 由 topleft翻转90形成
     * bottom_right 由top_right翻转90形成
     * bottom_left 由bottom_right翻转90形成
     */

    public void rorate0(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        if (matrix.length == 1 && matrix[0].length == 1) {
            return;
        }
        int n = matrix.length;
        int topLeftStartRow = 0;
        int topLeftEndRow = n / 2;
        int topLeftStartCol = 0;
        int topLeftEndCol = (n + 1) / 2;

        for (int i = topLeftStartRow; i < topLeftEndRow; i++) {
            for (int j = topLeftStartCol; j < topLeftEndCol; j++) {
                int currRow = i;
                int currCol = j;
                int nextRow = currCol;
                int nextCol = n - currRow - 1;
                int waitingWrite = matrix[currRow][currCol];
                int saved = matrix[nextRow][nextCol];

                //写入
                int cnt = 0;
                while (cnt <= 4) {
                    cnt++;
                    matrix[nextRow][nextCol] = waitingWrite;
                    waitingWrite = saved;
                    currRow = nextRow;
                    currCol = nextCol;
                    nextRow = currCol;
                    nextCol = n - currRow - 1;
                    saved = matrix[nextRow][nextCol];
                }
            }
        }

    }
}
