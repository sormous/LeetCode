/*
 * @lc app=leetcode.cn id=1480 lang=java
 *
 * [1480] 一维数组的动态和
 */

// @lc code=start
/**
 * 利用count记录当前位的动态和，遍历数组，
 * 计算每一位的动态和为当前数字+前一位的动态和
 */
class Solution {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            res[i] = count;
        }
        return res;
    }
}
// @lc code=end

