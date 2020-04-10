package zyp.leetcode.first100;

import java.util.LinkedList;

/**
 * @author zyp
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String string = "abbacd";
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring2(string));
    }
    public int lengthOfLongestSubstring2(String s) {
        int i=0,j=0;
        int result = 0;
        int[] count = new int[128];
        for(;i<s.length();i++){
            count[s.charAt(i)] ++;
            if(count[s.charAt(i)] == 2){
                //这个循环条件的判断包含了两种情况 1.abcbc 知道循环到b结束,前面的值都会减一
                //2.abbacd 因为开始bb，导致指针指向第二个b，再判断a时，不会进上面这个==2的if语句，所以保持j是不变的
//                while(--count[s.charAt(j++)] != 1){ }
                while (count[s.charAt(j)]<2){
                    count[s.charAt(j)]--;
                    j++;
                }
                count[s.charAt(j)]--;
                j++;
            }
            result = Math.max(result,i-j+1);
        }
        return  result;
    }


    public int lengthOfLongestSubstring(String s) {
        LinkedList<Character> list = new LinkedList<>();
        int maxLength = 0;
        for(int i =0,j=0;j<s.length();){
            if(list.contains(s.charAt(j))){
                list.remove(0);
                i++;
            }else {
                list.add(s.charAt(j++));
                maxLength = Math.max(maxLength,j-i);
            }
        }
        return maxLength;
    }
}
