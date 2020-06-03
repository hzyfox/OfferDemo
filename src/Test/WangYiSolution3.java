package Test;

import java.util.*;

/**
 * @author zyp
 */
public class WangYiSolution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] table = new String[n][2];
        for(int i = 0;i<n;i++){
            table[i] = scanner.nextLine().split(" ");
        }

        List<List<String>> tableJoin = new LinkedList<>();
        Set<String> userName = new HashSet<>();
        for(int i = 0;i <n;i++){
            String username = table[i][1];
            String tbname = table[i][0];
            for(int j = 0;j<n;j++){
                if(username.equals(table[j][1]) && !tbname.equals(table[j][0])){
                   userName.add(username);
                   tableJoin.add(Arrays.asList(tbname,table[j][0]));
                }
            }
        }
        String count = String.valueOf(userName.size());
        for(int i = 0;i<tableJoin.size();i++){
            tableJoin.get(i).add(count);
//            if()
        }





    }
}
