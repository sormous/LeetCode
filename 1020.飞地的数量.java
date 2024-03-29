/*
 * @lc app=leetcode.cn id=1020 lang=java
 *
 * [1020] 飞地的数量
 */

// @lc code=start
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        //首先将第一行和第m行中靠边的节点置0
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m-1, j);
        }
        //然后将第1列和第n列靠边的节点置0
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n-1);
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    res++;
                }
            }
        }
        return res;
    }

    //利用dfs算法将某一个陆地连通域置0，可以避免额外利用visited数组记录以访问过的节点
    public void dfs(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n){
            return ;
        }
        if(grid[i][j] == 0){
            return ;
        }
        grid[i][j] = 0;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
// @lc code=end

