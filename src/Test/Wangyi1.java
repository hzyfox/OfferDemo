package Test;

import java.util.*;

/**
 * create with Test
 * USER: husterfox
 */
public class Wangyi1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        TreeMap<Integer, ArrayList<Integer>> new2old = new TreeMap<>();
        HashMap<Integer, ArrayList<Integer>> old2new = new HashMap<>();

        for (int i = 0; i < 2 * n; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            int user = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                tmp.add(scanner.nextInt());
            }
            if (i < n) {
                new2old.put(user, tmp);
            } else {
                old2new.put(user, tmp);
            }
        }
        //已经被选的新用户
        TreeMap<Integer, Integer> new2oldAns = new TreeMap<>();
        //已经被选的老用户
        HashMap<Integer, Integer> olds2newAns = new HashMap<>();

        Stack<Integer> allNewUser = new Stack<>();
        allNewUser.addAll(new2old.keySet());

        while (allNewUser.size() != 0) {
            int newuser = allNewUser.pop();
            ArrayList<Integer> oldCandidates = new2old.get(newuser);
            for (int oldCandidate : oldCandidates) {
                if (!olds2newAns.containsKey(oldCandidate)) {
                    new2oldAns.put(newuser, oldCandidate);
                    olds2newAns.put(oldCandidate, newuser);
                    break;
                } else {
                    int matchedNewUser = olds2newAns.get(oldCandidate);
                    ArrayList<Integer> newCandidates = old2new.get(oldCandidate);
                    int matchedIndex = newCandidates.indexOf(matchedNewUser);
                    int index = newCandidates.indexOf(newuser);
                    //如果matchedIndex < index 说明当前新用户比不过原来匹配上的，需要选下一个老用户
                    //老用户匹配当前新用户
                    if (matchedIndex > index) {
                        new2oldAns.remove(matchedNewUser);
                        new2oldAns.put(newuser, oldCandidate);
                        olds2newAns.remove(oldCandidate);
                        olds2newAns.put(oldCandidate, newuser);
                        allNewUser.push(matchedNewUser);
                        break;
                    }
                }
            }
        }

        Set<Integer> keySet = new2oldAns.keySet();
        for (int key : keySet) {
            System.out.println(key + " " + new2oldAns.get(key));
        }

    }

}
