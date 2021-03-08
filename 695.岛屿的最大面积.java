/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    private int raw, col;
    //存储可移动的方向，水平或者垂直
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        raw = grid.length;
        col = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < col; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    //需要传入数组，为了遍历时进行修改，标记以访问过的节点
    private int dfs(int[][] grid, int r, int c){
        //若数组越界或当前位置值为0，则直接返回0
        if(r<0 || r>=raw || c<0 || c>=col || grid[r][c] == 0){
            return 0;
        }
        //数组值置0，标记该位置已访问过
        grid[r][c] = 0;
        int area = 1;
        for (int[] d : directions) {
            //深度优先遍历，得到所能达到的最大面积
            area += dfs(grid, r+d[0], c+d[1]);
        }
        return area;
    }
}
// @lc code=end

