import java.util.ArrayList;

/**
 * create with jvm.heap
 * USER: husterfox
 */
public class AMN_copy {
    public static void main(String[] args) {
        int m = 5;
        int n = 3;
        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = i;
        }
//        ArrayList<Integer> result = new ArrayList<>();
//        find(array, n, result);
        int[] array0 = {1, 1, 2, 3, 4};
        ArrayList<Tuple2> newResult = new ArrayList<>();
        findAllowRepeated(array0, 3, newResult);
    }

    public static void findAllowRepeated(int[] array, int leftNum, ArrayList<Tuple2> result) {
        if (leftNum == 0) {
            System.out.println(result.toString());
        }
        for (int i = 0; i < array.length; i++) {
            Tuple2 tmpValue = new Tuple2(array[i], i);
            if (!result.contains(new Tuple2(array[i], i))) {
                int index = result.size();
                result.add(tmpValue);
                findAllowRepeated(array, leftNum - 1, result);
                result.remove(index);
            }
        }
    }

    public static void find(int[] array, int leftNum, ArrayList<Integer> result) {
        if (leftNum == 0) {
            System.out.println(result.toString());
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (!result.contains(i)) {
                int index = result.size();
                result.add(i);
                find(array, leftNum - 1, result);
                result.remove(index);
            }
        }
    }

    static class Tuple2 {
        public int value;
        public int pos;

        public Tuple2(int value, int pos) {
            this.value = value;
            this.pos = pos;
        }

        @Override
        public String toString() {
            return String.format("%d", value);
        }

        @Override
        public boolean equals(Object obj) {
            return value == ((Tuple2) obj).value && pos == ((Tuple2) obj).pos;
        }

        @Override
        public int hashCode() {
            return value + pos;
        }
    }
}
