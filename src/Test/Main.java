package Test;

import java.util.Scanner;

/**
 * @author zyp
 */
public class Main {
   public int sum(int k,int n,int[] nums){
       int[][] sum = new int[k][n];
       for(int j=0;j<n;j++){
           sum[0][j] = nums[j];
       }
       for(int i = 1;i<k;i++){
           for(int j = 0;j<n;j++){
               for(int x = 0;x<=j;x++){
                   sum[i][j] += sum[i-1][k];
               }
           }
       }
       return sum[k-1][n-1];
   }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for(int i = 0;i<n;i++){
            nums[i] = scanner.nextInt();
        }
        Main getArea = new Main();
    }


}
