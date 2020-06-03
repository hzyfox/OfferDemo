package Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zyp
 */
public class WangYiSollution2 {
    private static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] map = new String[n][n];
        scanner.nextLine();
        boolean[][] flag = new boolean[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(flag[i],false);
        }
        for(int i = 0;i<n;i++){
            map[i] = scanner.nextLine().split("");
        }
        int i = scanner.nextInt();
        int j = scanner.nextInt();

        dfs(map,i,j,n,flag);
        System.out.println(res);

    }

    public static  void dfs (String[][] map,int i,int j,int n,boolean[][] flag){
        if(i<0||i>=n||j<0||j>=n||flag[i][j]){
            return;
        }

        if(map[i][j].equals("#")){
            flag[i][j] = true;
            return;
        }

        if(!map[i][j].equals(".")&&!map[i][j].equals("#")){
            res+= Integer.valueOf(map[i][j]);
            flag[i][j] = true;
        }

        if(!map[i][j].equals("#")){
            flag[i][j] = true;
            //右
            dfs(map,i,j+1,n,flag);
            //下
            dfs(map,i+1,j,n,flag);
            //左
            dfs(map,i,j-1,n,flag);
            //上
            dfs(map,i-1,j,n,flag);
        }





    }
}
