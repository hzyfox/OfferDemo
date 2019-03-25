package leetcode;

/**
 * create with jvm.heap.review
 * USER: husterfox
 */
public class SmallRootHeap {
    // 使用array数组的前k个元素构造小根堆，用于求topk
    public static int[] initialSmallRootHeap(int[] array, int k) {
        assert k >= array.length;
        int[] smallRootArray = new int[k];
        System.arraycopy(array, 0, smallRootArray, 0, k);
        for (int i = 1; i < k; i++) {
            int child = i;
            int parent = (child - 1) / 2;
            int temp = smallRootArray[child];
            while (parent >= 0 && child > 0 && smallRootArray[parent] > temp) {
                smallRootArray[child] = smallRootArray[parent];
                child = parent;
                parent = (child - 1) / 2;
            }
            //child是最后一个满足条件的parent,并且他的值已经下推给child
            smallRootArray[child] = temp;
        }
        return smallRootArray;
    }

    //val的值比array[0]的值大，才能调用此函数
    //array 已经能够满足小根堆的条件了
    public static void buildSmallRootHeap(int[] array, int val) {
        array[0] = val;
        for (int i = 0; i < array.length; ) {
            int lchild = 2 * i + 1;
            int rchild = 2 * i + 2;
            int minIndex = i;
            if (lchild < array.length && array[minIndex] > array[lchild]) {
                minIndex = lchild;
            }
            if (rchild < array.length && array[minIndex] > array[rchild]) {
                minIndex = rchild;
            }
            if (minIndex == i) {
                break;
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            i = minIndex;
        }
    }
}
