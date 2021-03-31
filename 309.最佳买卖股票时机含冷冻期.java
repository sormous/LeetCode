/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        //申明一个pre变量，记录dp[i-2][0]，因为含冷冻期，所以只能隔一天进行购买
        int dp_pre_0 = 0;
        for (int i = 0; i < n; i++) {
            //需要记录前一天未持有股票的获利情况，用来更新dp[i-2][0]
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1+prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0-prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
}
// @lc code=end

