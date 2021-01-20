import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=628 lang=java
 *
 * [628] 三个数的最大乘积
 */

// @lc code=start
/**
 * 该类问题有两种情况：
 * 1.要么答案是排序后数组，最大的三个数值进行相乘得到的值
 * 2.或者是最小的两个负数相乘再乘以最大的一个数得到的结果，两者进行比较；
 * 返回较大的那一个
 */
class Solution {
    public int maximumProduct(int[] nums) {
        int tmp = 1;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        Arrays.sort(nums);
        tmp = nums[n-1] * nums[n-2] * nums[n-3];
        max = tmp;
        tmp = nums[0]*nums[1]*nums[n-1];
        if(tmp > max) max = tmp;
        return max;
    }   
}
// @lc code=end

