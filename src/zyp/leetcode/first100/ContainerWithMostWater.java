package zyp.leetcode.first100;

/**
 * @author zyp
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
         int i = 0,j=height.length-1;
         int maxArea = (j-i) * Math.min(height[i],height[j]);
         while(i<=j){
             if(height[i] < height[j]) i++;
             else j--;
             maxArea = maxArea>(j-i) * Math.min(height[i],height[j])? maxArea:(j-i) * Math.min(height[i],height[j]);
         }
         return maxArea;
    }
}
