/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        //申明一个dp数组，dp[i][j]表示p中前j个字符能否匹配s中前i个字符
        boolean[][] dp = new boolean[m+1][n+1];
        //首先两个空字符串匹配肯定为true
        dp[0][0] = true;
        //若s为空字符的话，那么p中开头连续为*的话，也为true
        for (int i = 1; i <= n; i++) {
            if(p.charAt(i-1) == '*'){
                dp[0][i] = true;
            }else{
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
               if(p.charAt(j-1) == '*'){
                   //如果当前位置为*，表示可以匹配0~任意个字符，即使用该*或不使用
                   dp[i][j] = dp[i-1][j] || dp[i][j-1];
               } else{
                   if(match(s, p, i, j)){
                       dp[i][j] = dp[i-1][j-1];
                   }
               }
            }
        }
        return dp[m][n];
    }

    private boolean match(String s, String p, int i, int j){
        if(i==0){
            return false;
        }
        if(p.charAt(j-1) == '?'){
            return true;
        }
        return s.charAt(i-1) == p.charAt(j-1);
    }
}
// @lc code=end

