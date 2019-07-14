package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class InversePairs {
    int cnt = 0;
    public int InversePairs(int [] array) {
        cnt = 0;
        if(array == null || array.length < 2){
            return 0;
        }
        cal(array, 0, array.length-1);
        return cnt % 1000000007;
    }

    public void cal(int[] array, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start + end) / 2;
        cal(array, start, mid);
        cal(array, mid+1, end);
        int[] copy = new int[end - start + 1];
        int ia = start;
        int ib = mid+1;
        int k = 0;
        while(ia <= mid && ib <=end){
            if(array[ia] <= array[ib]){
                copy[k++] = array[ia];
                ia++;
            }else{
                copy[k++] = array[ib];
                cnt = (cnt + mid - ia +1) % 1000000007;
                ib++;
            }
        }
        while(ia <= mid){
            copy[k++] = array[ia++];
        }
        while(ib <= end){
            copy[k++] = array[ib++];
        }
        for(int i = 0; i< copy.length; i++){
            array[start+i] = copy[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(new InversePairs().InversePairs(array));
    }
}
