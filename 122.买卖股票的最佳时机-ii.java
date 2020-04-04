/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    /**
     * 求得所能获取的最大利润，可完成多笔交易。
     * buy, sell分别记录买入和卖出时的价格
     * 遍历数组，若当前买入大于卖出，则使买入价格buy = sell。针对第一个元素较大的情况
     * 后续若遇到当前元素值大于卖出价，则替换当前卖出价，
     * 反之，则以当前买入卖出价，得出当前利润进行记录
     * 然后将buy，sell替换为当前元素值
     * 
     * @param prices
     * @return max
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices.length <= 1) return max;

        int buy = prices[0], sell = prices[1];
        for(int i=1; i<prices.length; i++){
            if(buy>sell){
                buy = sell;
            }
            if(prices[i] >= sell){
                sell = prices[i];
                //在最后一个元素时，不需要跳出，而是进行计算得出最大利润
                if(i!=prices.length-1) continue;
            }
            max += (sell-buy);
            buy = prices[i];
            sell = prices[i];
        }
        return max;
    }
}
// @lc code=end

