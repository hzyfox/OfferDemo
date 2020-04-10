package zyp.leetcode.first100;

/**
 * @author zyp
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int i = 0,j=height.length-1,max = 0;
        while (i<j){
           max = Math.max(max,(j-i)*Math.min(height[i],height[j]));
           if(height[i]<height[j]){
               i++;
           }else {
               j--;
           }
        }
        return max;
    }
}
