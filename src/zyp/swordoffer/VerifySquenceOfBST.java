package zyp.swordoffer;

/**
 * @author zyp
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)return false;
       return VerifyBST(sequence,0,sequence.length-1,sequence.length-1);
    }

    public boolean VerifyBST(int[] sequence,int start,int end,int rootIndex){
        if(start>=end){
            return true;
        }
        for(int i =start;i<end;i++){
            int m=end-1;
            for(;m>=start&&sequence[m]>sequence[rootIndex];m--){};
            for(int n=m;n>=start;n--){
                if(sequence[n]>sequence[rootIndex]){
                    return false;
                }
            }
            return VerifyBST(sequence,start,m-1,m)&VerifyBST(sequence,m+1,end-1,end);
        }
        return false;
    }

    public static void main(String[] args) {
        VerifySquenceOfBST verifySquenceOfBST =  new VerifySquenceOfBST();
        int[]a = {5,4,3,2,1};
        System.out.println(verifySquenceOfBST.VerifySquenceOfBST(a));
    }
}
