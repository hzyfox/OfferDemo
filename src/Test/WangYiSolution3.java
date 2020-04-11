package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zyp
 */
public class WangYiSolution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] table = new String[n][n];
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            table[i] = scanner.nextLine().split(" ");
        }

    }
}
