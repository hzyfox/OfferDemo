package NiuKeLeetCode;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class DeleteK {
    public static String deleteK(String src, int k){
        int newLength = src.length() - k;
        char[] stack = new char[src.length()];
        int top = 0;
        for(int i = 0; i< src.length(); i++){
            while(k > 0 && top > 0 && stack[top-1] > src.charAt(i)){
                top--;
                k--;
            }
            stack[top++] = src.charAt(i);
        }
        int offset = 0;

        while (offset < newLength && stack[offset] == '0') {
            offset++;
        }

        return offset == newLength? "0": new String(stack, offset, newLength - offset);

    }
    public static void main(String[] args) {
        System.out.println(deleteK("1593212",3));

        System.out.println(deleteK("30200",1));

        System.out.println(deleteK("10",2));

        System.out.println(deleteK("541270936",3));
    }
}
