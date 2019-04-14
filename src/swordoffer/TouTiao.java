package swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Pos {
    public int rowIndex;
    public int colIndex;

    public Pos(int rowIndex, int colIndex) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }
}

public class TouTiao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        boolean input = true;
        while (input) {
            try {
                String line = scanner.nextLine();
                String[] rowStrs = line.split(" ");
                ArrayList<Integer> list = new ArrayList<>();
                for (String num : rowStrs) {
                    list.add(Integer.valueOf(num));
                }
                map.add(list);
            } catch (Exception e) {
                input = false;
            }
        }
        if (map.isEmpty() || map.get(0).isEmpty()) {
            System.out.println("0");
            return;
        }
        int row = map.size();
        int col = map.get(0).size();
        LinkedList<Pos> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map.get(i).get(j) == 2) {
                    queue.add(new Pos(i, j));
                }
            }
        }
        if (queue.isEmpty()) {
            System.out.println(0);
            return;
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            LinkedList<Pos> queue0 = new LinkedList<>();
            while (!queue.isEmpty()) {
                Pos pos = queue.poll();
                //左
                if (pos.colIndex > 0 && map.get(pos.rowIndex).get(pos.colIndex - 1) == 1) {
                    map.get(pos.rowIndex).set(pos.colIndex - 1, 2);
                    queue0.offer(new Pos(pos.rowIndex, pos.colIndex - 1));
                }
                //右
                if (pos.colIndex < col - 1 && map.get(pos.rowIndex).get(pos.colIndex + 1) == 1) {
                    map.get(pos.rowIndex).set(pos.colIndex + 1, 2);
                    queue0.offer(new Pos(pos.rowIndex, pos.colIndex + 1));
                }

                if (pos.rowIndex > 0 && map.get(pos.rowIndex - 1).get(pos.colIndex) == 1) {
                    map.get(pos.rowIndex - 1).set(pos.colIndex, 2);
                    queue0.offer(new Pos(pos.rowIndex - 1, pos.colIndex));
                }

                if (pos.rowIndex < row - 1 && map.get(pos.rowIndex + 1).get(pos.colIndex) == 1) {
                    map.get(pos.rowIndex + 1).set(pos.colIndex, 2);
                    queue0.offer(new Pos(pos.rowIndex + 1, pos.colIndex));
                }
            }
            queue = queue0;
            if (queue.isEmpty()) {
                break;
            }
            cnt++;

        }
        boolean flag = true;
        for (int i = 0; i < row && flag; i++) {
            for (int j = 0; j < col && flag; j++) {
                if (map.get(i).get(j) == 1) {
                    flag = false;
                }
            }
        }
        if (!flag) {
            System.out.println("-1");
        } else {
            System.out.println(cnt);
        }


    }
}
