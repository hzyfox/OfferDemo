package interview;

import java.util.*;

/**
 * 欧拉回路
 */
public class EulerCircuit {
    public static void eulerCircuit() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer>[] graph = new ArrayList[26];
        boolean[] visted = new boolean[26];
        int[] in = new int[26];
        int[] out = new int[26];
        Arrays.fill(visted, false);
        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
            visted[i] = true;
        }

        String[] words = scanner.nextLine().split(" ");
        int e = 0, s = 0;
        for (String word : words) {
            e = word.charAt(word.length() - 1) - 'a';
            s = word.charAt(0) - 'a';
            graph[s].add(e);
            in[e]++;
            out[s]++;
        }

        for (int i = 0; i < 26; i++) {
            if (in[i] != out[i]) {
                System.out.println("false");
                return;
            }
        }

//        Stack<Integer> stack = new Stack<>();
//        stack.push(s);
//        visted[s] = true;
//        while (!stack.isEmpty()) {
//            ArrayList<Integer> dsts = graph[stack.pop()];
//            for (int elem : dsts) {
//                if (!visted[elem]) {
//                    visted[elem] = true;
//                    stack.push(elem);
//                }
//            }
//        }
        dfs(graph, visted, s);

        for (int i = 0; i < 26; i++) {
            if (!visted[i]) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }

    public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int start) {
        for (int elem : graph[start]) {
            if (!visited[elem]) {
                visited[elem] = true;
                dfs(graph, visited, elem);
            }
        }
    }

    public static void bfs(ArrayList<Integer>[] graph, boolean[] visited, int start) {
        LinkedList<Integer> queue = new LinkedList<>();
    }

    public static void main(String[] args) {
        eulerCircuit();
    }
}
