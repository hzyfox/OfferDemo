package zyp.swordoffer;

import java.util.LinkedList;

/**
 * @author zyp
 */
public class Calculator {
    int tmp = 0;

    //判断优先级i是不是大于j
    public boolean calculatePri(int i, int j) {
        if ((i == '*' || i == '/') && (j == '+' || j == '-')) {
            return true;
        } else {
            return false;
        }
    }
}
