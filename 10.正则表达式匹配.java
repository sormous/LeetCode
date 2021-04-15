/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        //申明一个dp数组，dp[i][j]用来记录s前i个字符与p的前j个字符能否匹配
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //首先判断p中为*的情况
                if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2];
                    //在p[j]=='*'的情况下，如果s[i]和p[j-1]的能匹配的话
                    if(match(s, p, i, j-1)){
                        //
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }else{
                    if(match(s, p, i, j)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    //参数中的i,j对应的dp数组中的位置，在字符串中位置应该-1
    //该函数判断s,p中i-1.j-1位置上的字符是否能匹配，'.'的情况和相等的情况表示匹配
    private boolean match(String s, String p, int i, int j){
        if(i == 0){
            return false;
        }
        if(p.charAt(j-1) == '.'){
            return true;
        }
        return s.charAt(i-1) == p.charAt(j-1);
    }
}
// @lc code=end

