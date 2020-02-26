package zyp.swordoffer;

/**
 * @author zyp
 */
public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
          boolean[] arr = new boolean[numbers.length];
          for(int i = 0;i<numbers.length;i++){
              if(arr[numbers[i]]==true){
                  duplication[0] = numbers[i];
                  return true;
              }
              arr[numbers[i]] = true;
          }
          return false;
    }
}
