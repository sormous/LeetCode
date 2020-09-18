/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
/**
 * 最小路径和：由于路径只能向下和向右移动
 * 从起始位置到当前位置的最小路径为：当前位置的值+左边或者上边路径和较小的一边
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //初始起始位置的路径值
                if(i == 0 && j == 0){
                    dp[i][j] = grid[0][0];
                }
                //对第一行和第一列的值进行初始
                else if(i == 0 && j > 0){
                    dp[0][j] = grid[0][j] + dp[0][j-1];
                }
                else if(j == 0 && i > 0){
                    dp[i][0] = grid[i][0] + dp[i-1][0];
                }
                else{
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
// @lc code=end

