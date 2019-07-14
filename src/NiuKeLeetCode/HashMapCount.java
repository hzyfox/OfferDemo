package NiuKeLeetCode;

import java.util.Collections;
import java.util.HashMap;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class HashMapCount {
    public static void main(String[] args) {
        int[] array = {4,3,5,0,6,1};
        HashMapCount hashMapCount = new HashMapCount();
        System.out.println(hashMapCount.numberSum(array, 7));
    }

    public int numberSum(int[] array, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0;
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (map.containsKey(sum - target)) {
                map.put(sum,map.getOrDefault(sum,0)+1);
                counter += map.get(sum - target);
            }else{
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        return counter;
    }

}
