/*
 * @lc app=leetcode.cn id=463 lang=java
 *
 * [463] 岛屿的周长
 */

// @lc code=start
/**
 * 首先每个岛屿网格，边长计数都+4，然后寻找其相邻岛屿网格，
 * 只要其有相邻的网格，那么边长就减2。因为相邻的两个方格，需要分别减去一条边
 **/
 class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    ans += 4;
                    if(i>0 && grid[i-1][j] == 1){
                        ans -= 2;
                    }
                    if(j>0 && grid[i][j-1] == 1){
                        ans -= 2;
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

