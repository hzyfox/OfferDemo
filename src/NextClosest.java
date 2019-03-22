/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class NextClosest {
    public static void main(String[] args) {
        System.out.println( new NextClosest().nextClosest(32511));
    }

    public void swap(char[] numChar, int i, int j) {
        char tmp;
        tmp = numChar[i];
        numChar[i] = numChar[j];
        numChar[j] = tmp;
    }

    public int nextClosest(int num) {
        if (num < 10) {
            return num;
        }
        char[] numChar = String.valueOf(num).toCharArray();
        int i = numChar.length - 2;
        for (; i >= 0; i--) {
            if (numChar[i] < numChar[i + 1]) {
                swap(numChar, i, numChar.length - 1);
                break;
            }
        }
        if (i == -1) {
            System.out.println("can't not found !!!");
        } else {
            for (int j = i + 1; j < numChar.length; j++) {
                for (int k = j + 1; k < numChar.length; k++) {
                    if (numChar[k] < numChar[j]) {
                        swap(numChar, k, j);
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : numChar) {
            stringBuilder.append(c);
        }
        return Integer.valueOf(stringBuilder.toString());
    }
}
