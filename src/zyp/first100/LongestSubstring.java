package zyp.first100;

import java.util.ArrayList;

/**
 * @author zyp
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        int i=0,j=0;
        int result = 0;
        int[] count = new int[128];
        for(;i<s.length();i++){
            count[s.charAt(i)] ++;
            if(count[s.charAt(i)] == 2){
                while(--count[s.charAt(j++)] != 1);
            }

            result = Math.max(result,i-j+1);
        }
        return  result;

    }

    public static void main(String[] args) {
        String s = "abcbdefg";
        LongestSubstring a = new LongestSubstring();
        System.out.println(a.lengthOfLongestSubstring(s));
    }
}
