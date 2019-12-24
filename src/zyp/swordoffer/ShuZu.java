package zyp.swordoffer;

/**
 * @author zyp
 */
public class ShuZu {
    public boolean Find(int target, int [][] array) {
        if(array[0].length == 0 || target < array[0][0] || target > array[array.length-1][array[0].length-1]) return false;
        for(int i=array.length-1,j=0;i>=0 && j<array[0].length;){
            if(target == array[i][j]) return true;
            else if(target > array[i][j]){
                j++;
            }else if(target < array[i][j]){
                i--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int [][]a = {
//                {1,2,8,9},
//                {2,4,9,12},
//                {4,7,10,13},
//                {6,8,11,15}
//        };
        int [][]a = {{}};
        System.out.println(a[0].length);
        ShuZu shuZu = new ShuZu();
        shuZu.Find(7,a);
    }
}
