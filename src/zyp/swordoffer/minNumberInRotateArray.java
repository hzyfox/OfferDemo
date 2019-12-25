package zyp.swordoffer;

/**
 * @author zyp
 */
public class minNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
       if(array.length == 0) return 0;
       int mid = array.length/2;
       while(mid<array.length&&mid>0){
           if(array[mid]<=array[array.length-1] && array[mid] <array[mid-1]) return array[mid];
           if(array[mid]>array[array.length-1]) mid++;
           else if(array[mid]<=array[array.length-1]) mid--;
       }
       return array[mid];
    }
}
