package zyp.swordoffer;

/**
 * @author zyp
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int tmp = array[0];
        for(int i=1;i<array.length;i++){
            tmp ^= array[i];
        }
        int index = findFirst1(tmp);
        for(int i=0;i<array.length;i++){
            if(isBit(array[i],index)==1){
                num1[0] ^=array[i];
            }else{
                num2[0] ^=array[i];
            }
        }

    }
    public int findFirst1(int x){
        int index = 0;
        while ((x&1)==0){
            x >>= 1;
            index++;
        }
        return index;
    }

    public int isBit(int x,int index){
        x>>=index;
        return (x&1);
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,3};
        FindNumsAppearOnce fa = new FindNumsAppearOnce();
        int[] num1 = new int[1];
        int[] num2 = new int[2];
        fa.FindNumsAppearOnce(arr,num1,num2);
        System.out.println(num1[0]);
    }
}
