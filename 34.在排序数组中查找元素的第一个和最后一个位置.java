/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
/**
 * 利用二分思想找到左右边界
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0, r=nums.length-1;
        int[] res = {-1, -1};
        if(nums.length == 0) return res;
        //首先寻找左边界
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] < target){
                l = mid+1;
            }else if(nums[mid] > target){
                r = mid-1;
            }else if(nums[mid] == target){
                r = mid-1;
            }
        }
        //如果不存在目标值，则直接返回初始值
        if(l >= nums.length || nums[l] != target) return res;
        res[0] = l;
        
        //再寻找右边界
        r = nums.length-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] < target){
                l = mid+1;
            }else if(nums[mid] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        res[1] = r;

        return res;
    }
}
// @lc code=end

