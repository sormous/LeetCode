/*
 * @lc app=leetcode.cn id=598 lang=java
 *
 * [598] 范围求和 II
 */

// @lc code=start
/**
 * 因为每次操作，进行增加都是从左上角开始进行
 * 所以最后得到的最大的数值一定是一系列操作的交集；
 * 即是找出所有操作中的最小值，即为包含增加次数最多的个数 */ 
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        for(int[] op:ops){
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m*n;
    }
}
// @lc code=end

