/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class NJieCheng {
    public static void main(String[] args) {
        System.out.println(printNJieCheng(25));
        System.out.println(verify(25));
    }
    public static int printNJieCheng(int n) {
        int zeroNumber = 0;
        long newNumber = n;
        Tuple2 tmp;
        for (int i = n - 1; i > 1; i--) {
            newNumber = newNumber * i;
            tmp = zeroNum(newNumber);
            newNumber = tmp._2();
            zeroNumber += tmp._1();
        }
        return zeroNumber;
    }

    public static int verify(int n) {
        int zeroNumber = 0;
        long newNumber = n;
        for (int i = n - 1; i > 1; i--) {
            newNumber *= i;
        }
        return zeroNum(newNumber)._1();
    }

    public static Tuple2 zeroNum(long number) {
        int count = 0;
        while (true) {
            if (number % 10 == 0) {
                count++;
                number = number / 10;
            } else {
                break;
            }
        }
        return new Tuple2(count, number);
    }

    static class Tuple2 {
        int zeroCount;
        long newNumber;

        public Tuple2(int zeroCount, long newNumber) {
            this.zeroCount = zeroCount;
            this.newNumber = newNumber;
        }

        public int _1() {
            return zeroCount;
        }

        public long _2() {
            return newNumber;
        }
    }

}
