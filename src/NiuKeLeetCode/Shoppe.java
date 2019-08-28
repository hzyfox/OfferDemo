package NiuKeLeetCode;

import java.util.Scanner;


public class Shoppe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        StringBuilder expressionStr = new StringBuilder(inputStr);
        System.out.println(getExpressionValue(expressionStr));
    }

    public static int getExpressionValue(StringBuilder exp) {
        int result = getTermValue(exp);
        boolean more = true;
        while (more) {
            if (exp.length() == 0) {
                break;
            }
            char op = exp.charAt(0);
            if (op == '+' || op == '-') {
                exp.delete(0, 1);
                int value = getTermValue(exp);
                if (op == '+') {
                    result += value;
                } else {
                    result -= value;
                }
            } else {
                more = false;
            }
        }
        return result;
    }


    public static int getTermValue(StringBuilder exp) {
        int result = getFactorValue(exp); //求第一个因子的值
        while (true) {
            if (exp.length() == 0) {
                break;
            }
            char op = exp.charAt(0);
            if (op == '*' || op == '/') {
                exp.delete(0, 1);
                int value = getFactorValue(exp);
                if (op == '*') {
                    result *= value;
                } else {
                    result /= value;
                }
            } else {
                break;
            }
        }
        return result;
    }


    public static int getFactorValue(StringBuilder exp) {
        int result = 0;
        char c = exp.charAt(0);
        if (c == '(') {
            exp.delete(0, 1);
            result = getExpressionValue(exp); //进行了递归调用
            exp.delete(0, 1);
        } else {
            while (Character.isDigit(c) && exp.length() > 0) {
                result = 10 * result + c - '0';
                exp.delete(0, 1);
                if (exp.length() == 0) {
                    continue;
                }
                c = exp.charAt(0);
            }
        }
        return result;
    }


}

