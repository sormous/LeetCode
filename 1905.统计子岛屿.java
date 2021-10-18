/*
 * @lc app=leetcode.cn id=1905 lang=java
 *
 * [1905] 统计子岛屿
 */

// @lc code=start
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //如果矩阵2中存在的陆地在矩阵1中不是陆地，则该岛屿必不是子岛
                //则直接利用dfs将它淹没
                if(grid1[i][j] == 0 && grid2[i][j] == 1){
                    dfs(grid2, i, j);
                }
            }
        }
        //上述判断完成之后，矩阵2中剩下的岛屿肯定为矩阵1中的子岛
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid2[i][j] == 1){
                    res++;
                    dfs(grid2, i, j);
                }
            }
        }
        return res;
    }

    //利用dfs算法，从(i,j)开始将与之相邻构建的岛屿淹没
    public void dfs(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i<0 || j<0 || i>=m || j>= n){
            return ;
        }
        if(grid[i][j] == 0){
            return ;
        }
        grid[i][j] = 0;
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
// @lc code=end

