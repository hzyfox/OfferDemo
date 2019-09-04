package NiuKeLeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class Solution3 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.valueOf(scanner.nextLine());
//        String[] input = new String[n];
//        String[] output = new String[n];
//        for (int i = 0; i < n; i++) {
//            input[i] = scanner.nextLine();
//            output[i] = scanner.nextLine();
//        }
//        for (int i = 0; i < input.length; i++) {
//            baolipojie(input[i], output[i]);
//        }
        System.out.printf("%.2f", 3.2464444d);
    }
    public static void baolipojie(String input, String output) {
        ArrayList<ArrayList<Character>> ans = new ArrayList<>();//存放符合要求的答案
        ArrayList<ArrayList<Character>> ans0 = new ArrayList<>();//存放所有可能答案
        ArrayList<Character> tmp = new ArrayList<>();
        generateAns(input.length(), ans0, tmp);
        for (ArrayList<Character> solve : ans0) {
            ArrayList<Character> inputArr = new ArrayList<Character>();
            for (Character e : input.toCharArray()) {
                inputArr.add(e);
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < solve.size(); i++) {
                switch (solve.get(i)) {
                    case 'd':
                        inputArr.remove(0);
                        break;
                    case 'l':
                        builder.insert(0, inputArr.get(0));
                        inputArr.remove(0);
                        break;
                    case 'r':
                        builder.append(inputArr.get(0));
                        inputArr.remove(0);
                    default:
                }
                if (builder.toString().equals(output)) {
                    ans.add(solve);
                }
            }
        }
        System.out.println("{");
        for (int j = 0; j < ans.size(); j++) {
            ArrayList<Character> solve = ans.get(j);
            for (int i = 0; i < solve.size(); i++) {
                if (i != solve.size() - 1) {
                    System.out.print(solve.get(i));
                    System.out.print(' ');
                } else {
                    System.out.println(solve.get(i));
                }
            }
        }
        System.out.println("}");
    }


    public static void generateAns(int n, ArrayList<ArrayList<Character>> ans, ArrayList<Character> tmp) {
        if (tmp.size() == n) {
            ArrayList<Character> tmp0 = (ArrayList<Character>) tmp.clone();
            ans.add(tmp0);
            return;
        }

        for (int j = 0; j < 3; j++) {
            switch (j) {
                case 0:
                    tmp.add('d');
                    break;
                case 1:
                    tmp.add('l');
                    break;
                case 2:
                    tmp.add('r');
                    break;
                default:
            }
            generateAns(n, ans, tmp);
            tmp.remove(tmp.size() - 1);
        }

    }


}
