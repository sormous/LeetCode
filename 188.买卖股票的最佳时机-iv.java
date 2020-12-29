import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
/**
 * 与其余的股票问题类似，我们使用一系列变量存储「买入」的状态，
 * 再用一系列变量存储「卖出」的状态，通过动态规划的方法即可解决本题。
 * 我们用buy[i][j] 表示对于数组prices[0..i] 中的价格而言，
 * 进行恰好 j 笔交易，并且当前手上持有一支股票，这种情况下的最大利润；
 * 用 sell[i][j] 表示恰好进行 j 笔交易，并且当前手上不持有股票，这种情况下的最大利润。
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int n = prices.length;
        k = Math.min(k, n/2);
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];

        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <= k; i++) {
            buy[i] = sell[i] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i < n; i++) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j-1]+prices[i]);
            }
        }
        return Arrays.stream(sell).max().getAsInt();
    }
}
// @lc code=end

