package zyp.swordoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyp
 */
public class MovingCount {
    public static void main(String[] args) {
        MovingCount movingCount =  new MovingCount();
        System.out.println(movingCount.computeSum(35,37));
    }
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold<0){
            return 0;
        }
        int[][] flag = new int[rows][cols];
        return movingHelper(threshold,rows,cols,flag,0,0);
    }
    public int movingHelper(int threshold,int rows,int cols,int[][] flag,int rowIndex,int colIndex){
        int count=0;
        int[] node = {rowIndex,colIndex};
        Queue<int[]> queue = new LinkedList<>();
        if(queue.size()==0){
            queue.offer(node);
            flag[rowIndex][colIndex] = 1;
        }
        while (!queue.isEmpty()){
            int[] tmp  = queue.poll();
            count++;
            rowIndex = tmp[0];
            colIndex = tmp[1];
            //右
            if(colIndex+1<cols&&computeSum(rowIndex,colIndex+1)<=threshold&&flag[rowIndex][colIndex+1]==0){
                queue.offer(new int[]{rowIndex,colIndex+1});
                flag[rowIndex][colIndex+1]=1;
            }
            //xia
            if(rowIndex+1<rows&&computeSum(rowIndex+1,colIndex)<=threshold&&flag[rowIndex+1][colIndex]==0){
                queue.offer(new int[]{rowIndex+1,colIndex});
                flag[rowIndex+1][colIndex]=1;
            }
            //左
            if(colIndex-1>=0&&computeSum(rowIndex,colIndex-1)<=threshold&&flag[rowIndex][colIndex-1]==0){
                queue.offer(new int[]{rowIndex,colIndex-1});
                flag[rowIndex][colIndex-1]=1;
            }
            //上
            if(rowIndex-1>=0&&computeSum(rowIndex-1,colIndex)<=threshold&&flag[rowIndex-1][colIndex]==0){
                queue.offer(new int[]{rowIndex-1,colIndex});
                flag[rowIndex-1][colIndex]=1;
            }
        }
        return count;
    }
    public int computeSum(int i,int j){
        int sum = 0;
        while (i/10!=0){
            sum += i%10;
            i = i/10;
        }
        sum+=i;
        while (j/10!=0){
            sum+=j%10;
            j = j/10;
        }
        sum+=j;
        return sum;
    }
}
