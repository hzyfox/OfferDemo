/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Int2Roman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        StringBuilder string = new StringBuilder();
        while (num != 0) {
            num = getString(num, string);
        }
        return string.toString();
    }

    public static int getString(int number, StringBuilder stringBuilder) {
        if (number >= 1000) {
            while (number >= 1000) {
                stringBuilder.append("M");
                number -= 1000;
            }
            return number;
        }
        if (number >= 900) {
            stringBuilder.append("CM");
            return number - 900;
        }
        if (number >= 500) {
            stringBuilder.append("D");
            return number - 500;
        }
        if (number >= 400) {
            stringBuilder.append("CD");
            return number - 400;
        }
        if (number >= 100) {
            while (number >= 100) {
                stringBuilder.append("C");
                number -= 100;
            }
            return number;
        }
        if (number >= 90) {
            stringBuilder.append("XC");
            return number - 90;
        }
        if (number >= 50) {
            stringBuilder.append("L");
            return number - 50;
        }
        if (number >= 40) {
            stringBuilder.append("XL");
            return number - 40;
        }
        if (number >= 10) {
            while (number >= 10) {
                stringBuilder.append("X");
                number -= 10;
            }
            return number;
        }
        if (number >= 9) {
            stringBuilder.append("IX");
            return number -= 9;
        }
        if (number >= 5) {
            stringBuilder.append("V");
            return number - 5;
        }
        if (number >= 4) {
            stringBuilder.append("IV");
            return number - 4;
        }
        if (number >= 1) {
            while (number >= 1) {
                stringBuilder.append("I");
                number -= 1;
            }
            return number;
        }
        return 0;
    }
}
