/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
/**
 * 二分查找问题
 */
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            //若中间数小于最右边的数，则说明右半部分递增有序，最小值在左半部分，收缩右边界
            //否则在右半部分，收缩左边，从右半部分找到最小值
            if(nums[mid] < nums[r]){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return nums[r];
    }
}
// @lc code=end

