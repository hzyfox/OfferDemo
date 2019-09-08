package NiuKeLeetCode;

public class TwoSortedArrayMedian {
    public static void main(String[] args) {

    }
    public static void TwoSortedArrayMedian(int[] A, int[] B){
        int left0, right0, left1, right1;
        left0 = 0;
        right0 = A.length-1;
        left1 = 0;
        right1 = A.length-1;
        while(left0 <= right0 && left1 <= right1 && (right1-left1)+(right0-left0) >=1){
            if(A[left0] < B[left1]){
                left0++;
            }else{
                left1++;
            }
            if(A[right0] < B[right1]){
                right1--;
            }else{
                right0--;
            }
        }
        if(left0 > right0){
            System.out.println();
        }
    }


}
