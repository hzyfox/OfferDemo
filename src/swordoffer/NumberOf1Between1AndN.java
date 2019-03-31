package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        long count = 0;
        long i = 1;
        for (i = 1; i <= n; i *= 10) {
            //i表示当前分析的是哪一个数位
            long a = n / i, b = n % i;
            count = count + (a + 8) / 10 * i + ((a % 10 == 1) ? 1 : 0) * (b + 1);
        }
        return (int) count;
    }
}
