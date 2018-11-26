/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class TopK {
    //对数组进行划分
    public static int partitionK(int[] data, int start, int end) {
        if (start >= end) {
            return -1;
        } else {
            int temp;
            int i = start;
            int goal = data[end];
            for (int j = start; j < end; j++) {
                if (data[j] >= goal) {
                    temp = data[j];
                    data[j] = data[i];
                    data[i] = temp;
                    i++;
                }
            }
            data[end] = data[i];
            data[i] = goal;
            return i;
        }
    }

    public static void popSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[j - 1]) {
                    swap(data, j, j - 1);
                }
            }
        }
    }

    public static void insertSort(int[] data) {
        int index;
        for (int j = 1; j < data.length; j++) {
            //find which index should insert.
            for (index = 0; index < j; index++) {
                if (data[j] < data[index]) {
                    break;
                }
            }
            int tmp = data[j];
            for (int n = j; n > index; n--) {
                data[n] = data[n - 1];
            }
            data[index] = tmp;
        }
    }

    public static void mergeSort(int data[], int start, int end, int[] newArray) {
        if (start < end) {
            mergeSort(data, start, (start + end) / 2, newArray);
            mergeSort(data, (start + end) / 2 + 1, end, newArray);
            //合并部分有序的数组
            int index = 0;
            int i = start;
            int j = (start + end) / 2 + 1;
            while (i <= (start + end) / 2 && j <= end) {
                if (data[i] < data[j]) {
                    newArray[index++] = data[i];
                    i++;
                } else {
                    newArray[index++] = data[j];
                    j++;
                }
            }
            if (i <= (start + end) / 2) {
                while (i <= (start + end) / 2) {
                    newArray[index++] = data[i];
                    i++;
                }
            } else {
                while (j <= end) {
                    newArray[index++] = data[j];
                    j++;
                }
            }
            //记得要把排好序的数组放回data
            index = 0;
            while (start <= end) {
                data[start++] = newArray[index++];
            }
        }
    }

    public static void swap(int[] data, int left, int right) {
        int temp;
        temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }

    public static void getTopK(int[] data, int start, int end, int k) {
        if (start < end) {
            int index = partitionK(data, start, end);
            if (index == k - 1) {
                return;
            } else {
                if (index > k - 1) {
                    getTopK(data, start, index - 1, k);
                } else {
                    getTopK(data, index + 1, end, k);
                }
            }
        }
    }

    public static void quickSort(int[] data, int start, int end) {
        if (start < end) {
            int index = partitionK(data, start, end);
            quickSort(data, start, index - 1);
            quickSort(data, index + 1, end);
        }
    }


    public static void printIntArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.printf(" %d ", data[i]);
        }
        System.out.println();
    }

    public static int[] createHeap(int[] data, int k) {
        if (data.length < k) {
            return null;
        }
        int[] smallRootHeap = new int[k];
        for (int i = 0; i < k; i++) {
            smallRootHeap[i] = data[i];
        }
        for (int i = 1; i < k; i++) {
            int child = i;
            int parent = (i - 1) / 2;
            int temp = smallRootHeap[child];
            //实现的时候要注意 temp是一直在传递的 parent传递给child
            //最后child = temp 另外要注意 判断条件是parent > temp 而不是大于child；
            //smallRootHeap[parent] > temp 不能放到while循环的if语句里面，否则可能会造成死循环如果smallRootHeap[parent] > temp
            while (parent >= 0 && child != 0 && smallRootHeap[parent] > temp) {
                smallRootHeap[child] = smallRootHeap[parent];
                child = parent;
                parent = (parent - 1) / 2;
            }
            smallRootHeap[child] = temp;
        }
        return smallRootHeap;
    }

    //大根堆
    public static void createHeapNoCopy(int[] data, int end) {
        //只有一个元素的数组就直接跳过了
        //两个元素的数组会变成大根堆
        for (int i = 1; i < end; i++) {
            int child = i;
            int parent = (i - 1) / 2;
            int temp = data[child];
            while (parent >= 0 && child != 0 && data[parent] < temp) {
                data[child] = data[parent];
                child = parent;
                parent = (parent - 1) / 2;
            }
            data[child] = temp;
        }
    }

    public static void heapSort(int[] data) {
        createHeapNoCopy(data, data.length);
        int temp;
        for (int i = data.length - 1; i > 0; i--) {
            temp = data[i];
            data[i] = data[0];
            data[0] = temp;
            createHeapNoCopy(data, i);
        }
    }

    public static void insert(int[] smallRootHeap, int value) {
        smallRootHeap[0] = value;
        int minIndex;
        int temp;
        for (int parent = 0; parent < smallRootHeap.length; ) {
            minIndex = parent;
            int lchild = parent * 2 + 1;
            int rchild = parent * 2 + 2;
            if (lchild < smallRootHeap.length && smallRootHeap[parent] > smallRootHeap[lchild]) {
                minIndex = lchild;
            }
            if (rchild < smallRootHeap.length && smallRootHeap[rchild] < smallRootHeap[minIndex]) {
                minIndex = rchild;
            }
            if (minIndex == parent) {
                break;
            }
            temp = smallRootHeap[parent];
            smallRootHeap[parent] = smallRootHeap[minIndex];
            smallRootHeap[minIndex] = temp;
            parent = minIndex;
        }
    }

    public static void topKByHeap(int[] data, int k) {
        int[] smallRootHeap = createHeap(data, k);
        printIntArray(smallRootHeap);
        for (int i = k; i < data.length; i++) {
            //注意这里要data[i]大于小跟堆的顶部才插入。
            if (data[i] > smallRootHeap[0]) {
                insert(smallRootHeap, data[i]);
            }
        }
        printIntArray(smallRootHeap);
    }


    public static void main(String[] args) {
        int[] data = {2, 0, 3, 1, 5, 65, 32};
        int[] newArray = new int[data.length];
        popSort(data);
        printIntArray(data);

    }

}
