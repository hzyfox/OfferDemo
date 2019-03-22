/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] store = new int[n][n];
        if (n == 0) {
            return new int[0][0];
        }
        generate(store, 0, n - 1, 0, n - 1, 1);
        return store;
    }

    public void generate(int[][] store, int startRow, int endRow, int startCol, int endCol, int startValue) {
        if (startCol > endCol || startRow > endRow) {
            return;
        }

        //先赋值第一行
        for (int col = startCol; col <= endCol; col++) {
            store[startRow][col] = startValue++;
        }

        //赋值最右边列,去除首尾
        for (int row = startRow + 1; row < endRow; row++) {
            store[row][endCol] = startValue++;
        }

        //赋值最下面一行, 去除只有一行的情况
        for (int col = endCol; endRow > startRow && col >= startCol; col--) {
            store[endRow][col] = startValue++;
        }

        //赋值最左边列,去除只有一行的情况,去除首尾
        for (int row = endRow - 1; endCol > startCol && row > startRow; row--) {
            store[row][startCol] = startValue++;
        }

        generate(store, startRow + 1, endRow - 1, startCol + 1, endCol - 1, startValue);

    }

    public static void main(String[] args) {
        int[][] a = new Solution59().generateMatrix(3);
        System.out.println(a);
    }
}
