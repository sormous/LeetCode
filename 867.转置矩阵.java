/*
 * @lc app=leetcode.cn id=867 lang=java
 *
 * [867] 转置矩阵
 */

// @lc code=start
class Solution {
    public int[][] transpose(int[][] A) {
        //转置矩阵，及将矩阵的行列元素互换
        int R = A.length, C = A[0].length;
        //声明一个C行，R列的新数组用来记录答案
        int[][] res = new int[C][R];
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                res[c][r] = A[r][c];
            }
        }
        return res;
    }
}
// @lc code=end

