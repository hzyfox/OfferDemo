package NiuKeLeetCode;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class SmallHeap {
    public int[] initSmallHeap(int[] heap, int k) {
        int[] ans = new int[k];
        System.arraycopy(ans, 0, ans, 0, k);
        for (int i = 1; i < ans.length; i++) {
            int child = i;
            int parent = (child - 1) / 2;
            int tmp = ans[child];
            while (parent >= 0 && child > 0 && ans[parent] > tmp) {
                ans[child] = ans[parent];
                child = parent;
                parent = (child - 1) / 2;
            }
            ans[child] = tmp;
        }
        return ans;
    }
    public void maintainHeap(int[] heap, int val){
        if(val > heap[0]){
            heap[0] = val;
        }
        for(int i = 0; true;){
            int minIndex = i;
            int lchild = i*2 +1;
            int rchild = i*2 +1;
            if(lchild < heap.length && heap[minIndex] > heap[lchild]){
                minIndex = lchild;
            }
            if(lchild < heap.length && heap[minIndex] > heap[rchild]){
                minIndex = rchild;
            }
            if(minIndex == i){
                break;
            }else{
                int tmp = heap[minIndex];
                heap[minIndex] = heap[i];
                heap[i] = tmp;
                i = minIndex;
            }

        }
    }
}
