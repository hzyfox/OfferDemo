package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Find {
    public boolean Find(int target, int[][] array) {
        //从右上角或者左下角看，是一颗二叉搜索树
        if(array == null || array.length < 1 || array[0].length <1) {
            return false;
        }
        int col = array[0].length-1;
        int row = 0;
        while(col >= 0 && row <= array.length-1) {
            if(target == array[row][col]) {
                return true;
            } else if(target < array[row][col]) {
                col--;
            } else if(target > array[row][col]) {
                row++;
            }
        }
        return false;
    }

}
