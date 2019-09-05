package interview;

import java.util.Scanner;

/**
 * 利用递归计算表达式的值
 */
public class CalExpression {

    public static int expressionValue(StringBuilder exp) {
        boolean more = true;
        int result = termValue(exp);
        while (more) {
            if (exp.length() == 0) {
                break;
            }
            if (exp.charAt(0) == '+') {
                exp.delete(0, 1);
                result += termValue(exp);
            } else if (exp.charAt(0) == '-') {
                exp.delete(0, 1);
                result -= termValue(exp);
            } else {
                more = false;
            }
        }
        return result;
    }


    public static int termValue(StringBuilder exp) {
        int result = factorValue(exp);
        while (true) {
            if (exp.charAt(0) == '*') {
                exp.delete(0, 1);
                result *= factorValue(exp);
            } else if (exp.charAt(0) == '/') {
                exp.delete(0, 1);
                result /= factorValue(exp);
            } else {
                break;
            }
        }
        return result;
    }

    public static int factorValue(StringBuilder exp) {
        int result = 0;
        if (exp.charAt(0) == '(') {
            exp.delete(0, 1);
            result = expressionValue(exp);
            exp.delete(0, 1);
        } else {
            while (exp.length() > 0 && Character.isDigit(exp.charAt(0))) {
                result = result * 10 + Character.getNumericValue(exp.charAt(0));
                exp.delete(0, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.nextLine();
        StringBuilder builder = new StringBuilder(exp);
        System.out.println(expressionValue(builder));

    }
}

