import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class ReorderArray {
    public void reOrderArray(int[] array) {
        int[] newArray = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                newArray[j++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                newArray[j++] = array[i];
            }
        }
        System.arraycopy(newArray,0,array,0,array.length);
    }

    public static void main(String[] args) {
        int [] array = new int[]{1,2,3,4,5,6,7};
        new ReorderArray().reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
