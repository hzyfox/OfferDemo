package Test;

import java.util.Scanner;

/**
 * create with Test
 * USER: husterfox
 */
public class Huawei3 {
    public static int count = 0;
    public static String a = "A";
    public static String b = "B";
    public static int aWin = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        if(target<=10){
            System.out.println("[]");
            return;
        }
        int curr = 0;
        dfs(curr, a, target);
        System.out.println("["+count+","+aWin+"]");
    }

    public static void dfs(int curr, String person, int target){
        if(curr > target){
            return;
        }
        if(curr==target){
            count++;
            if(person.equals(b)){
                aWin++;
            }
            return;
        }
        if(person.equals(a)){
           dfs(curr+1,b, target);
           dfs(curr+2,b, target);
        }else{
            dfs(curr+1,a,target);
            dfs(curr+2,a,target);
        }
    }
} 

