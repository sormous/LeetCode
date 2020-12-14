/*
 * @lc app=leetcode.cn id=908 lang=java
 *
 * [908] 最小差值 I
 */

// @lc code=start
/**
 * 要获得最大值与最小值之间的最小差值，那么则需要最小化max(B)-min(B)
 * max(B)最小为max(A)-K, min(B)最大为min(A)+K
 * 所以结果res = (max(A) - K) - (min(A) + K)
 */
class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int a : A) {
            min = Math.min(a, min);
            max = Math.max(a, max);
        }
        return Math.max(0, max - min -2*K);
    }
}
// @lc code=end

