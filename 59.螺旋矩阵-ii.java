/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        //初始化n*n矩阵
        int[][] res = new int[n][n];
        //定义矩阵的各边界
        int up = 0, down = n-1, left = 0, right = n-1;
        //记录值，从1~n*2
        int count = 1;
        while(true){
            for(int i = left; i <= right; i++) res[up][i] = count++;
            if(++up > down) break;
            for (int i = up; i <= down; i++) res[i][right] = count++;
            if(--right < left) break;
            for(int i = right; i >= left; i--) res[down][i] = count++;
            if(--down < up) break;
            for(int i = down; i >= up; i--) res[i][left] = count++;
            if(++left > right) break;
        }
        return res;
    }
}
// @lc code=end

