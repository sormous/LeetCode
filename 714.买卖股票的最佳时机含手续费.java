/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
/**
 * 因为不能同时参与多笔交易，因此每天交易结束后只能存在一支股票在手中
 * 定义状态：dp[i][0]表示第i天交易完后没有持有股票的最大利润，dp[i][1]表示第i天手中持有股票的最大利润
 * dp[i][0]的状态转移方程，那么前一天可能就没有持有股票dp[i-1][0]，或者前一天持有股票，在第i天卖出dp[i-1][1]+price[i]-fee
 * dp[i][1]的状态转移方程，那么前一天持有股票dp[i-1][1],或者第i天买入股票dp[i-1][0]-price[i]
 * 初始状态，根据定义可以发现第0天的初始状态为：dp[0][0] = 0, dp[0][1] = -price[0]
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            //需要记录前一天未持有的状态，用来更新当天的买入状态
            int temp = dp_i_0;
            //相当于买入股票的价格升高了。
            //在第一个式子里减也是一样的，相当于卖出股票的价格减小了。
            dp_i_0 = Math.max(dp_i_0, dp_i_1+prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp-prices[i]-fee);
        }
        return dp_i_0;
        
        //method 1: dp
        // int[][] dp = new int[prices.length][2];
        // dp[0][0] = 0; 
        // dp[0][1] = -prices[0];
        // for (int i = 1; i < prices.length; i++) {
        //     dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]-fee);
        //     dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        // }
        // //因为最后肯定是卖出股票的最大利润大于持有股票时的利润，所以最大利润为dp[length-1][0]
        // return dp[prices.length-1][0];

        //method 2: greedy
        //我们将手续费放在买入时进行计算
        // int buy = prices[0]+fee;
        // int res = 0;
        // for (int i = 1; i < prices.length; i++) {
        //     //如果当前prices[i]+fee小于buy购买价格，那么我们不如用该价格进行购入
        //     if(prices[i] + fee < buy){
        //         buy = prices[i] + fee;
        //     }
        //     //如果当前prices[i] 大于buy购买价格，那么就可以以当前价格进行卖出
        //     //并且将buy设置当前价格，以防后续股票还有增长的情况，可以继续卖出
        //     else if(prices[i] > buy){
        //         res += prices[i] - buy;
        //         buy = prices[i];
        //     }
        // }
        // return res;

    }
}
// @lc code=end

