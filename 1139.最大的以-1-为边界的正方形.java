/*
 * @lc app=leetcode.cn id=1139 lang=java
 *
 * [1139] 最大的以 1 为边界的正方形
 */

// @lc code=start
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        //申明一个三维数组，来记录（i,j）点的左边和上边以及自身连续1的个数
        //dp[i][j][0]表示（i，j）左边的来连续1,dp[i][j][1]表示（i，j）表示上边的连续1
        //额外申请+1空间，方便同意处理
        int[][][] dp = new int[m+1][n+1][2];
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <= n; j++) {
                if(grid[i-1][j-1] == 1){
                    dp[i][j][0] = 1 + dp[i][j-1][0];
                    dp[i][j][1] = 1 + dp[i-1][j][1];
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //找到以(i,j)点为右下角，可以存在的最大正方形边长，然后判断是否能构成正方形
                for (int size = Math.min(dp[i][j][0], dp[i][j][1]); size > 0; size--) {
                    int a = dp[i][j-size+1][1], b = dp[i-size+1][j][0];
                    if(a >= size && b >= size){
                        //更新最大边长，找到当前节点的最大正方形边长，即可跳出该节点的循环
                        res = Math.max(res, size);
                        break;
                    }
                }
            }
        }
        return res*res;
    }
}
// @lc code=end

