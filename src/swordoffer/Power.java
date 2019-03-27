package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Power {
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == Integer.MIN_VALUE) {
            return 0;
        }
        boolean negative = false;
        if (exponent < 0) {
            negative = true;
            exponent = -exponent;
        }
        double result;
        if ((exponent & 1) == 0) {
            result = Power(base, exponent / 2) * Power(base, exponent / 2) * base;
        } else {
            result = Power(base, exponent / 2) * Power(base, exponent / 2);
        }
        return negative ? 1 / result : result;
    }

    public static void main(String[] args) {

    }

}
