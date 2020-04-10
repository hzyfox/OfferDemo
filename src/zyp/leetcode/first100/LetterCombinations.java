package zyp.leetcode.first100;


import java.util.LinkedList;
import java.util.List;

/**
 * @author zyp
 */
public class LetterCombinations {
    public static void main(String[] args) {
        LetterCombinations l = new LetterCombinations();
        l.letterCombinations("23");
    }
    StringBuilder cur = new StringBuilder();
    List<String> res = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        List<char[]> list = new LinkedList<>();
        helper(digits,list);
        combineHelp(list,0);
        return res;
    }
    public List<String> combineHelp(List<char[]> list,int index){
        if(index>=list.size()){
            res.add(cur.toString());
            return res;
        }

        for(int i = 0;i<list.get(index).length;i++){
            cur.append(list.get(index)[i]);
            combineHelp(list,index+1);
            cur.deleteCharAt(cur.length()-1);
        }
        return res;
    }

    public List<char[]> helper(String digits,List<char[]> list){
        for(int i = 0;i<digits.length();i++){
            if(digits.charAt(i)=='2'){
                list.add("abc".toCharArray());
            }else if(digits.charAt(i)=='3'){
                list.add("def".toCharArray());
            }else if(digits.charAt(i)=='4'){
                list.add("ghi".toCharArray());
            }else if(digits.charAt(i)=='5'){
                list.add("jkl".toCharArray());
            }else if(digits.charAt(i)=='6'){
                list.add("mno".toCharArray());
            }else if(digits.charAt(i)=='7'){
                list.add("pqrs".toCharArray());
            }else if(digits.charAt(i)=='8'){
                list.add("tuv".toCharArray());
            }else if(digits.charAt(i)=='9'){
                list.add("wxyz".toCharArray());
            }
        }
        return list;
    }
}
