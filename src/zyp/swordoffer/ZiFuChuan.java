package zyp.swordoffer;

/**
 * @author zyp
 */
public class ZiFuChuan {
    public String replaceSpace(StringBuffer str) {
        String x = "%20";
        StringBuilder re = new StringBuilder();
        for(int i = 0;i< str.length();i++){
            char p = str.charAt(i);
            if(p == ' '){
                re.append(x);
            }else{
                re.append(p);
            }
        }
        return re.toString();
    }
}
