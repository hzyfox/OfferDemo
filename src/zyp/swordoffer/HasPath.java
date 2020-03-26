package zyp.swordoffer;

import java.util.ArrayList;

/**
 * @author zyp
 */
public class HasPath {

    public static void main(String[] args) {
        String str = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
        String str1 = "SGGFIECVAASABCEEJIGOEM";
        HasPath hasPath = new HasPath();
        hasPath.hasPath(str.toCharArray(),5,8,str1.toCharArray());
    }
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix.length==0||str.length==0){
            return false;
        }
        int[][] flag = new int[rows][cols];
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(matrix[i*cols+j]==str[0]){
                    if(hasPathHelper(matrix,rows,cols,str,0,flag,i,j)){return true;}
                }
            }
        }
      return false;
    }
    public boolean hasPathHelper(char[] matrix,int rows,int cols,char[] str,
                              int index,int[][] flag,int rowIndex,int colIndex){
        if(index>=str.length){
            return true;
        }
        if(rowIndex>=rows||colIndex>=cols||rowIndex<0||colIndex<0){
            return false;
        }
        if(flag[rowIndex][colIndex]==1){
            return false;
        }
        if(matrix[rowIndex*cols+colIndex]==str[index]){
            flag[rowIndex][colIndex]=1;
            //往右
            if(hasPathHelper(matrix,rows,cols,str,index+1,flag,rowIndex,colIndex+1)){return true;}
            //往下
            if(hasPathHelper(matrix,rows,cols,str,index+1,flag,rowIndex+1,colIndex)){return true;}
            //往左
            if(hasPathHelper(matrix,rows,cols,str,index+1,flag,rowIndex,colIndex-1)){return true;}
            //往上
            if(hasPathHelper(matrix,rows,cols,str,index+1,flag,rowIndex-1,colIndex)){return true;}
            flag[rowIndex][colIndex]=0;
            return false;
        }else {
            return false;
        }
    }
}
