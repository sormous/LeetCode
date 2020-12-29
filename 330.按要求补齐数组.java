/*
 * @lc app=leetcode.cn id=330 lang=java
 *
 * [330] 按要求补齐数组
 */

// @lc code=start
/**
 * 对于正整数 x，如果区间 [1,x-1] 内的所有数字都已经被覆盖，
 * 且 x 在数组中，则区间 [1,2x-1] 内的所有数字也都被覆盖。
 * 
 */
class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length, index = 0;
        while(x <= n){
            if(index < length && nums[index] <= x){
                x += nums[index];
                index++;
            }else{
                x *= 2;
                patches++;
            }
        }
        return patches;
    }
}
// @lc code=end

