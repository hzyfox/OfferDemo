package zyp.leetcode.first100;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author zyp
 */
public class MinWindow {
    public static void main(String[] args) {
        MinWindow min = new MinWindow();
        String s = "a";
        String t = "a";
        System.out.println(min.minWindow(s,t));
    }

    public String minWindow(String s, String t) {
        Map<Character,Integer> tMap = new HashMap<>();
        for(int i =0 ;i<t.length();i++){
            int count = tMap.getOrDefault(t.charAt(i),0);
            tMap.put(t.charAt(i),count+1);
        }

        int[] res = new int[2];
        int min = -1;
        int left = 0,right = 0;
        int flag = 0;
        Map<Character,Integer> sMap = new HashMap<>();
        while (right<s.length()){
            char c = s.charAt(right);
            int count = sMap.getOrDefault(c,0);
            sMap.put(c,count+1);

            if(tMap.containsKey(c)&&tMap.get(c).intValue()==sMap.get(c).intValue()){
                flag++;
            }

            while (left<=right&&flag == tMap.size()){
                c = s.charAt(left);
                if(right-left<res[1]-res[0]||res[1]==0){
                    res[0] = left;
                    res[1] = right;
                    min = right-left+1;
                    System.out.println(min);
                }

                sMap.put(c,sMap.get(c)-1);
                if(tMap.containsKey(c)&&tMap.get(c).intValue()>sMap.get(c).intValue()){
                    flag--;
                }
                left++;
            }
            right++;
        }
        System.out.println(res[0]);
        System.out.println(res[1]);
        return min==-1?"": s.substring(res[0],res[1]+1);
    }
}
