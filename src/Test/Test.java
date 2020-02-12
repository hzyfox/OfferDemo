package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zyp
 */
public  class Test {
    static int flag = 0;
    public static void add(int flag){
        flag = flag +1;
    }
    public static void main(String[] args) {
//        int flag = 10;
//        Test.add(flag);
//        System.out.println(flag);
//        ArrayList<Integer> results = new ArrayList<>();
//        results.add(null);
//        int[] a={0,1};

        int a = 1;
        int b = 2;
        String x = b+""+a;
        System.out.println(x);

     StringBuilder str = new StringBuilder();
     str.append(a);
        System.out.println(str.toString());


    }
}
