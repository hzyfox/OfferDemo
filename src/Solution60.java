import java.util.LinkedList;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Solution60 {
    public String getPermutation(int n, int k) {
        StringBuilder store = new StringBuilder();
        int[] arrays = new int[n];
        for (int i = 1; i <= n; i++) {
            arrays[i - 1] = i;
        }
        LinkedList<Integer> tempStore = new LinkedList<>();
        permutation(arrays, k, 0, store, tempStore, 0);
        return store.toString();
    }

    public int permutation(int[] arrays, int k, int currK, StringBuilder store, LinkedList<Integer> tempStore, int pos) {
        if (currK == -1) {
            return -1;
        }
        if (pos == arrays.length) {
            currK += 1;
            if (currK == k) {
                for (Integer integer : tempStore) {
                    store.append(integer);
                }
                return -1;
            } else {
                return currK;
            }
        }

        for (int array : arrays) {
            if (!tempStore.contains(array)) {
                if (currK + factorial(arrays.length - pos - 1) < k) {
                    currK += factorial(arrays.length - pos - 1);
                    continue;
                }
                tempStore.add(array);
                permutation(arrays, k, currK, store, tempStore, pos + 1);
            }

        }
        return currK;

    }

    int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = result * i;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution60().getPermutation(4, 9));
    }
}
