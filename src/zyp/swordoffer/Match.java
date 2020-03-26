package zyp.swordoffer;

/**
 * @author zyp
 */
public class Match {
    public static void main(String[] args) {
        Match match = new Match();
        char[] str = {'a'};
        char[] pattern = {'.','*'};
        match.match(str,pattern);
    }
    /**
     * 方法一：递归写法
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern)
    {
           if(str==null||pattern==null){
               return false;
           }
           return matchHelper(str,0,pattern,0);
    }

    public boolean matchHelper(char[] str,int i,char[] pattern, int j){
        if(j==pattern.length){
            return str.length==i;
        }
        if(j<pattern.length-1&&pattern[j+1]=='*'){
            //匹配成功
            if(i<str.length&&(str[i]==pattern[j]||pattern[j]=='.')){
                //matchHelper(str,i,pattern,j+2) 虽然当前匹配，也可以跳过两个字符 例如a 与 a*a ，*表示0次
                return matchHelper(str,i,pattern,j+2)||matchHelper(str,i+1,pattern,j);

            }
            //匹配不成功
            else {
                return matchHelper(str,i,pattern,j+2);
            }
        }
            //匹配不成功
            if(i<str.length&&str[i]!=pattern[j]&&pattern[j]!='.'){
                return false;
            }
            return matchHelper(str, i+1,pattern,j+1);
    }

}
