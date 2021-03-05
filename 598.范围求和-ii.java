/*
 * @lc app=leetcode.cn id=598 lang=java
 *
 * [598] 范围求和 II
 */

// @lc code=start
/**
 * 要返回矩阵中含有的最大整数的元素个数，因为总是从左上角开始递增
 * 所以找到每次操作最后的交集，即为包含最大元素的矩阵长宽
 */
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        for(int[] op:ops){
            m = Math.min(op[0], m);
            n = Math.min(op[1], n);
        }
        return m*n;
    }
}
// @lc code=end

