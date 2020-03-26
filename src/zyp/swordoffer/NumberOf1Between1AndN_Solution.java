package zyp.swordoffer;

import jdk.nashorn.internal.objects.NativeUint16Array;

/**
 * @author zyp
 */
public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 1;
        int tmpCount = 1;
        for(int i = 2;i<=n;i++){
            int singleCount = 0;
            String str = String.valueOf(i);
            if(str.contains("1")){
                String tmp = str.replaceAll("1","");
                singleCount = str.length()-tmp.length();
            }
            count = singleCount + tmpCount;
            tmpCount = count;
        }
        System.out.println(count);
        return count;
    }

    public int NumberOf1Between1AndN_Solution2(int n){
        int count = 0;
        for(int i =1;i<=n;i=i*10){
            int a = n/i,b = n%i;
            //判断第i（个，十，百....）是否为0
            if(a%10==0){
                count += a/10*i;
            }
            if(a%10==1){
                count += a/10*i+(b+1);
            }
            if(a%10>=2){
                count += (a/10+1)*i;
            }
        }
        System.out.println(count);
        return count;
    }
    public static void main(String[] args) {
        NumberOf1Between1AndN_Solution nu = new NumberOf1Between1AndN_Solution();
        nu.NumberOf1Between1AndN_Solution2(13);
    }
}
