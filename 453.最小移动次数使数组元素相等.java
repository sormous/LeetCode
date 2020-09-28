import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=453 lang=java
 *
 * [453] 最小移动次数使数组元素相等
 */

// @lc code=start
/**
 *  n-1个数同时加一，就好比每次有一个数自身减一，
 * 因为只能做减法，所以数组最后的数只能是最小值。
 * 这样的话每个元素减去最小值求其和就是答案
 */
class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        int min = nums[0];
        for (int num : nums) {
            sum += num - min;
        }
        return sum;
    }
}
// @lc code=end

