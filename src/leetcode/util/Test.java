package leetcode.util;

import apple.laf.JRSUIUtils;
import leetcode.structure.TreeNode;

import java.util.*;

/**
 * create with leetcode.util
 * USER: husterfox
 */
public class Test {
    TreeNode firstElem = null;
    TreeNode secondElem = null;
    TreeNode prev = null;

    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[128];
        int counter = 0;
        int end = 0;
        int start = 0;
        int ans = Integer.MIN_VALUE;
        while (end < s.length()) {
            if (hash[s.charAt(end++)]++ > 0) {
                counter++;
            }
            while (counter > 0) {
                if (hash[s.charAt(start++)]-- > 1) {
                    counter--;
                }
            }
            ans = Math.max(end - start + 1, ans);
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }


    public int value(char ch) {
        return (ch - 'a');
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.lengthOfLongestSubstring("abcabcbb");
    }
}
