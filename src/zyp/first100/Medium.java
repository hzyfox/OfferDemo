package zyp.first100;

/**
 * @author zyp
 */
public class Medium {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] temp=null;
        if(nums1.length > nums2.length){
         temp = nums2;
         nums2 = nums1;
         nums1 = temp;
        }
        int m = nums1.length, n= nums2.length;
        int imin = 0,imax = m;
        int half = (m+n+1)/2;
        while(imin <= imax){
            int i = (imin+imax)/2,j = half-i;
            if(i>imin && nums1[i-1]>nums2[j]){
                 imax = imax-1;
             }else if(i<imax && nums2[j-1]>nums1[i]){
                 imin = imin+1;
             }else{
                int maxleft = 0;
                if(i == 0) maxleft = nums2[j-1];
                else if(j == 0 ) maxleft = nums1[i-1];
                else maxleft = Math.max(nums1[i-1],nums2[j-1]);
                if((m+n)%2 == 1) return  maxleft;

                int minright = 0;
                if(i==m) minright = nums1[j];
                else if(j == n) minright = nums2[i];
                else  minright = Math.min(nums1[i],nums2[j]);
                return  (maxleft+minright)/2.0;
            }
        }
        return  0.0;
    }
    }
