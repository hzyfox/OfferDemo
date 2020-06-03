package Test;

import java.util.Scanner;

/**
 * create with Test
 * USER: husterfox
 */
public class Huawei3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        if(target<=10){
            System.out.println("[]");
            return;
        }
        int df0 = 1, df1 = 1,df=0;
        for(int i = 2; i<=target;i++){
            df = df0+df1;
            df0 = df1;
            df1 = df;
        }
        System.out.println("["+df+","+(int)(Math.ceil(df/2.0))+"]");
    }
} 

