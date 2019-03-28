package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class MoreThanHalf {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 0;
        int solider = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == solider) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    solider = array[i];
                    count = 1;
                }
            }
        }
        count = 0;
       for(int i = 0; i<array.length; i++){
           if(array[i] == solider){
               count++;
           }
       }
       return  count > array.length/2 ? solider:0;
    }
}
