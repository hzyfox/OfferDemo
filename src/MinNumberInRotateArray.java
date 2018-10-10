/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return  0;
        }
        for( int i = 0; i > array.length - 1; i++){
            if(array[i] < array[i-1]){
                return array[i];
            }
        }
        return array[0];
    }

    public static void main(String[] args) {
        int[]array = new int[]{3,4,5,1,2};
        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(array));
    }
}
