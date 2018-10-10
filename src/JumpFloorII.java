/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class JumpFloorII {
    public int jumpFloorII(int target) {
        int result = 0;
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        for(int i = target-1; i>=1; i--){
            result += jumpFloorII(i);
        }
        result += 1;
        return result;
        //f(n)=f(n-1)+f(n-2)+...+f(1)+f(0)
        //f(n-1)=f(n-2)+f(n-3)+...+f(1)+f(0)
        //因此f(n) = f(n-1) + f(n-1)
    }
}
