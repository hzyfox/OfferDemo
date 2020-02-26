package zyp.swordoffer;

import java.util.*;

/**
 * @author zyp
 */
public class GetLeastNumbers_Solution {
    public static void main(String[] args) {
        GetLeastNumbers_Solution o =new GetLeastNumbers_Solution();
        int[] a = {5,8,9,4,3,7,6};
//        o.selectSort(a);
//        o.bubbleSort(a);
//        o.insertSort(a);
//        o.quickSort(a,0,a.length-1);
//        o.mergeSort(a,0,a.length-1);
//        o.buildMaxheap(a);
//        for(int x:a){
//            System.out.println(x);
//        }
        o.maxHeap(a,3);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        return GetLeastNumbers(input,k);
    }

    /**
     * 利用Arrays.sort进行排序
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers(int [] input, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        if(k>input.length){
            return res;
        }
        Arrays.sort(input);
        for(int i=0;i<k;i++){
            res.add(input[i]);
        }
        return res;
    }
    /**
     * 借助优先队列进行排序
     * @param array
     * @param k
     * @return
     */

    public ArrayList<Integer> maxHeap(int[] array, int k){
        ArrayList<Integer> res = new ArrayList<>();
        if(array==null||k>array.length){
            return res;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o2-o1);
                return o2-o1;
            }
        });

        for(int i=0;i<array.length;i++){
            if(maxHeap.size()==0||maxHeap.size()<k){
                maxHeap.offer(array[i]);
            }else if(maxHeap.peek()>array[i]){
                System.out.println(maxHeap.peek()+"!");
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        for(int x:maxHeap){
            System.out.println(x);
            res.add(x);
        }
        return res;
    }


    /**
     * 使用最大堆排序（升序）
     */
    public void buildMaxheap(int[] array){

        //第一步：将无序堆调整成最大堆
        for(int i=array.length/2-1;i>=0;i--){
            adjustHeap(array,array.length,i);
        }
        //第二步：将堆顶元素与最后面的元素交换，然后将除最后一个元素外的堆继续调整成最大堆
        for(int i = array.length-1;i>=0;i--){
            int tmp = array[i];
            array[i] = array[0];
            array[0] = tmp;
            adjustHeap(array,i,0);
        }
    }
    public void adjustHeap(int[] array,int length,int parent){
        int tmp = array[parent];
        int lchild = parent*2+1;
        while (lchild < length){
            int rchild = lchild+1;
            if(rchild < length && array[lchild] < array[rchild]){
                lchild++;
            }
            if(tmp < array[lchild]){
                array[parent] =  array[lchild];
                parent = lchild;
                lchild = parent*2+1;
            }else {
                break;
            }
        }
        array[parent] = tmp;
    }

    /**
     * 归并排序
     * @param array
     * @param start
     * @param end
     */

    public void mergeSort (int[] array,int start,int end){
        if(array==null || start >= end){
            return ;
        }
        mergeSort(array,start,(start+end)/2);
        mergeSort(array,(start+end)/2+1,end);
        merge(array,start,(start+end)/2,end);
    }

    public void merge(int[] array,int start,int mid,int end){
        int[] result = new int[end-start+1];
        int l = start;
        int r = mid+1;
        int i =0;
        while (l<=mid && r<=end){
            result[i++] = array[l]<=array[r]?array[l++]:array[r++];
        }
        while(l<=mid){
            result[i++] = array[l++];
        }
        while(r<=end){
            result[i++] = array[r++];
        }
        i = 0;
        for(int j = start;j<=end;j++){
            array[j] = result[i++];
        }
    }

    /**
     * 快排
     * @param array
     * @param left
     * @param right
     */

    public void quickSort(int[] array,int left,int right){
        if(array==null||left >= right){
            return;
        }
        int node = array[left];
        int i = left;
        int j= right;
        while(i<j) {
            while (i < j && node < array[j]) {
                j--;
            }
            if (i < j) {
                int tmp = array[j];
                array[j] = array[i];
                array[i++] = tmp;
            }
            while (i < j && node > array[i]) {
                i++;
            }
            if (i < j) {
                int tmp = array[j];
                array[j--] = array[i];
                array[i] = tmp;
            }
        }
        quickSort(array,left,i-1);
        quickSort(array,i+1,right);
    }

    /**
     * 插入排序
     * @param array
     */
    public void insertSort(int[] array){
        for(int i=1;i<array.length;i++){
            for(int j=i;j>=1;j--){
                if(array[j]<array[j-1]){
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序
     * @param array
     */
    public void bubbleSort(int[] array){
        for(int i =0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param array
     */
    public void selectSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int minValueIndex = i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[minValueIndex]){
                    minValueIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minValueIndex];
            array[minValueIndex] = tmp;
        }
    }

}
