package swordoffer;

/**
 * create with swordoffer
 * USER: husterfox
 */
public class MinWordChange {
    public int minWordChange(String word0, String word1) {
        int[][] dp = new int[word0.length() + 1][word1.length() + 1];
        if (word0.length() == 0) {
            return word1.length();
        }
        if (word1.length() == 0) {
            return word0.length();
        }
        for (int i = 0; i <= word1.length(); i++) {
            //当word0不为空，word1为空.此时word0长度为多少，就应该删除多少次
            dp[0][i] = i;
        }
        for (int i = 0; i <= word0.length(); i++) {
            //当word0为空，word1不为空，此时word1长度为多少，就应该删除多少次
            dp[i][0] = i;
        }

        /**
         *         null h o r s e
         *    null  0   1 2 3 4 5
         *      o   1   1 1 2 3 4
         *      r   2   2 2 1 2 3
         *      s   3   3 3 3 1 2
         */

        for (int i = 1; i <= word0.length(); i++) {
            for (int j = 1; j <= word1.length(); j++) {
                //i,j的下标从1开始，但是单词是从第0个字符开始计数的
                //当word0 i-1个的下标和word1第j-1个字符相等时，
                if (word0.charAt(i - 1) == word1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //如果进行增操作, 则先变到 j-1的长度，再进行一次增操作
                    int insert = dp[i][j - 1];
                    //先进行删除，再变到j长度
                    int delete = dp[i - 1][j];
                    //替换操作 先i-1长度变道j-1，然后替换最后一个
                    int replace = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(Math.min(insert, delete), replace)+1;
                }

            }
        }
        return dp[word0.length()][word1.length()];
    }

    public static void main(String[] args) {
        System.out.println(new MinWordChange().minWordChange("horse","ors"));
    }
}
