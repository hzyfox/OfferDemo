package zyp.leetcode.first100;

/**
 * @author zyp
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        l.longestPalindrome("babac");
    }
    public String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }
        int[] res = new int[2];
        boolean[][] dp = new boolean[s.length()][s.length()];
        int i = 0,j=0;
       for(;j<s.length();j++){
           for(i=0;i<j;i++){
               if(j-i<3&&s.charAt(i)==s.charAt(j)){
                   dp[i][j] = true;
               }else{
                   dp[i][j] = s.charAt(i)==s.charAt(j)&&dp[i+1][j-1];
               }
               if(dp[i][j]==true&&(res[1]-res[0]+1)<(j-i+1)){
                   res[0] = i;
                   res[1] = j;
               }
           }
       }
       return s.substring(res[0],res[1]+1);
    }


    /**
     * 方法二：中心扩散法
     */
   public String longestPalindrome2(String s){
       if(s.length()<2){
           return s;
       }
       int[] res = new int[2];
       for(int i = 0;i<s.length();i++){
           //这里不用一个一个的循环，只需要找到不同的最中心串的起始位置即可；
           i = findLongst(s,i,res);
       }
       return s.substring(res[0],res[1]+1);
   }

   public  int findLongst(String s,int start,int[] res){
       int end = start+1;
       //找到最中心用来扩展的字符串
       while (end<s.length()&&s.charAt(start)==s.charAt(end)){
           end++;
       }
       end--;
       //end指向中心字符串的右边截至位
       int ans = end+1;
       while (start>0&&end<s.length()-1&&s.charAt(start-1)==s.charAt(end+1)){
           start--;
           end++;
       }
       if(end-start>res[1]-res[0]){
           res[0] = start;
           res[1] = end;
       }
       return ans;
   }



}
