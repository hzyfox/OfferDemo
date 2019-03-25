package leetcode;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution50 {
    public double myPow(double x, int n) {
        if (x == 1.0) {
            return 1d;
        }
        if (x == -1.0) {
            if ((n & 1) == 1) {
                return -1d;
            } else {
                return 1d;
            }
        }
        if (n == Integer.MIN_VALUE) {
            return 0d;
        }
        boolean negative = false;
        if (n < 0) {
            n = -n;
            negative = true;
        }
        double temp = power(x, n);
        return negative ? 1 / temp : temp;
    }

    public double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if ((n & 1) == 1) {
            double temp = power(x, n / 2);
            return temp * temp * x;
        } else {
            double temp = power(x, n / 2);
            return temp * temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution50().myPow(2.00000, -2));
    }
}
