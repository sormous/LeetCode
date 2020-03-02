/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        int mid = (l + r) / 2;
        while(l <= r && nums[mid] != target){
            if(target > nums[mid]){
                l = mid + 1;
                mid = (l + r) / 2;
            }
            else{
                r = mid - 1;
                mid = (l + r) / 2;
            }
        }
        if(target <= nums[mid]){
            return mid;
        }
        else{
            return mid+1;
        }
    }
}
// @lc code=end

