/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //申明一个三维dp数组，表示在第i天进行k次股票交易，当前持有或不持有状态下的获利状态
        // int[][][] dp = new int[n][3][2];
        // dp[0][2][1] = -prices[0];
        // dp[0][2][0] = 0;
        // dp[0][1][1] = -prices[0];
        // dp[0][1][0] = 0;
        
        //进行空间优化
        //dp_i10表示第i天进行一次交易，不持有股票状态,dp_i20则表示第i天进行两次股票交易，不持有股票状态
        int dp_i10 = 0, dp_i20 = 0;
        //dp_i11表示第i天进行一次交易，持有股票状态，dp_i21表示第i天进行两次股票交易，持有股票状态
        int dp_i11 = Integer.MIN_VALUE, dp_i21 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i20 = Math.max(dp_i20, dp_i21+prices[i]);
            dp_i21 = Math.max(dp_i21, dp_i10-prices[i]);
            dp_i10 = Math.max(dp_i10, dp_i11+prices[i]);
            dp_i11 = Math.max(dp_i11, -prices[i]);
            // for (int k = 2; k >= 1; k--) {
            //     dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1]+prices[i]);
            //     dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i]);
            // }
        }
        return dp_i20;
    }
}
// @lc code=end

