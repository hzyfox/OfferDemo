package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 拓扑排序
 */
public class TopologicalOrder {
    public static void  topologicalOrder() {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextByte();
        ArrayList<Integer>[] map = new ArrayList[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<Integer>();
        }
        int[] in = new int[n];
        for (int i = 0; i < e; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            map[from].add(to);
            in[to]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int vertex = queue.poll();
            ans.add(vertex);
            for(int v : map[vertex]){
                in[v]--;
                if(in[v] == 0){
                    queue.offer(v);
                }
            }
        }

        if(ans.size() == n){
            System.out.println(ans);
        }else{
            System.out.println("Error, NO Answer!");
        }
    }

    public static void main(String[] args) {
        topologicalOrder();
    }
}
