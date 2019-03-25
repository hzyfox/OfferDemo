package leetcode;

import java.util.HashSet;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        HashSet<String> used = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (find(board, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, int startRow, int startCol, String word) {
        if (word.length() == 0) {
            return true;
        }
        if (startRow < 0 || startRow >= board.length || startCol < 0 || startCol >= board[0].length || word.charAt(0) != board[startRow][startCol]) {
            return false;
        }
        char tmp = board[startRow][startCol];
        board[startRow][startCol] = '#';
        boolean res = find(board, startRow + 1, startCol, word.substring(1)) || find(board, startRow - 1, startCol, word.substring(1))
                || find(board, startRow, startCol + 1, word.substring(1)) || find(board, startRow, startCol - 1, word.substring(1));
        board[startRow][startCol] = tmp;
        return res;
    }

    public static void main(String[] args) {
//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
        char[][] board = {
                {'a', 'a'}
        };
        System.out.println(new Solution79().exist(board, "aaa"));
    }
}
