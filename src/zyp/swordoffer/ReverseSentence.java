package zyp.swordoffer;

/**
 * @author zyp
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        char[] charArray = str.toCharArray();
        reverse(charArray, 0, charArray.length - 1);

        for (int i = 0; i < charArray.length; i++) {
            while (i < charArray.length && charArray[i] == ' ') {
                i++;
            }
            int j = i;
            while (j < charArray.length && !(charArray[j] == ' ')) {
                j++;
            }
            reverse(charArray, i, j - 1);
            i = j;

        }
        StringBuilder res = new StringBuilder();
        for (char a : charArray) {
            res.append(a);
        }
        System.out.println(res.toString());
        return res.toString();
    }

    public void reverse(char[] array, int left, int right) {
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String str = "I am a student.";
        ReverseSentence rs = new ReverseSentence();
        rs.ReverseSentence(str);
    }

}
