/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
/**
 * 与前一题相似，该题需要额外判断是否路径上有障碍
 * 若当前位置有障碍，则将该位置的路径条数设为0
 * 在第一排和第一列的情况下，若某个位置有障碍，之后的所有位置均不可达
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        int i;
        //先初始化第一列和第一排的路径条数情况
        for (i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1){
                break;
            }else{
                dp[i][0] = 1;
            }
        }
        while(i<m){
            dp[i++][0] = 0;
        }
        for(i = 0; i<n; i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }else{
                dp[0][i] = 1;
            }
        }
        while(i<n){
            dp[0][i++] = 0;
        }

        for (i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //若某位置有障碍，则将该位置的路径条数置为0
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
// @lc code=end

