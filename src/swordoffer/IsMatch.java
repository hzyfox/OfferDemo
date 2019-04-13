package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */

public class IsMatch {
    public boolean match(char[] str, char[] pattern) {
        // corner case
        if (str == null || pattern == null) {
            return false;
        }

        int m = str.length;
        int n = pattern.length;

        // M[i][j] represents if the 1st i characters in s can match the 1st j characters in p
        boolean[][] M = new boolean[m + 1][n + 1];

        // initialization:
        // 1. M[0][0] = true, since empty string matches empty pattern
        M[0][0] = true;

        // 2. M[i][0] = false(which is default value of the boolean array) since empty pattern cannot match non-empty string
        // 3. M[0][j]: what pattern matches empty string ""? It should be #*#*#*#*..., or (#*)* if allow me to represent regex using regex :P,
        // and for this case we need to check manually

        // for M[0][j], as we can see, the length of pattern should be even, the char at the even position should be *,
        // thus for odd length, M[0][j] = false which is default. So we can just skip the odd position, i.e. j starts from 2, the interval of j is also 2.
        // and notice that the length of repeat sub-pattern #* is only 2, we can just make use of M[0][j - 2] rather than scanning j length each time
        // for checking if it matches #*#*#*#*.
        for (int j = 2; j < n + 1; j += 2) {
            if (pattern[j - 1] == '*' && M[0][j - 2]) {
                M[0][j] = true;
            }
        }

        // the induction rule is very similar to edit distance, where we also consider from the end.
        // induction rule:
        // 1. if p.charAt(j) == s.charAt(i), M[i][j] = M[i - 1][j - 1]
        //    ######a(i)
        //    ####a(j)
        // 2. if p.charAt(j) == '.', M[i][j] = M[i - 1][j - 1]
        // 	  #######a(i)
        //    ####.(j)
        // 3. if p.charAt(j) == '*':
        //    1. if p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i), then b* is counted as empty. M[i][j] = M[i][j - 2]
        //       #####a(i)
        //       ####b*(j)
        //    2.if p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i):
        //       ######a(i)
        //       ####.*(j)
        //
        // 	  	 #####a(i)
        //    	 ###a*(j)
        //      2.1 if p.charAt(j - 1) is counted as empty, then M[i][j] = M[i][j - 2]
        //      2.2 if counted as one, then M[i][j] = M[i - 1][j - 2]
        //      2.3 if counted as multiple, then M[i][j] = M[i - 1][j]

        // recap:
        // M[i][j] = M[i - 1][j - 1]
        // M[i][j] = M[i - 1][j - 1]
        // M[i][j] = M[i][j - 2]
        // M[i][j] = M[i][j - 2]
        // M[i][j] = M[i - 1][j - 2]
        // M[i][j] = M[i - 1][j]
        // Observation: from above, we can see to get M[i][j], we need to know previous elements in M, i.e. we need to compute them first.
        // which determines i goes from 1 to m - 1, j goes from 1 to n + 1

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                char curS = str[i - 1];
                char curP = pattern[j - 1];
                if (curP == '.') {
                    M[i][j] = M[i - 1][j - 1];
                } else if (curP == '*') {
                    char preCurP = pattern[j - 2];
                    if (preCurP != '.' && preCurP != curS) {
                        M[i][j] = M[i][j - 2];
                    } else {
                        M[i][j] = (M[i][j - 2] || M[i - 1][j - 2] || M[i - 1][j]);
                    }
                } else if (curS == curP) {
                    M[i][j] = M[i - 1][j - 1];
                }
            }
        }

        return M[m][n];
    }

    public boolean match0(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }


    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);//当pattern后面是* 且 str不匹配， 或者strIndex为空
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}


