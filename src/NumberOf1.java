/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        int count =0;
        for(int i =0; i<32; i++){
            if((n & (0x80000000 >>> i)) >>> (31 -i) == 1){
                count++;
            }
        }
        return count;
    }
}
