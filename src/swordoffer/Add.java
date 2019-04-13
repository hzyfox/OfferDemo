package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class Add {
    public int Add(int num1, int num2) {
        int carry = (num1 & num2) << 1;
        int sum = num1 ^ num2;
        //当carry 和 sum还有位置同时为1，此时表示还没加完，还有进位还需要继续加。
        while ((carry & sum) != 0) {
            int temp = (carry ^ sum);
            carry = (carry & sum) << 1;
            sum = temp;
        }
        return sum;
    }
}
