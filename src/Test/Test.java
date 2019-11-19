package Test;

import java.util.ArrayList;

/**
 * @author zyp
 */
public class Test {
    static int flag = 0;
    public static void add(int flag){
        flag = flag +1;
    }
    public static void main(String[] args) {
        int flag = 10;
        Test.add(flag);
        System.out.println(flag);
        ArrayList<Integer> results = new ArrayList<>();
        results.add(null);
        int[] a={0,1};


    }
}
