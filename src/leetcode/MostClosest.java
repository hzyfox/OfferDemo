package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class MostClosest {
    public static void main(String[] args) {

        closetLarge(35279);
    }



    public static int closetLarge(int num) {
        String s = String.valueOf(num);
        LinkedList<Character> charList = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            charList.add(s.charAt(i));
        }
        LinkedList<Character> tmp = new LinkedList<>();
        LinkedList<Integer> tmp0 = new LinkedList<>();
        List<List<Character>> allResult = new LinkedList<>();
        findCloset(charList, tmp, allResult, charList.size(), tmp0);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < allResult.get(0).size(); i++) {
            stringBuilder.append(allResult.get(0).get(i));
        }

        System.out.println(Integer.valueOf(stringBuilder.toString()));
        return Integer.valueOf(stringBuilder.toString());
    }

    public static void findCloset(LinkedList<Character> original, LinkedList<Character> tmp, List<List<Character>> allResult, int leftNum, LinkedList<Integer> tmp0) {
        if (leftNum == 0) {
            if (allResult.size() == 0 && compare(tmp, original) == 1) {
                allResult.add(new LinkedList<>(tmp));
                return;
            } else {
                if (allResult.size() == 1 && compare(tmp, original) == 1) {
                    if (compare(allResult.get(0), tmp) == 1) {
                        allResult.remove(0);
                        allResult.add(new LinkedList<>(tmp));
                    }
                }
                return;
            }
        }
        for (int i = 0; i < original.size(); i++) {
            if (!tmp0.contains(i)) {
                int size = tmp.size();
                tmp.add(original.get(i));
                tmp0.add(i);
                findCloset(original, tmp, allResult, leftNum - 1, tmp0);
                tmp.remove(size);
                tmp0.remove(size);
            }
        }
    }

    public static int compare(List<Character> a, List<Character> b) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) < b.get(i)) {
                return -1;
            } else {
                if (a.get(i) > b.get(i)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public Integer integerArray2Integer(Integer[] integers) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(integers).forEach((a) -> stringBuilder.append(a.intValue()));
        return Integer.valueOf(stringBuilder.toString());
    }
}
