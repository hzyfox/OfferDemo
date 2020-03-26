package zyp.swordoffer;

/**
 * @author zyp
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {
          int i=0,j=0;
          for(;i<array.length && j<array.length;){
             while(i<array.length && (array[i]&1) == 1){
                 //i指向偶数
                 i++;
             }
              j=i+1;
              while ( j<array.length && (array[j]&1) == 0){
                  //j指向奇数
                  j++;
              }

             if(j < array.length){
                 int tmp = array[j];
                 for(int j2 = j;j2 > i ;j2--){
                     array[j2] = array[j2-1];
                 }
                 array[i++] = tmp;
             }
          }

          for(int x:array){
              System.out.println(x);
          }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6};
        ReOrderArray re =  new ReOrderArray();
        re.reOrderArray(arr);
    }
}
