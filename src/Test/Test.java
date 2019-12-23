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

        String a = "123";
        String b = "123";
        a = "456";
        System.out.println(b);


        List<List<Integer>> list = new LinkedList<>();

        list.add(Arrays.asList(1));
        System.out.println(list.toString());
        for(int i =0;i<list.size();i++){
            list.get(i).add(2);

        }
        System.out.println(list.toString());






    }
}
