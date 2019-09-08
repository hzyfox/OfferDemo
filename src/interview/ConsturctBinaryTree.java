package interview;

/**
 * 求1-n 个数 能构建二叉搜索树的数目
 */
public class ConsturctBinaryTree {
    public int numTrees(int n) {
        int[] cache = new int[n];
        return cal(n, cache);
    }
    public int cal(int n, int[]cache){
        if(n == 0 || n==1){
            return 1;
        }
        if(cache[n-1] != 0){
            return cache[n-1];
        }
        int sum = 0;
        for(int i = 0; i<= n; i++){
            sum += cal(i, cache) * cal(n-i-1, cache);
        }
        cache[n-1] = sum;
        return sum;
    }

    public static void main(String[] args) {
        ConsturctBinaryTree consturctBinaryTree = new ConsturctBinaryTree();
        System.out.println(consturctBinaryTree.numTrees(3));
    }
}
