import java.util.ArrayList;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class CMN {
    public static void printCombination(int m, int n) {
        if (m < n) {
            return;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int[] array = new int[m];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
//        select(array, 0, n, result);
        find(array, 0, n, result);
    }


    public static void select(int[] array, int startIndex, int leftNum, ArrayList<Integer> arrayList) {
        if (leftNum == 1) {
            for (int i = startIndex; i < array.length; i++) {
                int addIndex = arrayList.size();
                arrayList.add(array[i]);
                System.out.println(arrayList.toString());
                arrayList.remove(addIndex);
            }
        } else if (leftNum > 1) {
            for (int i = startIndex; i <= array.length - leftNum; i++) {
                int addIndex = arrayList.size();
                arrayList.add(array[i]);
                select(array, i + 1, leftNum - 1, arrayList);
                arrayList.remove(addIndex);
            }
        } else {
            return;
        }
    }

    public static void find(int[] array, int index, int leftNum, ArrayList<Integer> arrayList) {
        if (array.length - index < leftNum) {
            return;
        }
        if (leftNum == 0) {
            System.out.println(arrayList.toString());
            return;
        } else if (leftNum > 0) {
            int addIndex = arrayList.size();
            arrayList.add(array[index]);
            find(array, index + 1, leftNum - 1, arrayList);
            arrayList.remove(addIndex);
            find(array, index + 1, leftNum, arrayList);
        }
    }

    public static void main(String[] args) {
        printCombination(5, 3);
    }
}
