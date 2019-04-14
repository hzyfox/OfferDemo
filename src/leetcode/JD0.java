package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * create with leetcode
 * USER: husterfox
 */
public class JD0 {
    static class pos {
        public int start;
        public int end;

        pos(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        String[] subs = new String[n];
        for (int i = 0; i < n; i++) {
            subs[i] = scanner.nextLine();
        }
        ArrayList<pos> scope = new ArrayList<>();
        String t = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            int fromIndex = 0;
            while (t.indexOf(subs[i], fromIndex) != -1) {
                int begin = t.indexOf(subs[i],fromIndex);
                int end = begin + subs[i].length() - 1;
                scope.add(new pos(begin, end));
                fromIndex = end + 1;
            }
        }
        scope.sort(Comparator.comparingInt(o -> o.start));
        int ans = 0;
        int currbegin;
        int currend;
        if (scope.size() == 0) {
            System.out.println(ans);
            return;
        } else {
            currbegin = scope.get(0).start;
            currend = scope.get(0).end;
        }
        for (int i = 1; i < scope.size(); i++) {
            if (scope.get(i).start > currend) {
                ans++;
            } else {
                if (scope.get(i).end < currend) {
                    currbegin = scope.get(i).start;
                    currend = scope.get(i).end;
                }
            }
        }
        System.out.println(ans);


    }
}
