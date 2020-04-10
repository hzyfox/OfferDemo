package Test;

import javafx.util.Pair;

import java.util.*;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

/**
 * @author zyp
 */
public  class Test {

    public static void main(String[] args) {
        Test test = new Test();
        int[] nums = {10, 5, 3, 7, 0, 4, 5, 2, 1, 8};

        Map<Character,Integer> map = new HashMap<>();
        map.put('a',2);
//        int x = map.get('a');
        map.merge('a',-1,Integer::sum);

    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}



