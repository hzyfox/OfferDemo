package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class IsNumeric {
    int dotNumberBeforeE = 0;
    boolean hasE = false;

    public boolean isNumeric(char[] str) {
        for (int i = 0; i < str.length; i++) {
            switch (str[i]) {
                case '+':
                    if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                        return false;
                    }
                    break;
                case '-':

                    if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                        return false;
                    }
                    break;
                case '.':
                    if (i == 0) {
                        return false;
                    }

                    if (i + 1 < str.length && (str[i + 1] < '0' || str[i + 1] > '9')) {
                        return false;
                    }
                    if (!hasE) {
                        if (dotNumberBeforeE > 0) {
                            return false;
                        } else {
                            dotNumberBeforeE += 1;
                        }
                    } else {
                        return false;
                    }
                    break;
                case 'E':
                    if (hasE) {
                        return false;
                    } else {
                        if (i + 1 >= str.length) {
                            return false;
                        }
                        hasE = true;
                    }
                    break;
                case 'e':
                    if (hasE) {
                        return false;
                    } else {
                        if (i + 1 >= str.length) {
                            return false;
                        }
                        hasE = true;
                    }
                    break;
                default:
                    if (str[i] < '0' || str[i] > '9') {
                        return false;
                    }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[] test = "-.123".toCharArray();
        System.out.println(new IsNumeric().isNumeric(test));
    }
}
