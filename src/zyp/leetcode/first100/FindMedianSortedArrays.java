package zyp.leetcode.first100;

/**
 * @author zyp
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        FindMedianSortedArrays f = new FindMedianSortedArrays();
        int[] a = {1,3};
        int[] b = {2};
        f.findMedianSortedArrays(a,b);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m>n){
            return findMedianSortedArrays(nums2,nums1);
        }
        int imin = 0,imax = m;
        int half = (m+n+1)/2;
        while (imin<=imax){
            int i = (imin+imax)/2;
            int j = half-i;
            if(i>imin&&nums1[i-1]>nums2[j]){
                imax = i-1;
            } else if(i<imax&&nums2[j-1]>nums1[i]){
                imin = i+1;
            }else{
                int minRight = 0;
                int maxLeft = 0;

                if(i==0){
                    maxLeft = nums2[j-1];
                } else if(j==0){
                    maxLeft = nums1[i-1];
                }else {
                    maxLeft = Math.max(nums1[i-1],nums2[j-1]);
                }
                if((m+n)%2!=0) {
                    return maxLeft*1.0;
                }

                if(i==m){
                    minRight = nums2[j];
                }else if(j==n){
                    minRight = nums1[i];
                }else {
                    minRight = Math.min(nums1[i],nums2[j]);
                }
                return (maxLeft+minRight)/2.0;

            }
        }
        return 0.0;
    }
}
