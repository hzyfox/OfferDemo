package swordoffer;

import java.util.HashSet;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        HashSet<Long> store = new HashSet<>();
        move(0, 0, threshold, rows, cols, store);
        return store.size();
    }

    public boolean bitCount(int row, int col, int threshold) {
        int count = 0;
        while (row != 0) {
            int tmp = row % 10;
            count += tmp;
            row = row / 10;
        }
        while (col != 0) {
            int tmp = col % 10;
            count += tmp;
            col = col / 10;
        }
        return count > threshold;
    }

    public void move(int row, int col, int threshold, int rows, int cols, HashSet<Long> store) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || bitCount(row, col, threshold) || store.contains((long) row << 32 | (long) col)) {
            return;
        }
        store.add((long) row << 32 | (long) col);
        move(row - 1, col, threshold, rows, cols, store);
        move(row + 1, col, threshold, rows, cols, store);
        move(row, col - 1, threshold, rows, cols, store);
        move(row, col + 1, threshold, rows, cols, store);
    }

    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(6,5,5));
    }
}
