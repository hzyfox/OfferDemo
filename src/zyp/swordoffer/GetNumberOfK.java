package zyp.swordoffer;

/**
 * @author zyp
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        if(array==null){
            return 0;
        }
       int count = binarySearch(array,0,array.length-1,k,0);
        System.out.println(count);
       return count;
    }

    public int binarySearch(int[] array,int left,int right,int k,int count){
        if(left == right){
            if(array[left]==k){
                count++;
            }
            return count;
        }
        int mid = (left+right)/2;
        if(array[mid]>k){
            return binarySearch(array,left,mid,k,count);
        }else if(array[mid] < k){
            return binarySearch(array,mid+1,right,k,count);
        }else {
            return binarySearch(array,left,mid,k,count)+binarySearch(array,mid+1,right,k,count);
        }
    }


    /**
     * 第二种做法，利用二分查找，找到第一次出现k的下标和最后一次出现k的下标，另外用循环做
     * @param array(第三个参数没有用，为了重载不抱错设置的)
     */

    public int GetNumberOfK(int[] array,int k,int no){
        if(array==null||array.length==0){
            return 0;
        }
        return (getLast(array,k)-getFirst(array,k)+1);
    }

    public int getFirst(int[] array,int k){
        int mid = (array.length-1)/2;
        int start = 0;
        int end = array.length-1;
        while (start<=end){
            if(array[mid]<k){
                start = mid+1;
            }else{
                end = mid-1;
            }
            mid = (start+end)/2;
        }
        return start;
    }

    public int getLast(int[] array,int k){
        int mid = (array.length-1)/2;
        int start = 0;
        int end = array.length-1;
        while ((start<=end)){
            if(array[mid]>k){
                end = mid-1;
            }else{
                start = mid+1;
            }
            mid = (start+end)/2;
        }
        return end;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,4,5};
        GetNumberOfK getNumberOfK = new GetNumberOfK();
        System.out.println(getNumberOfK.GetNumberOfK(arr,3,0));
    }
}
