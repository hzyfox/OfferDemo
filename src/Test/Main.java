package Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Scanner;

/**
 * create with swordoffer
 * USER: husterfox
 */
import java.util.Scanner;

public class Main {
    static  long res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] mn = scanner.nextLine().split(" ");
        int m = Integer.valueOf(mn[0]);
        int n = Integer.valueOf(mn[1]);
        String rep = scanner.nextLine();
        String[] repstrs = rep.split(" ");

        long[] nums = new long[m];
        for (int i = 0; i < m; i++) {
            nums[i] = Integer.valueOf(repstrs[i]);
        }
        for(int i = 0;i < nums.length;i++){
            dfs(nums,n,i+1,nums[i]);
        }
        System.out.println(res);
    }


    public static void dfs(long[] nums,int n,int index,long cur){
        if(cur%n==0){
            res++;
        }
        if(index >= nums.length){
            return;
        }
        dfs(nums,n,index+1,cur+nums[index]);
    }
}

