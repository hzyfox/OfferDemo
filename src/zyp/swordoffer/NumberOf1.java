package zyp.swordoffer;

/**
 * @author zyp
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        int count = 0;
        while( n!=0){
            count ++;
            n = n&(n-1); //把整数最右边的1变成0；
        }
        return count;

    }

    public static void main(String[] args) {
        int n = -1;
        NumberOf1 x = new NumberOf1();
        System.out.println(x.NumberOf1(n));
    }
}
