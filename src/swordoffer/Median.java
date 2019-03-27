package swordoffer;

import java.util.ArrayList;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Median {
    public ArrayList<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        int i = 0;
        for (; i < list.size(); i++) {
            if (num < list.get(i)) {
                break;
            }
        }
        list.add(i, num);
    }

    public Double GetMedian() {
        if ((list.size() & 1) == 0) {
            return (list.get((list.size()-1) / 2) + list.get(list.size() / 2)) / (double) 2;
        } else {
            return (double) list.get(list.size() / 2);
        }
    }

    public static void main(String[] args) {
        Median median = new Median();
        median.Insert(5);
        System.out.println(median.GetMedian());
        median.Insert(2);
        System.out.println(median.GetMedian());
    }
}
