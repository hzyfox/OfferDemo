package zyp.swordoffer;

/**
 * @author zyp
 */
public class StrToInt {
    public int StrToInt(String str) {
        if(str==null||str.equals("")){
            return 0;
        }
        int sum = 0;
        int symbol = 1;
        if(str.charAt(0)=='-'){
            symbol = -1;
        }
         for(int i=(str.charAt(0)=='-'||str.charAt(0)=='+')?1:0;i<str.length();i++){
            if(!(str.charAt(i)>='0'&&str.charAt(i)<='9')){
                return 0;
            }
            sum = sum*10+(str.charAt(i)-'0');
         }
         sum = sum*symbol;
        if((symbol == 1 && sum<0) || (symbol == -1 && sum > 0)) {
            if(sum==Integer.MIN_VALUE&&symbol==1){
                return 0;
            }
            if(sum!=Integer.MIN_VALUE){
                return 0;
            }
        }
        System.out.println(sum);
         return sum*symbol;
    }

    public static void main(String[] args) {
        StrToInt st = new StrToInt();
        st.StrToInt("2147483648");
    }
}
