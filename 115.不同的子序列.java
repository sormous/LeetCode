/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 */
/**
 * s[i] = t[j]时,dp[i][j]由两部分组成：
 *      选择s[i]与t[j]匹配：则考虑t[j+1:]作为s[i+1:]的子序列——》dp[i+1][j+1]
 *      s[i]与t[j]不匹配：则考虑t[j:]作为s[i+1]的子序列——》dp[i+1][j]
 *      dp[i][j] = dp[i+1][j+1] + dp[i+1][j]
 * 若s[i] != t[j]：
 *      则只有不匹配的情况
 *      则dp[i][j] = dp[i+1][j]
 */
// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m < n) return 0;
        //申明一个二维dp数组，表示在s[i:]的子序列中t[j:]出现的次数
        //防止越界，需要额外申请长度+1的空间
        int[][] dp = new int[m+1][n+1];
        //t[n:]表示空字符串，因为空字符串是任意字符串的子串，所以dp[:][n]都为1
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }

        //从后向前遍历
        for (int i = m-1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n-1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if(sChar == tChar){
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                }else{
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        //返回dp[0][0]，即是所需要求的t出现次数
        return dp[0][0];
    }
}
// @lc code=end

