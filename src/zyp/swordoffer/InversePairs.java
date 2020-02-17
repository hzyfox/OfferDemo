package zyp.swordoffer;

/**
 * @author zyp
 */
public class InversePairs {
    int count = 0;
    public int InversePairs(int [] array) {
      if(array==null||array.length==0) {
          return 0;
      }
      mergeSort(array,0,array.length-1);
      return count%1000000007;
    }

    public void mergeSort(int[] array,int left,int right){

        if(left >= right){
            return;
        }
        int mid = (left+right)/2;
        mergeSort(array,left,mid);
        mergeSort(array,mid+1,right);
        merge(array,left,mid,right);
    }

    public void merge(int[] array,int left,int mid,int right){
        int i = left;
        int j = mid+1;
        int[] tmp = new int[right-left+1];
        int m = 0;
        while (i<=mid&&j<=right){
            if(array[i]>array[j]){
                tmp[m++] = array[j++];
                count += (mid-i+1);
            }else{
                tmp[m++] = array[i++];
            }
        }

        while (i<=mid){
            tmp[m++] = array[i++];
        }
        while (j<=right){
            tmp[m++] = array[j++];
        }
        m=0;
        for(int a = left;a<=right;a++){
            array[a] = tmp[m++];
        }
    }

    public static void main(String[] args) {
        InversePairs in = new InversePairs();
        int[] arr = {1,2,3,4,5,6,7,0};
        in.InversePairs(arr);
        System.out.println(in.count%1000000007);
    }
}
