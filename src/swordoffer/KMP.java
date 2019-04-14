package swordoffer;

public class KMP {
    public int[] f(String p){
        int[] ans = new int[p.length()];
        ans[0] = -1;
        for(int i = 1; i<p.length(); i++){
            //P[0...f[i]] = P[end-f[i],end]
            //如果P[end+1] = P[f(i)+1] 则 f(i+1) = f(i)+1;
            for(int j = ans[i-1]; ;j = ans[j]){
                if(p.charAt(j+1) == p.charAt(i)){
                    ans[i] = j+1;
                    break;
                }else{
                    if(j == -1){
                        ans[i] = -1;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public int kmp(String s, String p){
        int[] f = f(p);
        int i, j;
        for(i =0, j=0; i<s.length()&& j<p.length();){
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else{
                if(j == 0){
                    i++;
                }else{
                    j =f[j-1]+1;
                }
            }
        }
        return j == p.length() ? i-p.length(): -1;
    }

    public static void main(String[] args) {
        System.out.println(new KMP().kmp("aabbc","ab"));
    }

}

