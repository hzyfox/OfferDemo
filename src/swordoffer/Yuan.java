package swordoffer;

import java.util.Scanner;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Yuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String[] r = scanner.nextLine().split(" ");
        int[] rnums = new int[r.length];
        long ans = 0;

        for(int i = 0; i<r.length; i++){
            rnums[i] = Integer.valueOf(r[i]);
        }
        int num = rnums.length;

        for(int i = rnums.length-1; i>0; i--){
            ans += (rnums[i]*rnums[i]-rnums[i-1]*rnums[i-1]);
            i = i-1;
        }
        if(rnums.length%2 == 1){
            ans += rnums[0]*rnums[0];
        }
        System.out.printf("%.5f",ans*Math.PI);
    }
}
