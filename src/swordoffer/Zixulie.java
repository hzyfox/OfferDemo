package swordoffer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Zixulie {
    public static  int ans;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        String[] arrays = scanner.nextLine().split(" ");
        int[] nums = new int[arrays.length];
        for(int i =0; i< nums.length; i++){
            nums[i] = Integer.valueOf(arrays[i]);
        }
        for(int i = 1; i<=arrays.length; i++){
            dfs(nums, new ArrayList<>(), 0, i);
        }
        System.out.println(ans);

    }
    public static void dfs(int[] nums, ArrayList<Integer> container, int start, int limit){
        if(container.size() == limit){
            if(ans <= 998244352) {
                ans++;
            } else{
                ans = 0;
            }
            return;
        }
        for(int i = start; i< nums.length; i++){
            int index = container.size()+1;
            if(nums[i] % index == 0){
                int size = container.size();
                container.add(nums[i]);
                dfs(nums, container, start+1, limit);
                container.remove(size);
            }else{
                continue;
            }
        }
    }
}
