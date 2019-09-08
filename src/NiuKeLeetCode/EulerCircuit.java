package NiuKeLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class EulerCircuit {
    public static void eulerCircuit() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer>[] graph = new ArrayList[26];
        boolean[] visited = new boolean[26];
        Arrays.fill(visited, true);
        int[] in = new int[26];
        int[] out = new int[26];
        for (int i = 0; i < 26; i++) {
            graph[0] = new ArrayList<>();
        }
        while (scanner.hasNext()) {
            String word = scanner.next();
            visited[word.charAt(0) - 'a'] = false;
            visited[word.charAt(word.length()-1)-'a'] = false;
            in[word.charAt(word.length() - 1) - 'a']++;
            out[word.charAt(0) - 'a']++;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 26; i++) {
            if (!visited[i]) {
                stack.push(i);
                break;
            }
        }
        for(int i = 0; i< 26; i++){
            if(in[i] != out[i]){
                System.out.println("false");
                return;
            }
        }
        while (!stack.isEmpty()) {
            int i = stack.pop();
            for(int j = 0; j< graph[i].size(); j++){
                if(!visited[j]){
                    visited[j] = true;
                    stack.push(j);
                }
            }
        }
        for(int i = 0; i< 26; i++){
            if(!visited[i]){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }

    public static void main(String[] args) {
        eulerCircuit();
    }
}
