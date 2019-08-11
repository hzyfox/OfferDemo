package NiuKeLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class EulerCircuit {
    public static void eulerCircuit() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer>[] graph = new ArrayList[26];
        boolean[] visted = new boolean[26];
        Arrays.fill(visted,false);
        for (int i = 0; i < 26; i++) {
            graph[0] = new ArrayList<>();
        }
    }
}
