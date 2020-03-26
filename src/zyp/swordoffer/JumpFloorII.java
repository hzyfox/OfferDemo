package zyp.swordoffer;

/**
 * @author zyp
 */
public class JumpFloorII {
    public int JumpFloorII(int target) {
        if(target == 0) return 1;
        int sum = 0;
        for(int i=1;i<=target;i++){
            sum += JumpFloorII(target-i);
        }
        return  sum;
    }
}
