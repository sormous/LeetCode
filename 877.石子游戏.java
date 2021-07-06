/*
 * @lc app=leetcode.cn id=877 lang=java
 *
 * [877] 石子游戏
 */

// @lc code=start
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        //声明一个dp数组，用来记录以i起始j结尾的石子堆，当前玩家与另一个玩家的最大差值
        int[][] dp = new int[n][n];
        //首先当只有一堆石子时，最大差值就为石子数量
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        //倒序遍历
        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                //因为每位玩家可以选择头和尾，那么就存在两种情况
                dp[i][j] = Math.max(piles[i] - dp[i+1][j], piles[j]-dp[i][j-1]);
            }
        }

        return dp[0][n-1] > 0;
    }
}
// @lc code=end

