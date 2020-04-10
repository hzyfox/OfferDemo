package zyp.leetcode.first100;

/**
 * @author zyp
 */
public class IsMatch {
    public static void main(String[] args) {
        IsMatch i = new IsMatch();
        i.isMatch("aa","a*");
    }
    public boolean isMatch(String s, String p) {
         if(s==null||p==null){
             return false;
         }
         return isMatchHelper(s,p,0,0);
    }
    public boolean isMatchHelper(String s,String p, int i ,int j){
        if(j==p.length()){
            return s.length()==i;
        }
        if(j<p.length()-1&&p.charAt(j+1)=='*'){
            //匹配
            if(i<s.length()&&(p.charAt(j)==s.charAt(i)||p.charAt(j)=='.')){
                return isMatchHelper(s,p,i,j+2)||isMatchHelper(s,p,i+1,j);
            }else {
                return isMatchHelper(s,p,i,j+2);
            }
        }else {
            //匹配
            if(i<s.length()&&(p.charAt(j)==s.charAt(i)||p.charAt(j)=='.')){
                return  isMatchHelper(s,p,i+1,j+1);
            }else {
                return false;
            }
        }
    }
}
