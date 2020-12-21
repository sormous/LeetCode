/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
/**
 * 创建长度为cost.length的dp数组，记录当前位置i的最小花费
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        //初始化，在0和1位置上，最小花费等于cost[0],cost[1]
        dp[0] = cost[0];
        dp[1] = cost[1];
        //然后从位置2开始遍历，第i个位置的最低花费为前一个位置和前两个位置小的那个，加上cost[i]
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        //最后结果为dp数组最后两个中，小的那一个
        return Math.min(dp[cost.length-2], dp[cost.length-1]);
    }
}
// @lc code=end

