package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class LetterCombination {
    public static void main(String[] args) {
        System.out.println(new LetterCombination().letterCombinations0("23"));
    }

    public List<String> letterCombinations0(String digits) {
        if (digits.length() == 0) {
            return new LinkedList<String>();
        }
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> result = new LinkedList<>();
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (result.peek().length() == i) {
                String tmp = result.remove();
                for (int j = 0; j < mapping[x].length(); i++) {
                    result.add(tmp + mapping[x].charAt(j));
                }
            }
        }
        return result;
    }

    public List<String> letterCombinations(String digits) {
        LinkedList[] allList = new LinkedList[10];

        LinkedList<Character> list2 = new LinkedList<>();
        list2.add('a');
        list2.add('b');
        list2.add('c');
        allList[2] = list2;

        LinkedList<Character> list3 = new LinkedList<>();
        list3.add('d');
        list3.add('e');
        list3.add('f');
        allList[3] = list3;

        LinkedList<Character> list4 = new LinkedList<>();
        list4.add('g');
        list4.add('h');
        list4.add('i');
        allList[4] = list4;

        LinkedList<Character> list5 = new LinkedList<>();
        list5.add('j');
        list5.add('k');
        list5.add('l');
        allList[5] = list5;

        LinkedList<Character> list6 = new LinkedList<>();
        list6.add('m');
        list6.add('n');
        list6.add('o');
        allList[6] = list6;

        LinkedList<Character> list7 = new LinkedList<>();
        list7.add('p');
        list7.add('q');
        list7.add('r');
        list7.add('s');
        allList[7] = list7;

        LinkedList<Character> list8 = new LinkedList<>();
        list8.add('t');
        list8.add('u');
        list8.add('v');
        allList[8] = list8;

        LinkedList<Character> list9 = new LinkedList<>();
        list9.add('w');
        list9.add('x');
        list9.add('y');
        list9.add('z');
        allList[9] = list9;
        int[] indexs = new int[digits.length()];
        if (indexs.length == 0) {
            return new LinkedList<String>();
        }
        for (int i = 0; i < digits.length(); i++) {
            indexs[i] = Integer.valueOf(String.valueOf(digits.charAt(i)));
        }
        List<String> result = new LinkedList<>();
        List<Character> tmp = new LinkedList<>();
        combine(0, indexs, result, tmp, allList);
        return result;
    }

    public void combine(int index, int[] indexs, List<String> result, List<Character> tmp, LinkedList[] allList) {
        if (index == indexs.length) {
            StringBuilder stringBuilder = new StringBuilder();
            tmp.forEach(stringBuilder::append);
            result.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < allList[indexs[index]].size(); i++) {
            int size = tmp.size();
            tmp.add((Character) allList[indexs[index]].get(i));
            combine(index + 1, indexs, result, tmp, allList);
            tmp.remove(size);
        }
    }

}
