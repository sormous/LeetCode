/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    /**
     *记录【今天之前买入的最小值】
     *计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
     *比较【每天的最大获利】，取最大值即可
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //0表示当前没有持有股票，1表示当前持有股票
        //逐步遍历，进行更新
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            //下一步的没有持有股票状态，要么是保持上一未持有状态，要么上一持有状态在当前卖出
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1+price);
            //下一步持有股票状态，要么保持上一持有状态，要么买入当前股票
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -price);
        }
        return dp_i_0;


        //通过遍历，找出差值最大的情况
        // if(prices.length <= 1){
        //     return 0;
        // }

        // int min=prices[0], max=0;
        // for(int price:prices){
        //     max = Math.max(max, price-min);
        //     min = Math.min(min, price);
        // }

        // return max;

        // int[] temp = new int[prices.length];
        //int result = 0;

        // //利用数组temp记录当前位置之前的最低价格
        // for(int i=0; i<prices.length; i++){
        //     if(i==0) temp[i] = prices[i];
        //     else{
        //         temp[i] = prices[i] < temp[i-1] ? prices[i] : temp[i-1];
        //     }
        // }

        // //再一次遍历，进行比较
        // for(int i=0; i<temp.length; i++){
        //     if(prices[i] - temp[i] > result){
        //         result = prices[i] - temp[i];
        //     }
        // }
        // return result;
    }
}
// @lc code=end

