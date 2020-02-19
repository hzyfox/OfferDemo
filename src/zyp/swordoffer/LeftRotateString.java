package zyp.swordoffer;

/**
 * @author zyp
 */
public class LeftRotateString {

    /**
     * 考点：字符串翻转
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString2(String str,int n){
        if(n>str.length()){
            return "";
        }
        char[] arr =  str.toCharArray();
        reverse(arr,0,arr.length-1);

        reverse(arr,0,arr.length-n-1);
        reverse(arr,arr.length-n,arr.length-1);
        StringBuilder res = new StringBuilder();
        for(char a:arr){
            res.append(a);
        }
        System.out.println(res.toString());
        return res.toString();
    }

    public void reverse(char[] arr,int start,int end){
        while(start<end){
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    public String LeftRotateString(String str,int n) {
        if(n>str.length()){
            return "";
        }
        StringBuilder x = new StringBuilder();
        x.append(str.substring(n,str.length()));
        for(int i=0;i<n;i++){
            x.append(str.charAt(i));
        }
        System.out.println(x.toString());
        return x.toString();
    }

    public static void main(String[] args) {
        LeftRotateString lr = new LeftRotateString();
        lr.LeftRotateString2("abcdeftg",3);
    }
}
