package Test;

import java.util.Scanner;

/**
 * create with Test
 * USER: husterfox
 */
public class Huawei1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ips = scanner.nextLine().split("\\.");
        int[] intIps = new int[ips.length];
        for(int i = 0; i< ips.length; i++){
            intIps[i] = Integer.valueOf(ips[i]);
            ips[i] = Integer.toHexString(intIps[i]).toUpperCase();
        }
        System.out.println(ips[0]+"."+ips[1]+"."+ips[2]+"."+ips[3]);
    }
} 

