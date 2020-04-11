package Test;

import java.util.*;

/**
 * create with Test
 * USER: husterfox
 */
public class Wangyi3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        Data[] table = new Data[n];
        Data[] table1 = new Data[n];
        ArrayList<JoinedData> tmpTable = new ArrayList<JoinedData>();

        for (int i = 0; i < n; i++) {
            String[] elem = scanner.nextLine().split(" ");
            table[i] = new Data(elem[0], elem[1]);
            table1[i] = new Data(elem[0], elem[1]);
        }

        //迪卡尔积

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((!table[i].tbaname.equals(table1[j].tbaname))
                        && table[i].username.equals(table1[j].username)) {
                    tmpTable.add(new JoinedData(table[i].tbaname, table[i].username,
                            table1[j].tbaname, table1[j].username));
                }
            }
        }

        TreeMap<String, HashSet<String>> result = new TreeMap<>();

        for (JoinedData data : tmpTable) {
            String key = data.left_tbaname + "@@" + data.right_tbaname;
            if (result.containsKey(key)) {
                result.get(key).add(data.left_user_name);
            } else {
                HashSet<String> set = new HashSet<>();
                set.add(data.left_user_name);
                result.put(key, set);
            }
        }

        Set<String> set = result.keySet();
        for (String key : set) {
            if(result.get(key).size()>2){
                String[] fields = key.split("@@");
                System.out.println(fields[0] + " " + fields[1] + " " + result.get(key).size());
            }
        }
    }

    static class Data {
        String tbaname;
        String username;

        public Data(String tbaname, String username) {
            this.tbaname = tbaname;
            this.username = username;
        }
    }

    static class JoinedData {
        String left_tbaname;
        String left_user_name;
        String right_tbaname;
        String right_username;

        public JoinedData(String left_tbaname, String left_user_name, String right_tbaname, String right_username) {
            this.left_tbaname = left_tbaname;
            this.left_user_name = left_user_name;
            this.right_tbaname = right_tbaname;
            this.right_username = right_username;
        }
    }
}
