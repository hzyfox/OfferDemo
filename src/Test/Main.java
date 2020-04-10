package Test;

import java.util.*;

import java.util.Scanner;

public class Main {
    static  long res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        long n = scanner.nextLong();

        List<Long> nums = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            nums.add(scanner.nextLong());
        }
        for(int i = 0;i < nums.size();i++){
            dfs(nums,n,i+1,nums.get(i));
        }
        System.out.println(res);
    }


    public static void dfs(List<Long> nums,long n,int index,long cur){
        if(cur%n==0){
            res++;
        }
        if(index >= nums.size()){
            return;
        }
        dfs(nums,n,index+1,cur+nums.get(index));
    }
}

