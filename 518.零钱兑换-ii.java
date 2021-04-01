/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;

        //外层遍历coin，才是构成组合数的关键，如果内层遍历，那么则构成排列数
        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
// @lc code=end

