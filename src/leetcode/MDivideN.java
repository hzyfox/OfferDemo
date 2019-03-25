package leetcode;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class MDivideN {
    static int div(int x, int y) {
        if (x == Integer.MIN_VALUE && y == -1 || y == 0) {
            return Integer.MAX_VALUE;
        }
        if (x == 0) {
            return 0;
        }
        boolean negative = (x > 0) ^ (y > 0);
        long x1 = Math.abs((long)x);
        long y1 = Math.abs((long)y);
        int result = 0;
        while (x1 >= y1) {
            long multi = 1;
            while (y1 * multi <= x1 >> 1) {
                multi = multi << 1; //multi下一次就是两倍了，所以需要保证X大于y两倍
            }
            result += multi;
            x1 -= y1 * multi;
        }
        return negative ? -result : result;
    }

    static int div1(int x, int y) {
        if (x == Integer.MIN_VALUE && y == -1 || y == 0) {
            return Integer.MAX_VALUE;
        }
        if (x == 0) {
            return 0;
        }

        String xString = Integer.toString(x);
        String yString = Integer.toString(y);
        if (xString.charAt(0) == '-') {
            xString = xString.substring(1);

        }
        if (yString.charAt(0) == '-') {
            yString = yString.substring(1);
        }
        long newY = Long.valueOf(yString);
        boolean negative = (x > 0) ^ (y > 0);
        StringBuilder resultString = new StringBuilder();
        String tmpString = xString.substring(0, yString.length());
        for (int i = yString.length(); i <= xString.length(); i++) {
            long tmpX = Long.valueOf(tmpString);
            long[] result = monitorDivide(tmpX, newY);
            resultString.append(result[1]);
            tmpString = Long.toString(result[0]);
            if (xString.length() > i) {
                tmpString += xString.charAt(i);
            }
        }
        return negative ? -Integer.valueOf(resultString.toString()) : Integer.valueOf(resultString.toString());
    }

    static long[] monitorDivide(long x, long y) {
        long[] result = new long[2];
        for (int i = 0; i < 10; i++) {
            x -= y;
            if (x < 0) {
                result[0] = x + y;//余数
                result[1] = i;//商
                return result;
            }
        }
        return new long[2];
    }

    static void test() {
        System.out.println(Integer.toString(Integer.MIN_VALUE));
    }


    public static void main(String[] args) {
        System.out.println(div(Integer.MIN_VALUE,1));
    }
}
