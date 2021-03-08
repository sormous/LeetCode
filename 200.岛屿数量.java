/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
/**
 * 利用dfs计算连通分量的数量
 */
class Solution {
    private int raw;
    private int col;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        raw = grid.length;
        col = grid[0].length;
        int res = 0;
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < col; j++) {
                //当前位置的值为1时，则进行dfs，将该连通分量的所有位置置0
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int r, int c){
        if(r<0 || r>=raw || c<0 || c>=col || grid[r][c] == '0'){
            return ;
        }
        //遍历过的位置则置0
        grid[r][c] = '0';
        for (int[] d : directions) {
            dfs(grid, r+d[0], c+d[1]);
        }
    }
}
// @lc code=end

