package leetcode;

import java.util.HashMap;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Roman2Int {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int result = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>(8);
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && compare(s.charAt(i), s.charAt(i + 1), hashMap) != -1) {
                result += hashMap.get(s.charAt(i));
            } else if (i + 1 < s.length()) {
                result += (hashMap.get(s.charAt(i + 1)) - hashMap.get(s.charAt(i)));
                i++;
            } else {
                result += hashMap.get(s.charAt(i));
            }
        }
        return result;
    }

    public static int compare(char x, char y, HashMap<Character, Integer> valueMap) {
        if (valueMap.get(x) < valueMap.get(y)) {
            return -1;
        } else if (valueMap.get(x).equals(valueMap.get(y))) {
            return 0;
        } else {
            return 1;
        }
    }
}
