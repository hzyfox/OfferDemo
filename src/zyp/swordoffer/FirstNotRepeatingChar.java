package zyp.swordoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyp
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if(str==null||str=="") {
            return -1;
        }
        HashMap<Character,Integer> results = new HashMap<>();
        for(int i = 0;i<str.length();i++){
            char x = str.charAt(i);
            if(!results.containsKey(x)){
               results.put(x,1);
            }else {
              int value = results.get(x);
              results.put(x,++value);
            }
        }
        for(int i =0;i<str.length();i++){
            if(results.get(str.charAt(i))==1){
                System.out.println(str.charAt(i));
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar fr = new FirstNotRepeatingChar();
        fr.FirstNotRepeatingChar("google");
    }
}
