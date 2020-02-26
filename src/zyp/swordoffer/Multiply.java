package zyp.swordoffer;

/**
 * @author zyp
 */
public class Multiply {
    public int[] multiply(int[] A) {
        if(A.length==0||A==null){
            return A;
        }
         int[] b = new int[A.length];
         b[0] = 1;
         for(int i=1;i<A.length;i++){
             b[i] = b[i-1]*A[i-1];
         }
         int tmp = 1;
         for(int i = A.length-2;i>=0;i--){
             tmp  = tmp*A[i+1];
             b[i] = b[i]*tmp;
         }
         return b;
    }
}
