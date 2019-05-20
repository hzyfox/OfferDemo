package swordoffer;

import java.util.ArrayList;
import java.util.Scanner;
//        1
//        8
//        2 1 1 2 2
//        2 1 1 1 4
//        2 1 1 2 2
//        2 2 2 1 4
//        0
//        0
//        1 1 1
//        1 1 1
public class TouTiao0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lizi = scanner.nextInt();
        for(int i = 0; i< lizi; i++){
            int tezheng =  scanner.nextInt();
            ArrayList<ArrayList<String>> store = new ArrayList<>();
            for(int j = 0; j< tezheng; j++){
                ArrayList<String> elem = new ArrayList<>();
                int n = scanner.nextInt();
                for(int k = 0; k<n; k++){
                    elem.add(String.valueOf(scanner.nextInt()) + String.valueOf(scanner.nextInt()));
                }
                store.add(elem);
            }
            int max = 0;
            for(int t = 0; t< tezheng; t++){
                ArrayList<String> row = store.get(t);
                if(row.isEmpty()){
                    continue;
                }
                for(int u = 0; u<row.size(); u++){
                    int cnt = 1;
                    for(int v = t+1; v<tezheng; v++){
                        ArrayList<String> nextRow = store.get(v);
                        if(nextRow.contains(row.get(u))){
                            cnt++;
                        }else {
                            max = Math.max(cnt,max);
                            break;
                        }
                    }

                }
            }
            System.out.println(max);

        }
    }
}
