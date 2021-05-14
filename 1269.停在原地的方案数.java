/*
 * @lc app=leetcode.cn id=1269 lang=java
 *
 * [1269] 停在原地的方案数
 */

// @lc code=start
class Solution {
    public int numWays(int steps, int arrLen) {
        final int mod = 1000000007;
        int farest = Math.min(arrLen-1, steps);

        //申明一个二维dp[i][j]数组，分别记录第i步，位于第j位置的可执行数
        int[][] dp = new int[steps+1][farest+1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= farest; j++) {
                dp[i][j] = dp[i-1][j];
                if(j-1 >= 0){
                    dp[i][j] = (dp[i][j] + dp[i-1][j-1])%mod;
                }
                if(j+1 <= farest){
                    dp[i][j] = (dp[i][j] + dp[i-1][j+1])%mod;
                }
            }
        }
        return dp[steps][0];
    }
}
// @lc code=end

