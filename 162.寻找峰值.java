/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
/**
 *   题目已经要求相邻的数是不相等了
 *   所以相邻的数只有两种情况：
 *   nums[mid] > nums[mid + 1] 或 nums[mid] < nums[mid + 1]
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            //左边值大，说明左边存在峰值，可能mid就是
            if(nums[mid] > nums[mid+1]){
                right = mid;
            }
            //右边值大，说明右边存在峰值
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end

