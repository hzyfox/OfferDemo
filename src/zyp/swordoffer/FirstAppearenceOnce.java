package zyp.swordoffer;

import java.util.stream.Stream;

/**
 * @author zyp
 */
public class FirstAppearenceOnce {
    public static void main(String[] args) {
        FirstAppearenceOnce f=  new FirstAppearenceOnce();
        String string = "goog";
        for(int i=0;i<string.length();i++){
            f.Insert(string.charAt(i));
        }
        f.FirstAppearingOnce();
    }
    //Insert one char from stringstream
    int[] arr = new int[256];
    int index = 1;
    public void Insert(char ch)
    {
         if(arr[ch]==0){
             arr[ch]=index;
         }else{
             arr[ch]=-1;
         }
         index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int index = Integer.MAX_VALUE;
        char x = '\0';
        for(int i =0;i<arr.length;i++){
            if(arr[i]>=1){
                index = index<arr[i]?index:arr[i];
                x = index<arr[i]?x:(char)i;
            }
        }
        if(index!=Integer.MAX_VALUE){
            System.out.println(x);
            return x;
        }
        return '#';
    }
}
