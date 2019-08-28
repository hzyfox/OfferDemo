package NiuKeLeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class Shoppe1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.nextLine();
        if (digits.length() == 0) {
            System.out.println("");
            return;
        }
        List<String> result = letterCombinations(digits);
        for (int i = 0; i < result.size(); i++) {
            if (i != result.size() - 1) {
                System.out.print(result.get(i));
                System.out.print(" ");
            } else {
                System.out.println(result.get(i));
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        String[][] map = new String[][]{{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r"}, {"s", "t", "u"}, {"v", "w", "x"}, {"y", "z"}};
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            while (list.peekFirst().length() == i) {
                String tmp = list.removeFirst();
                for (int j = 0; j < map[Character.getNumericValue(digits.charAt(i)) - 1].length; j++) {
                    list.add(tmp + map[i][j]);
                }
            }
        }
        return list;
    }
}