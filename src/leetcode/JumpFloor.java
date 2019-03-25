package leetcode;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class JumpFloor {
    public int jumpFloor(int target) {
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return jumpFloor(target -2) + jumpFloor(target -1);
    }
}
