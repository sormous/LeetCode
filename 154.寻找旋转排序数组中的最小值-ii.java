/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) return 0;
        int l = 0;
        int r = nums.length-1;
        while(l < r){
            int mid = l+(r-l)/2;
            if(nums[mid] < nums[r]){
                r = mid;
            }
            else if(nums[mid] > nums[r]){
                l = mid+1;
            }else{
                r--;
            }
        }
        return nums[l];
    }
}
// @lc code=end

